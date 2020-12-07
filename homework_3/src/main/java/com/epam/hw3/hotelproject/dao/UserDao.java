package com.epam.hw3.hotelproject.dao;

import com.epam.hw3.hotelproject.model.User;

public interface UserDao {
    public User getUser(String username, String password);

}
