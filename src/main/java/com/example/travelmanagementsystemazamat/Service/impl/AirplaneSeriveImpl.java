package com.example.travelmanagementsystemazamat.Service.impl;

import com.example.travelmanagementsystemazamat.Entities.Airplane;
import com.example.travelmanagementsystemazamat.Repository.AirplaneRepository;
import com.example.travelmanagementsystemazamat.Service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirplaneSeriveImpl implements AirplaneService {

    private final AirplaneRepository airplaneRepository;

    @Autowired
    public AirplaneSeriveImpl(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    @Override
    public List<Airplane> gettAllData() {
        return airplaneRepository.gettAllData();
    }

    @Override
    public Optional<Airplane> getByName(String name) {
        return airplaneRepository.getByName(name);
    }

    @Override
    public void save(Airplane airplane) {
        airplaneRepository.save(airplane);

    }
}
