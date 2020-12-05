package com.epam.hw2.hotelproject.dao;

import com.epam.hw2.hotelproject.model.User;

public interface ClientDao {
    Integer getClientId(User user);
}
