package com.epam.hw4.dao;

import com.epam.hw4.model.User;

public interface ClientDao {
    Integer getClientId(User user);
}
