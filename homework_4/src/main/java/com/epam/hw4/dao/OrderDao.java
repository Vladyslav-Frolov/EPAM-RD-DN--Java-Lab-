package com.epam.hw4.dao;

import com.epam.hw4.model.Order;
import com.epam.hw4.model.OrderImpl;
import com.epam.hw4.model.User;

import java.util.List;

public interface OrderDao {
    boolean insertNewOrder(Order order);

    int getLastOrderId();

    List<OrderImpl> getUserOrders(User registeredUser);
}
