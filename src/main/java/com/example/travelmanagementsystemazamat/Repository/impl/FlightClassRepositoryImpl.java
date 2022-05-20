package com.example.travelmanagementsystemazamat.Repository.impl;

import com.example.travelmanagementsystemazamat.Entities.Flight;
import com.example.travelmanagementsystemazamat.Entities.FlightClass;
import com.example.travelmanagementsystemazamat.Repository.FlightClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class FlightClassRepositoryImpl implements FlightClassRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FlightClassRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<FlightClass> getAllFlightClass() {
        return jdbcTemplate.query("select * from flightClass",(rw,RowNum)->
                new FlightClass(
                        rw.getInt("class_id"),
                        rw.getString("name")
                ));
    }
}
