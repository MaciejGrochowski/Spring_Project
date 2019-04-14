package com.pracownia.spring.services;

import com.pracownia.spring.entities.Person;

public interface PersonService {

    Iterable<Person> listAllPersons();

    Person getPersonById(Integer id);

    Person savePerson(Person person);

    void deletePerson(Integer id);

    Boolean checkIfExist(Integer id);

    Integer count();

    public Iterable<Person> listAllPersonsPaging(Integer pageNr, Integer howManyOnPage);

}
