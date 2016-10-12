package com.itea.dao;

public interface EntityDao<T> {
    void insert(T value);
    T find(long id);
}
