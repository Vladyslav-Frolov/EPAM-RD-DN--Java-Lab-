package com.epam.hw3.hotelproject.dao;

import com.epam.hw3.hotelproject.model.Order;
import com.epam.hw3.hotelproject.model.OrderImpl;
import com.epam.hw3.hotelproject.model.User;

import java.util.List;

public interface OrderDao {
    boolean insertNewOrder(Order order);

    int getLastOrderId();

    List<OrderImpl> getUserOrders(User registeredUser);
}
