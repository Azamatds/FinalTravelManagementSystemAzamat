package com.example.travelmanagementsystemazamat.Repository;

import com.example.travelmanagementsystemazamat.Entities.Airplane;

import java.util.List;
import java.util.Optional;

public interface AirplaneRepository  {
    List<Airplane> gettAllData();

    Optional<Airplane> getByName(String name);

    void save(Airplane airplane);
}
