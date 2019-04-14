package com.pracownia.spring.services;

import com.pracownia.spring.entities.Proffesion;

public interface ProffesionService {

    Iterable<Proffesion> listAllProffesions();

    Proffesion getProffesionById(Integer id);

    Proffesion saveProffesion(Proffesion proffesion);

    void deleteProffesion(Integer id);

    Integer count();

    Boolean checkIfExist(Integer id);

    public Iterable<Proffesion> listAllProffesionsPaging(Integer pageNr, Integer howManyOnPage);

}
