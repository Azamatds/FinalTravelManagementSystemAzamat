package com.example.travelmanagementsystemazamat.Repository;

import com.example.travelmanagementsystemazamat.Entities.Airplane;
import com.example.travelmanagementsystemazamat.Entities.Flight;
import com.example.travelmanagementsystemazamat.Entities.FlightClass;

import java.util.List;

public interface FlightClassRepository {

    List<FlightClass> getAllFlightClass();
}
