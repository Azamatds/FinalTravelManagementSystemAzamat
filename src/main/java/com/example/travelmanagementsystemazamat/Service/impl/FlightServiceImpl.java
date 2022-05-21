package com.example.travelmanagementsystemazamat.Service.impl;

import com.example.travelmanagementsystemazamat.Entities.Flight;
import com.example.travelmanagementsystemazamat.Repository.FlightRepository;
import com.example.travelmanagementsystemazamat.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.getAll();
    }

    @Override
    public Optional<Flight> getFlight(int id) {
        return flightRepository.getById(id);
    }

    @Override
    public void deleteFlight(int id) {
        flightRepository.deleteById(id);
    }

    @Override
    public void save(Flight user) {
        flightRepository.save(user);
    }
}
