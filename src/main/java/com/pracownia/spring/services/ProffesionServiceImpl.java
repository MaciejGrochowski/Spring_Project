package com.pracownia.spring.services;

import com.pracownia.spring.entities.Proffesion;
import com.pracownia.spring.repositories.ProffesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class ProffesionServiceImpl implements ProffesionService {

    @Autowired
    private ProffesionRepository proffesionRepository;

    @Override
    public Iterable<Proffesion> listAllProffesionsPaging(Integer pageNr, Integer howManyOnPage) {
        return proffesionRepository.findAll(new PageRequest(pageNr,howManyOnPage));
    }

    @Override
    public Iterable<Proffesion> listAllProffesions() {
        return proffesionRepository.findAll();
    }

    @Override
    public Proffesion getProffesionById(Integer id) {
        return proffesionRepository.findOne(id);
    }

    @Override
    public Proffesion saveProffesion(Proffesion proffesion) {
        return proffesionRepository.save(proffesion);
    }

    @Override
    public void deleteProffesion(Integer id) {
        proffesionRepository.delete(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        return proffesionRepository.checkIfExist(id);
    }

    @Override
    public Integer count(){
        return proffesionRepository.Count();
    }

    public void setProductRepository(ProffesionRepository rep) {
        this.proffesionRepository = rep;
    }
}
