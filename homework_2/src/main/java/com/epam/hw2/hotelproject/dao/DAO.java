package com.epam.hw2.hotelproject.dao;

import javax.swing.text.html.parser.Entity;
import java.util.List;

interface DAO<K, T extends Entity> {

    public abstract boolean create(T entity);

    public abstract List<T> findAll();

    public abstract T findEntityById(K id);

    public abstract T update(T entity);

    public abstract boolean delete(K id);

    public abstract boolean delete(T entity);
}
