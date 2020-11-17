package com.epam.finalproject.hotel.dao;

import com.epam.finalproject.hotel.model.Order;
import com.epam.finalproject.hotel.model.RoomStatus;
import com.epam.finalproject.hotel.model.User;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private static final Logger LOGGER = Logger.getLogger(OrderDao.class);
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

    public List<Order> getUserOrders(User registeredUser) {
        LOGGER.debug("getUserOrders starts");
        List<Order> orders = new ArrayList<>();

        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_SELECT_USER_ORDERS)) {

            int k = 1;
            ps.setInt(k, new ClientDao().getClientId(registeredUser));

            try (ResultSet rs = ps.executeQuery()) {
                OredersOfUserItemMapper mapper = new OredersOfUserItemMapper();
                while (rs.next()) {
                    orders.add(mapper.mapRow(rs));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.debug("getUserOrders finished");
        return orders;
    }

    private static class OredersOfUserItemMapper {

        private Order mapRow(ResultSet rs) {
            LOGGER.debug("mapRow starts");
            Order order = new Order();

            try {
                order.setId(rs.getInt("id"));
                order.setRoomId(rs.getInt("room number"));
                order.setRoomType(rs.getString("room type"));
                order.setRoomClass(rs.getString("room class"));
                order.setCheckIn(rs.getString("in"));
                order.setCheckOut(rs.getString("out"));
                order.setDays(rs.getInt("days"));
                order.setCostPerDay(rs.getDouble("cost"));
                order.setTotalPrice(rs.getDouble("total"));
                order.setOrderStatus(RoomStatus.values()[rs.getInt("status id") - 1]);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            LOGGER.debug("mapRow finished");
            return order;
        }
    }
}
