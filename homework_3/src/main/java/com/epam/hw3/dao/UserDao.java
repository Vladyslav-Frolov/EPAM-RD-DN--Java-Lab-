package com.epam.hw3.dao;

import com.epam.hw3.model.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.epam.hw3.model.Role.*;

public class UserDao {
    private static final Logger LOGGER = Logger.getLogger(UserDao.class);
    private static final String SQL_FIND_USER =
            "SELECT u.id `id`,\n" +
                    "u.login `login`,\n" +
                    "u.email `email`,\n" +
                    "u.password `password`,\n" +
                    "u.create_time `create_time`,\n" +
                    "u.first_name `first_name`,\n" +
                    "u.last_name `last_name`,\n" +
                    "r.name `name`\n" +
                    "FROM users u\n" +
                    "JOIN roles r on u.role_id = r.id\n" +
                    "WHERE login = ? AND password = ?";

    public User getUser(String username, String password) {
        LOGGER.debug("getUser starts");
        User user = null;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_FIND_USER)) {
            int k = 1;
            ps.setString(k++, username);
            ps.setString(k, password);

            try (ResultSet rs = ps.executeQuery()) {
                UserMapper mapper = new UserMapper();

                while (rs.next()) {
                    user = mapper.mapRow(rs);
                }
            } catch (NullPointerException | SQLException e) {
                e.printStackTrace();
            }

        } catch (NullPointerException | SQLException e) {
            e.printStackTrace();
        }
        LOGGER.debug("getUser finished");
        return user;
    }

    private static class UserMapper {

        private User mapRow(ResultSet rs) {
            LOGGER.debug("mapRow starts");
            User user = new User();
            String role;
            try {
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setCreateTime(rs.getString("create_time"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                role = rs.getString("name");
                if (role.equals("user")) {
                    user.setRole(USER);
                } else {
                    user.setRole(ADMIN);
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
            LOGGER.debug("mapRow finished");
            return user;
        }
    }
}
