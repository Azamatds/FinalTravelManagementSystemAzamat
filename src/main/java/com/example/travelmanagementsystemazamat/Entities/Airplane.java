package com.example.travelmanagementsystemazamat.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "airplane")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airplane_id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH},
    mappedBy = "airplane")
    private Set<Flight> flights;

    public Airplane(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
