package com.example.travelmanagementsystemazamat.Repository;

import com.example.travelmanagementsystemazamat.Entities.Airplane;

import java.util.List;
import java.util.Optional;

public interface FlightRepository extends GenerallRepository{

    List<Optional<Airplane>> getAirplanesById(int airplane_id);

}
