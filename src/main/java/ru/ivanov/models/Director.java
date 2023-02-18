package ru.ivanov.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "director")
public class Director {
     @Id
     @Column(name = "director_id")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

     @Column(name = "name")
     private String name;

     @Column(name = "age")
     private int age;

     @OneToMany(mappedBy = "director")
     private List<Movie> movies;

    public Director(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Director(){}

    @Override
    public String toString() {
        return this.name;
    }
}
