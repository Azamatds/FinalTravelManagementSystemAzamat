package com.example.travelmanagementsystemazamat.Repository.impl;

import com.example.travelmanagementsystemazamat.Entities.Airplane;
import com.example.travelmanagementsystemazamat.Entities.Flight;
import com.example.travelmanagementsystemazamat.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class FlightRepositoryImpl implements FlightRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FlightRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Optional<Airplane>> getAirplanesById(int airplane_id) {
        return jdbcTemplate.query("select airplane.name,flight.flight_id" +
                " from airplane, flight" +
                " where airplane.airplane_id = flight.airplane_id",(rs,rowNum) ->
                Optional.of(new Airplane(
                        rs.getInt("airplane_id"),
                        rs.getString("name")
                )),airplane_id);
    }

    @Override
    public void save(Object object) {
        Flight flight = (Flight) object;
        jdbcTemplate.update("insert into flight (arrival_time,arrival_date,destination,airplane,airplane_id) values(?,?,?,?,?)",
                flight.getArrival_time(),flight.getArrival_date(),
                flight.getDestination(),flight.getAirplane(),flight.getAirplane().getId());
    }

    @Override
    public void update(Object object) {
        Flight flight = (Flight) object;
        jdbcTemplate.update("update flight set arrival_time = ? ,arrival_date =? , destination =?,airplane =?",
                flight.getArrival_time(),flight.getArrival_time(),
                flight.getArrival_date(), flight.getDestination(),flight.getAirplane()
                );
    }

    @Override
    public List<Flight> getAll() {
        return jdbcTemplate.query("select * from flight",(rs,row)->
                new Flight(
                        rs.getInt("flight_id"),
                        rs.getString("arrival_time"),
                        rs.getString("arrival_date"),
                        rs.getString("destination")
                ));
    }

    @Override
    public Optional getById(int id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Optional getByName(String name) {
        return Optional.empty();
    }
}
