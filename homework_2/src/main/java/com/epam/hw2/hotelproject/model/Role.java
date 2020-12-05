package com.epam.hw2.hotelproject.model;

import org.springframework.stereotype.Component;

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
