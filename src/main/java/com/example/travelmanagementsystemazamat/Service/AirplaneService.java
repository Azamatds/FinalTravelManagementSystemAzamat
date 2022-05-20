package com.example.travelmanagementsystemazamat.Service;

import com.example.travelmanagementsystemazamat.Entities.Airplane;

import java.util.List;
import java.util.Optional;

public interface AirplaneService {
    List<Airplane> gettAllData();

    Optional<Airplane> getByName(String name);

    void save(Airplane airplane);
}
