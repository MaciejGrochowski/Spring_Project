package com.pracownia.spring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Addresses")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "refId", scope = Address.class)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String addressId;

    @Column(nullable = false)
    String street;

    @Column(nullable = false)
    String city;

    @Column(length = 5, nullable = false)
    String nr;

    @Column(length = 5)
    String housenr;

    @Column(length = 10, nullable = false)
    String postcode;

    public Address() {}

    public Address(String street, String city, String nr, String housenr, String postcode) {
        this.street = street;
        this.city = city;
        this.nr = nr;
        this.housenr = housenr;
        this.postcode = postcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getHousenr() {
        return housenr;
    }

    public void setHousenr(String housenr) {
        this.housenr = housenr;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }


}

