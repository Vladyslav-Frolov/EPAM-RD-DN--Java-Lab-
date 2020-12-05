package com.epam.hw2.hotelproject.model;

import org.springframework.stereotype.Component;

public enum RoomStatus {
    UNAVAILABLE("ќждаетс€ подтверждение"), EXPIRED, BOOKED, OCCUPIED, COMPLETED;

    String name;
    RoomStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name().toLowerCase();
    }

    @Override
    public String toString() {
        return getName();
    }

    RoomStatus() {
    }
}
