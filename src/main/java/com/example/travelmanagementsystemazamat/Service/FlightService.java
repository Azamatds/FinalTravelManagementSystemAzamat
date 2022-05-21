package com.example.travelmanagementsystemazamat.Service;

import com.example.travelmanagementsystemazamat.Entities.Flight;

import java.util.List;
import java.util.Optional;

public interface FlightService {
    List<Flight> getAllFlights();

    Optional<Flight> getFlight(int id);

    void deleteFlight(int id);


    void save(Flight user);

}
