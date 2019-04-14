package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer>, PagingAndSortingRepository<Item, Integer> {

    Item findByItemId(String productId);

    @Query("select count(*) from Items p where p.id = ?1")
    Boolean checkIfExist(Integer id);

    @Query("select count(*) from Items p")
    Integer Count();


}
