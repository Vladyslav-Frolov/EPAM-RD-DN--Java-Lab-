package com.epam.hw3.model;

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
