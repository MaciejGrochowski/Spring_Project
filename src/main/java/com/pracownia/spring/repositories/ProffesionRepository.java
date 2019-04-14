package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Proffesion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProffesionRepository extends CrudRepository<Proffesion, Integer>, PagingAndSortingRepository<Proffesion, Integer> {

    Proffesion findByProffesionId(String proffesionId);

    @Query("select count(*) from Proffesions p where p.id = ?1")
    Boolean checkIfExist(Integer id);

    @Query("select count(*) from Proffesions p")
    Integer Count();
}
