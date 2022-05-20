package com.example.travelmanagementsystemazamat.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "flight")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private int id;

    @Column(name = "arrival_time")
    private String arrival_time;

    @Column(name = "arrival_date")
    private String arrival_date;

    @Column(name = "destination")
    private String destination;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;

    public Flight(int id, String arrival_time, String arrival_date, String destination) {
        this.id = id;
        this.arrival_time = arrival_time;
        this.arrival_date = arrival_date;
        this.destination = destination;
    }
}
