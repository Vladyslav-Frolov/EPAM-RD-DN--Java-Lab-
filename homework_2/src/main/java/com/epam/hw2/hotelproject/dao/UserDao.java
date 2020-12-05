package com.epam.hw2.hotelproject.dao;

import com.epam.hw2.hotelproject.model.User;

public interface UserDao {
    public User getUser(String username, String password);

}
