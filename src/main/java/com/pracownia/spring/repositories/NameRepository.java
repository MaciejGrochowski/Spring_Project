package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Name;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameRepository extends CrudRepository<Name, Integer>, PagingAndSortingRepository<Name, Integer> {

   Name findByNameId(String productId);

    @Query("select count(*) from Names p where p.id = ?1")
    Boolean checkIfExist(Integer id);

    @Query("select count(*) from Names p")
    Integer Count();


}
