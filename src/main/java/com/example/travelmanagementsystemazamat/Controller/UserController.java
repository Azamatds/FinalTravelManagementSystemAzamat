package com.example.travelmanagementsystemazamat.Controller;

import com.example.travelmanagementsystemazamat.Entities.Flight;
import com.example.travelmanagementsystemazamat.Entities.User;
import com.example.travelmanagementsystemazamat.Repository.FlightRepository;
import com.example.travelmanagementsystemazamat.Service.impl.JDBCUserServiceImpl;
import com.example.travelmanagementsystemazamat.errors.ResourceNotFoundException;
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
    public ResponseEntity<List<User>> getAllFlights() throws ResourceNotFoundException{
        return new ResponseEntity<>(jdbcUserService.getAllUsers(),HttpStatus.OK);
    }





    @PostMapping("/addUser")
    public ResponseEntity<Void> addUser(@RequestBody User user) throws ResourceNotFoundException{
        jdbcUserService.save(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/userById/{id}")
    public Optional<User> getById(@PathVariable int id){
        return jdbcUserService.getUser(id);
    }



    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable int id
    ){
        jdbcUserService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

}
