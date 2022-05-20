package com.example.travelmanagementsystemazamat.Repository.impl;

import com.example.travelmanagementsystemazamat.Entities.Airplane;
import com.example.travelmanagementsystemazamat.Entities.Flight;
import com.example.travelmanagementsystemazamat.Entities.User;
import com.example.travelmanagementsystemazamat.Repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
@Transactional
public class AirplaneRepositoryImpl implements AirplaneRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AirplaneRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Airplane> gettAllData() {
        return jdbcTemplate.query("select * from airplane where ",(rs,RowNum) ->
                new Airplane(
                        rs.getInt("airplane_id"),
                        rs.getString("name"),
                        rs.getObject("airplane_id",Airplane.class).getFlights()
                ));
    }

    @Override
    public Optional<Airplane> getByName(String name) {
        return jdbcTemplate.queryForObject("select * from airplane where name  = ?",(rs,rowNum)->
                Optional.of(
                        new Airplane(
                                rs.getInt("airplane_id"),
                                rs.getString("name"),
                                rs.getObject("airplane_id",Airplane.class).getFlights()
                        )
                ),name);
    }

    @Override
    public void save(Airplane airplane) {
        jdbcTemplate.update("insert into airplane (name) values(?)",
               airplane.getName());
    }
}
