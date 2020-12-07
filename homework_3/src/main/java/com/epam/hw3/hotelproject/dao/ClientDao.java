package com.epam.hw3.hotelproject.dao;

import com.epam.hw3.hotelproject.model.User;

public interface ClientDao {
    Integer getClientId(User user);
}
