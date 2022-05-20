package com.example.travelmanagementsystemazamat.Controller;

import com.example.travelmanagementsystemazamat.Entities.Flight;
import com.example.travelmanagementsystemazamat.Entities.User;
import com.example.travelmanagementsystemazamat.Repository.FlightRepository;
import com.example.travelmanagementsystemazamat.Service.impl.JDBCUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    private final JDBCUserServiceImpl jdbcUserService;

    private final FlightRepository repository;

//    @Autowired
//    private JDBCUserService userService;

    @Autowired
    public UserController(JDBCUserServiceImpl jdbcUserService, FlightRepository repository) {
        this.jdbcUserService = jdbcUserService;
        this.repository = repository;
    }


    @GetMapping("/all")
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(jdbcUserService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/allByFlight")
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ResponseEntity<List<Flight>> getAllUFlights(){
        return new ResponseEntity<>(repository.getAll(),HttpStatus.OK);
    }



    @PostMapping("/addUser")
    public ResponseEntity<Void> addTicket(@RequestBody User user){
        jdbcUserService.save(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
