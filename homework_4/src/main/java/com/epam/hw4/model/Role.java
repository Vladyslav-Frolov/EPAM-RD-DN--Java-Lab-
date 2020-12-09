package com.epam.hw4.model;

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
