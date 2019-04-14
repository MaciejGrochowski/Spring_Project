package com.pracownia.spring.services;

import com.pracownia.spring.entities.Address;
import com.pracownia.spring.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Iterable<Address> listAllAddressesPaging(Integer pageNr, Integer howManyOnPage) {
        return addressRepository.findAll(new PageRequest(pageNr,howManyOnPage));
    }

    @Override
    public Iterable<Address> listAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(Integer id) {
        return addressRepository.findOne(id);
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Integer id) {
        addressRepository.delete(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        return addressRepository.checkIfExist(id);
    }

    @Override
    public Integer count(){
        return addressRepository.Count();
    }


    public void setAddressRepository(AddressRepository rep) {
        this.addressRepository = rep;
    }
}
