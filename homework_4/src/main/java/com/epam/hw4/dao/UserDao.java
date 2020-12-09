package com.epam.hw4.dao;

import com.epam.hw4.model.User;

public interface UserDao {
    public User getUser(String username, String password);

}
