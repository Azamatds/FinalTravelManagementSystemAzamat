package com.example.travelmanagementsystemazamat.Controller;

import com.example.travelmanagementsystemazamat.Entities.Flight;
import com.example.travelmanagementsystemazamat.Service.FlightService;
import com.example.travelmanagementsystemazamat.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private final FlightService service;

    @Autowired
    public FlightController(FlightService service) {
        this.service = service;
    }

    @GetMapping("/allByFlight")
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity<>(service.getAllFlights(),HttpStatus.OK);
    }

    @PostMapping("/addFlight")
    public ResponseEntity<Void> addFlight(@RequestBody Flight flight){
        service.save(flight);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteFlight{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable int id){
        service.deleteFlight(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
