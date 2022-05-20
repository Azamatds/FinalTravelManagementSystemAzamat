package com.example.travelmanagementsystemazamat.Service;

import com.example.travelmanagementsystemazamat.Entities.User;

import java.util.List;
import java.util.Optional;

public interface JDBCUserService<T>{

    List<T> getAllUsers();

    Optional<T> getUser(int id);

    void deleteUser(int id);

    Optional<T> getUserByName(String name);

    void save(T user);

    void update(T user);
}
