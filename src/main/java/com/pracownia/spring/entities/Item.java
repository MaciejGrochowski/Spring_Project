package com.pracownia.spring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;

@Entity(name="Items")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "refId", scope = Item.class)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String itemId;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "owner", referencedColumnName = "id")
    Person owner;

    @Column(name = "name")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    private String description;

    public Item() {}

    public Integer getId() {
        return id;
    }

    public void setId(String id){
        this.itemId = id;
    }

    public Item(Person owner, String name, String description) {
        this.owner = owner;
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
