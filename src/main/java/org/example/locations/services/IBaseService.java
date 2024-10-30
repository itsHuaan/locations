package org.example.locations.services;

import java.util.List;

public interface IBaseService<T, U> {
    List<T> getAll();
    T getById(U id);
}
