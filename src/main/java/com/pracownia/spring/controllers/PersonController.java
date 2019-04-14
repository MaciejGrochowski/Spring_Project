package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Person;
import com.pracownia.spring.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/persons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Person> list(Model model) {
        return personService.listAllPersons();
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getByPublicId(@PathVariable("id") Integer publicId) {
        return personService.getPersonById(publicId);
    }

    @RequestMapping(value = "/persons/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Person> list(@PathVariable("page") Integer pageNr, @RequestParam("size") Optional<Integer> howManyOnPage) {
        return personService.listAllPersonsPaging(pageNr, howManyOnPage.orElse(2));
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public ResponseEntity<Person> create(@RequestBody @Valid @NotNull Person person) {
        personService.savePerson(person);
        return ResponseEntity.ok().body(person);
    }

    @RequestMapping(value = "/person", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Person person) {
        if (!personService.checkIfExist(person.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            personService.savePerson(person);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        personService.deletePerson(id);
        return new RedirectView("/api/persons", true);
    }

    @RequestMapping(value = "/person/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer count() {
        return personService.count();
    }
}
