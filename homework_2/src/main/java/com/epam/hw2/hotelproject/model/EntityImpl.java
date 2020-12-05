package com.epam.hw2.hotelproject.model;

import java.io.Serializable;

abstract class EntityImpl implements Serializable, Cloneable, Entity {
    private Integer id;
    public EntityImpl() {
    }
    public EntityImpl(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
