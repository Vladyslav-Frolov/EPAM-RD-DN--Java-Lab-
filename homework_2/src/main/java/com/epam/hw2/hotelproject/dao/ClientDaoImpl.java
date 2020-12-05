package com.epam.hw2.hotelproject.dao;

import com.epam.hw2.hotelproject.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ClientDaoImpl implements ClientDao {
    private static final Logger LOGGER = Logger.getLogger(ClientDaoImpl.class);
    private static final String SQL_FIND_CLIENT =
            "SELECT id\n" +
                    "FROM clients\n" +
                    "    WHERE user_id = ?";

    @Override
    public Integer getClientId(User user) {
        LOGGER.debug("getClientId starts");
        int userId = user.getId();
        LOGGER.trace("gc1 - userId in getClientId: " + userId);
        Integer clientId = null;

        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_CLIENT)) {

            ps.setInt(1, userId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    clientId = rs.getInt("id");
                    LOGGER.trace("gc2 - client id: " + clientId);
                }
                return clientId;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.debug("getClientId finished");
        return -1;
    }
}
