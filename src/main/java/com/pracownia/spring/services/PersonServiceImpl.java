package com.pracownia.spring.services;

import com.pracownia.spring.entities.Person;
import com.pracownia.spring.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Iterable<Person> listAllPersonsPaging(Integer pageNr, Integer howManyOnPage) {
        return personRepository.findAll(new PageRequest(pageNr,howManyOnPage));
    }

    @Override
    public Iterable<Person> listAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(Integer id) {
        return personRepository.findOne(id);
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(Integer id) {
        personRepository.delete(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        return personRepository.checkIfExist(id);
    }

    @Override
    public Integer count(){
        return personRepository.Count();
    }

    public void setProductRepository(PersonRepository rep) {
        this.personRepository = rep;
    }
}
