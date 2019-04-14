package com.pracownia.spring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;
import java.util.*;

@Entity(name="Houses")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "refId", scope = House.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String houseId;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "address", referencedColumnName = "id")
    private Address address;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "house", fetch = FetchType.LAZY)
    private Set<Person> people = new HashSet<Person>();

    public House() {}

    public House(String houseId, Address address, String description) {
        this.houseId = houseId;
        this.address = address;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void SetHouseId(String id){
        this.houseId = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }
}