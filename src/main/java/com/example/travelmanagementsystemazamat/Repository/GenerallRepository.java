package com.example.travelmanagementsystemazamat.Repository;

import com.example.travelmanagementsystemazamat.Entities.User;

import java.util.List;
import java.util.Optional;

public interface GenerallRepository<T> {

    List<T> getAll();

    Optional<T> getById(int id);

    void deleteById(int id);

    Optional<T> getByName(String name);

    void save(T object);

    void update(T object);
}