package org.example.locations.repositories;

import java.util.List;

public interface IBaseRepository<T, U> {
    List<T> getAll();
    T getById(U id);
}
