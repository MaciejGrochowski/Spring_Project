package com.pracownia.spring.services;

import com.pracownia.spring.entities.Name;
import com.pracownia.spring.repositories.NameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class NameServiceImpl implements NameService {

    @Autowired
    private NameRepository nameRepository;

    @Override
    public Iterable<Name> listAllNamesPaging(Integer pageNr, Integer howManyOnPage) {
        return nameRepository.findAll(new PageRequest(pageNr,howManyOnPage));
    }

    @Override
    public Iterable<Name> listAllNames() {
        return nameRepository.findAll();
    }

    @Override
    public Name getNameById(Integer id) {
        return nameRepository.findOne(id);
    }

    @Override
    public Name saveName(Name product) {
        return nameRepository.save(product);
    }

    @Override
    public void deleteName(Integer id) {
        nameRepository.delete(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        return nameRepository.checkIfExist(id);
    }

    @Override
    public Integer count(){
        return nameRepository.Count();
    }

    public void setProductRepository(NameRepository rep) {
        this.nameRepository = rep;
    }
}
