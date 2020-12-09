package com.epam.hw4.dao;

import com.epam.hw4.model.FreeRooms;

import java.util.List;

public interface FreeRoomsDao {
    List<FreeRooms> getFreeRooms(String checkIn, String checkOut);
}
