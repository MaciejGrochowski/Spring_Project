package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.*;
import com.pracownia.spring.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class IndexController {

    @Autowired
    private NameService nameService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private HouseService houseService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private PersonService personService;

    @Autowired
    private ProffesionService proffesionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    String index() {
        return "index";
    }

    @RequestMapping(value = "generateModel", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateModel() {

        LocalDateTime localtDateAndTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime dateAndTime  = ZonedDateTime.of(localtDateAndTime, zoneId);

        Name n1 = new Name("Maciek", "m");
        Name n2 = new Name("Krzysiek", "m");

        Address a1 = new Address("Kocia", "Bergsburg", "23", "23", "23");

        Proffesion pr1 = new Proffesion("kowal", 100);

        House h1 = new House(UUID.randomUUID().toString(), a1, "Przeciętny dom.");
        House h2 = new House(UUID.randomUUID().toString(), a1, "Piękna posiadłość.");

        Person pe1 = new Person (n1, pr1, 300, null, h1, null, null);
        Person pe2 = new Person (n2, pr1, 300, pe1, h1, null, null);

        nameService.saveName(n1);
        nameService.saveName(n2);

        addressService.saveAddress(a1);

        proffesionService.saveProffesion(pr1);

        houseService.saveHouse(h1);
        houseService.saveHouse(h2);

        personService.savePerson(pe1);
        personService.savePerson(pe2);

        return "Model Generated";
    }

}
