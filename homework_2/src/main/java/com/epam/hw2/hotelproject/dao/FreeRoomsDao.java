package com.epam.hw2.hotelproject.dao;

import com.epam.hw2.hotelproject.model.FreeRooms;

import java.util.List;

public interface FreeRoomsDao {
    List<FreeRooms> getFreeRooms(String checkIn, String checkOut);
}
