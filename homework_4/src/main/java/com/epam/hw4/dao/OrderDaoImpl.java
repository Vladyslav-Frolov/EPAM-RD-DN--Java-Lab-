package com.epam.hw4.dao;

import com.epam.hw4.model.Order;
import com.epam.hw4.model.OrderImpl;
import com.epam.hw4.model.RoomStatus;
import com.epam.hw4.model.User;
import com.epam.hw4.timed.Timed;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Timed
public class OrderDaoImpl implements OrderDao{
    private static final Logger LOGGER = Logger.getLogger(OrderDaoImpl.class);
    private static final String SQL_SELECT_LAST_ORDER = "SELECT id FROM order_flow ORDER BY id DESC LIMIT 1";
    private static final String SQL_SELECT_USER_ORDERS =
            "SELECT ofl.id,\n" +
                    "       r.id                                                                                            `room number`,\n" +
                    "       rt.full_name                                                                                    `room type`,\n" +
                    "       rc.name                                                                                         `room class`,\n" +
                    "       ofl.check_in                                                                                    `in`,\n" +
                    "       ofl.check_out                                                                                   `out`,\n" +
                    "       CAST((UNIX_TIMESTAMP(ofl.check_out) - UNIX_TIMESTAMP(ofl.check_in)) / (60 * 60 * 24) as SIGNED) 'days',\n" +
                    "       cost_per_day                                                                                    `cost`,\n" +
                    "       total_price                                                                                     `total`,\n" +
                    "       room_order_status_id                                                                            `status id`\n" +
                    "\n" +
                    "FROM order_flow ofl\n" +
                    "         JOIN rooms r on ofl.room_id = r.id\n" +
                    "         JOIN statuses s on ofl.room_order_status_id = s.id\n" +
                    "         JOIN room_classes rc on r.class_id = rc.id\n" +
                    "         JOIN room_types rt on r.type_id = rt.id\n" +
                    "\n" +
                    "WHERE client_id = ?;";
    private static final String SQL_INSERT_ORDER =
            "INSERT INTO `hotel`.`order_flow`\n" +
                    "(`id`, `application_id`, `staff_id`, " +
                    "`client_id`, `room_id`, `check_in`, `check_out`, `total_price`, `payment_status`, `start_booking`, `room_order_status_id`)\n" +
                    "VALUES (?, null, null, " +
                    "?, ?, ?, ?, ?, ?, ?, ?)";

    @Override
    public boolean insertNewOrder(Order order) {
        LOGGER.debug("insertNewOrder starts");
        LOGGER.trace("iNo-1 I entered the command for adding a new order");
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_INSERT_ORDER)) {
            connection.setAutoCommit(false);
            int k = 1;
            ps.setInt(k++, order.getId()); // id (Entity)
            ps.setInt(k++, order.getClientId()); // client_id
            ps.setInt(k++, order.getRoomId()); // room_id
            ps.setString(k++, order.getCheckIn()); // check_in
            ps.setString(k++, order.getCheckOut()); // check_out
            ps.setDouble(k++, order.getTotalPrice()); // total_price
            ps.setString(k++, order.getPaymentStatus().toString().toUpperCase()); // payment_status
            ps.setString(k++, order.getStartBookingTime()); // start_booking datetime
            ps.setInt(k, order.getOrderStatus().ordinal() + 1); // room_order_status_id

            if (ps.executeUpdate() != 1) {
                return false;
            }
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.trace("iNo-2 I left the command for adding a new order");
        LOGGER.debug("insertNewOrder finished");
        return true;
    }
    @Override
    public int getLastOrderId() {
        LOGGER.debug("getLastOrderId starts");
        int id = 0;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_SELECT_LAST_ORDER);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                id = rs.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.debug("getLastOrderId finished");
        return id;
    }
    @Override
    public List<OrderImpl> getUserOrders(User registeredUser) {
        LOGGER.debug("getUserOrders starts");
        List<OrderImpl> orderImpls = new ArrayList<>();

        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_SELECT_USER_ORDERS)) {

            int k = 1;
            ps.setInt(k, new ClientDaoImpl().getClientId(registeredUser));

            try (ResultSet rs = ps.executeQuery()) {
                OredersOfUserItemMapper mapper = new OredersOfUserItemMapper();
                while (rs.next()) {
                    orderImpls.add(mapper.mapRow(rs));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.debug("getUserOrders finished");
        return orderImpls;
    }

    private static class OredersOfUserItemMapper {

        private OrderImpl mapRow(ResultSet rs) {
            LOGGER.debug("mapRow starts");
            OrderImpl orderImpl = new OrderImpl();

            try {
                orderImpl.setId(rs.getInt("id"));
                orderImpl.setRoomId(rs.getInt("room number"));
                orderImpl.setRoomType(rs.getString("room type"));
                orderImpl.setRoomClass(rs.getString("room class"));
                orderImpl.setCheckIn(rs.getString("in"));
                orderImpl.setCheckOut(rs.getString("out"));
                orderImpl.setDays(rs.getInt("days"));
                orderImpl.setCostPerDay(rs.getDouble("cost"));
                orderImpl.setTotalPrice(rs.getDouble("total"));
                orderImpl.setOrderStatus(RoomStatus.values()[rs.getInt("status id") - 1]);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            LOGGER.debug("mapRow finished");
            return orderImpl;
        }
    }
}
