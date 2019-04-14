package com.pracownia.spring.services;

import com.pracownia.spring.entities.Address;

public interface AddressService {

    Iterable<Address> listAllAddresses();

    Address getAddressById(Integer id);

    Address saveAddress(Address adress);

    void deleteAddress(Integer id);

    Boolean checkIfExist(Integer id);

    Integer count();

    public Iterable<Address> listAllAddressesPaging(Integer pageNr, Integer howManyOnPage);

}
