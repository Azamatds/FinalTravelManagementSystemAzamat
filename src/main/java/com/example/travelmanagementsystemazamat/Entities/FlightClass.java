package com.example.travelmanagementsystemazamat.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "flightClass")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private int id;

    @Column(name = "name")
    private String name;
}
