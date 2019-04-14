package com.pracownia.spring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;
import java.util.*;

@Entity(name="Proffesions")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "refId", scope = Proffesion.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Proffesion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String proffesionId;

    @Column(name = "name", unique = true)
    private String name;


    @OneToMany(mappedBy = "prof", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Person> children = new HashSet<Person>();

    @Column(name = "salary")
    private int salary;

    public Proffesion() {}

    public Proffesion(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
