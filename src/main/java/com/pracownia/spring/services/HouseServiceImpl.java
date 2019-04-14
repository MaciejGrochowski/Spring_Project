package com.pracownia.spring.services;

import com.pracownia.spring.entities.House;
import com.pracownia.spring.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Override
    public Iterable<House> listAllHousesPaging(Integer pageNr, Integer howManyOnPage) {
        return houseRepository.findAll(new PageRequest(pageNr,howManyOnPage));
    }

    @Override
    public Iterable<House> listAllHouses() {
        return houseRepository.findAll();
    }

    @Override
    public House getHouseById(String id) {
        return houseRepository.findByHouseId(id);
    }

    @Override
    public House saveHouse (House house) {
        return houseRepository.save(house);
    }

    @Override
    public void deleteHouse(Integer id) {
        houseRepository.delete(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        return houseRepository.checkIfExist(id);
    }

    @Override
    public Integer count(){
        return houseRepository.Count();
    }

    public void setHouseRepository(HouseRepository rep) {
        this.houseRepository = rep;
    }

}
