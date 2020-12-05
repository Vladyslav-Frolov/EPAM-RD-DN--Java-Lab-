package com.epam.hw3.model;

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
