package com.epam.hw3.hotelproject.model;

public enum Role {
    USER, ADMIN;

    public String getName() {
        return name().toLowerCase();
    }

    @Override
    public String toString() {
        return getName();
    }
}
