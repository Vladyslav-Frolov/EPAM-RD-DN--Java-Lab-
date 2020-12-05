package com.epam.hw3.dao;

import com.epam.hw3.model.FreeRooms;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FreeRoomsDao {
    private static final Logger LOGGER = Logger.getLogger(FreeRoomsDao.class);
    private static final String SQL_FIND_FREE_ROOMS = "SELECT r.id                                                                                           'id',\n" +
            "       rt.full_name                                                                                   'room type',\n" +
            "       rc.name                                                                                        'room classes',\n" +
            "       rt.number_of_adults + rt.number_of_children                                                    'num',\n" +
            "       rt.number_of_adults                                                                            'adults',\n" +
            "       rt.number_of_children                                                                          'children',\n" +
            "       CAST((UNIX_TIMESTAMP(?) - UNIX_TIMESTAMP(?)) / (60 * 60 * 24) as SIGNED) 'days',\n" +
            "       r.cost_per_day                                                                                 `cost per day`,\n" +
            "       ROUND(((UNIX_TIMESTAMP(?) - UNIX_TIMESTAMP(?)) / (60 * 60 * 24) * r.cost_per_day),\n" +
            "             2)                                                                                       `total price`\n" +
            "FROM rooms r\n" +
            "         JOIN room_classes rc ON r.class_id = rc.id\n" +
            "         JOIN room_types rt ON r.type_id = rt.id\n" +
            "WHERE r.id NOT IN (\n" +
            "    SELECT r.id\n" +
            "    FROM hotel.order_flow ofl\n" +
            "             JOIN rooms r ON ofl.room_id = r.id\n" +
            "    WHERE ofl.check_out > ?\n" +
            "      and ofl.check_in < ?\n" +
            "      and ofl.room_order_status_id IN (1, 3, 4))";


    public List<FreeRooms> getFreeRooms(String checkIn, String checkOut) {
        LOGGER.debug("getFreeRooms starts");
        List<FreeRooms> freeRooms = new ArrayList<>();

        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_FREE_ROOMS)) {

            int k = 1;
            ps.setString(k++, checkOut);
            ps.setString(k++, checkIn);
            ps.setString(k++, checkOut);
            ps.setString(k++, checkIn);
            ps.setString(k++, checkIn);
            ps.setString(k, checkOut);

            try (ResultSet rs = ps.executeQuery()) {
                RoomsItemMapper mapper = new RoomsItemMapper();
                while (rs.next()) {
                    freeRooms.add(mapper.mapRow(rs));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.debug("getFreeRooms finished");
        return freeRooms;
    }


    private static class RoomsItemMapper {

        private FreeRooms mapRow(ResultSet rs) {
            LOGGER.debug("mapRow starts");
            FreeRooms freeRooms = new FreeRooms();

            try {
                freeRooms.setId(rs.getInt("id"));
                freeRooms.setRoomType(rs.getString("room type"));
                freeRooms.setRoomClass(rs.getString("room classes"));
                freeRooms.setNumberOfPeople(rs.getInt("num"));
                freeRooms.setNumberOfAdults(rs.getInt("adults"));
                freeRooms.setNumberOfChildren(rs.getInt("children"));
                freeRooms.setDaysOfStay(rs.getInt("days"));
                freeRooms.setCostPerDay(rs.getDouble("cost per day"));
                freeRooms.setTotalPrice(rs.getDouble("total price"));

            } catch (SQLException e) {
                e.printStackTrace();
            }
            LOGGER.debug("mapRow finished");
            return freeRooms;
        }
    }
}
