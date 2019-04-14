package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.House;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends CrudRepository<House, Integer>, PagingAndSortingRepository<House, Integer> {

    House findByHouseId(String productId);

    @Query("select count(*) from Houses p where p.id = ?1")
    Boolean checkIfExist(Integer id);

    @Query("select count(*) from Houses p")
    Integer Count();
}
