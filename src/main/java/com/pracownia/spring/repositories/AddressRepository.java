package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer>, PagingAndSortingRepository<Address, Integer> {

    Address findByAddressId(String addressId);

    @Query("select count(*) from Addresses p where p.id = ?1")
    Boolean checkIfExist(Integer id);

    @Query("select count(*) from Addresses p")
    Integer Count();
}
