package com.pracownia.spring.services;

import com.pracownia.spring.entities.Name;
import org.springframework.stereotype.Service;

@Service
public interface NameService {

    Iterable<Name> listAllNames();

    Name getNameById(Integer id);

    Name saveName(Name product);

    void deleteName(Integer id);

    Boolean checkIfExist(Integer id);

    Integer count();

    public Iterable<Name> listAllNamesPaging(Integer pageNr, Integer howManyOnPage);

}
