package com.labwork4.DAO;

import java.util.List;

/**
 * @author Arkadiy Maklakov
 */
public interface DAO <T, K> {

    void create(T obj);
    List<T> readAll();
    void update(T obj);
    T read(K key);
    void delete(T obj);

}