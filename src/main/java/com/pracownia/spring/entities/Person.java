package com.pracownia.spring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;
import java.util.*;

@Entity(name = "Persons")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "refId", scope = Person.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String personId;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "name", referencedColumnName = "id")
    Name name;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Proffesion prof;

    @Column(name = "money")
    private int money;

    @ManyToOne(fetch = FetchType.LAZY)
    Person father;

    @ManyToOne(fetch = FetchType.LAZY)
    House house;

    @OneToMany(mappedBy = "father", fetch = FetchType.LAZY)
    private Set<Person> children = new HashSet<Person>();

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "partner", referencedColumnName = "id")
    Person partner;

    public Person() {}

    public Person(Name name, Proffesion prof, int money, Person father, House house, Set<Person> children, Person partner) {
        this.name = name;
        this.prof = prof;
        this.money = money;
        this.father = father;
        this.house = house;
        this.children = children;
        this.partner = partner;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Set<Person> getChildren() {
        return children;
    }

    public void setChildren(Set<Person> children) {
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public Proffesion getProf() {
        return prof;
    }

    public void setProf(Proffesion prof) {
        this.prof = prof;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
