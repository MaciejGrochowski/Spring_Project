package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer>, PagingAndSortingRepository<Person, Integer> {

    Person findByPersonId(String productId);

    @Query("select count(*) from Persons p where p.id = ?1")
    Boolean checkIfExist(Integer id);

    @Query("select count(*) from Persons p")
    Integer Count();

}
