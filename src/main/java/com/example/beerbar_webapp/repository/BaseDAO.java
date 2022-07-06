package com.example.beerbar_webapp.repository;

import java.util.List;
import java.util.Optional;

public interface BaseDAO <T> {

    List<T> findAll() throws ClassNotFoundException;
    Optional<T> findByID(int id);
    boolean create (T entity);
    boolean update (T entity);
    boolean deleteByID (int id);

}
