package com.pracownia.spring.services;

import com.pracownia.spring.entities.House;

public interface HouseService {

    Iterable<House> listAllHouses();

    House getHouseById(String id);

    House saveHouse(House house);

    void deleteHouse(Integer id);

    Boolean checkIfExist(Integer id);

    Integer count();

    public Iterable<House> listAllHousesPaging(Integer pageNr, Integer howManyOnPage);

}
