package com.example.travelmanagementsystemazamat.Controller;

import com.example.travelmanagementsystemazamat.Entities.Airplane;
import com.example.travelmanagementsystemazamat.Entities.User;
import com.example.travelmanagementsystemazamat.Repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("airplane")
public class AirplaneController {

    private final AirplaneRepository airplaneRepository;

    @Autowired
    public AirplaneController(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    @GetMapping("/airplanes")
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ResponseEntity<List<Airplane>> getAllUsers(){
        return new ResponseEntity<>(airplaneRepository.gettAllData(),HttpStatus.OK);
    }

    @PostMapping("/addAirplane")
    public ResponseEntity<Void> addAirplane(@RequestBody Airplane airplane){
        airplaneRepository.save(airplane);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
