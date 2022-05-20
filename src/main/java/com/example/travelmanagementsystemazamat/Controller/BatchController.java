package com.example.travelmanagementsystemazamat.Controller;

import com.example.travelmanagementsystemazamat.Entities.User;
import com.example.travelmanagementsystemazamat.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testBatch")
public class BatchController {

    private final UserRepository userRepository;

    @Autowired
    public BatchController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/with")
    public ResponseEntity<Void> userbatch() {
        userRepository.testBatchUpdate();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
