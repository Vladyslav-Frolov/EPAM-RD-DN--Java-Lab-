package com.epam.finalproject.hotel.model;

import java.io.Serializable;

abstract class Entity implements Serializable, Cloneable {
    private Integer id;
    public Entity() {
    }
    public Entity(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
