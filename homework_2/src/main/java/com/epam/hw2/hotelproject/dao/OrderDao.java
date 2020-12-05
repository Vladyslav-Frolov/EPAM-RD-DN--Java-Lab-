package com.epam.hw2.hotelproject.dao;

import com.epam.hw2.hotelproject.model.Order;
import com.epam.hw2.hotelproject.model.OrderImpl;
import com.epam.hw2.hotelproject.model.User;

import java.util.List;

public interface OrderDao {
    boolean insertNewOrder(Order order);

    int getLastOrderId();

    List<OrderImpl> getUserOrders(User registeredUser);
}
