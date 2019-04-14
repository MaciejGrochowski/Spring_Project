package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Proffesion;
import com.pracownia.spring.services.ProffesionService;
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
public class ProffesionController {

    @Autowired
    private ProffesionService proffesionService;

    @RequestMapping(value = "/proffesions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Proffesion> list(Model model) {
        return proffesionService.listAllProffesions();
    }

    @RequestMapping(value = "/proffesion/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Proffesion getByPublicId(@PathVariable("id") Integer publicId) {
        return proffesionService.getProffesionById(publicId);
    }

    @RequestMapping(value = "/proffesions/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Proffesion> list(@PathVariable("page") Integer pageNr, @RequestParam("size") Optional<Integer> howManyOnPage) {
        return proffesionService.listAllProffesionsPaging(pageNr, howManyOnPage.orElse(2));
    }

    @RequestMapping(value = "/proffesion", method = RequestMethod.POST)
    public ResponseEntity<Proffesion> create(@RequestBody @Valid @NotNull Proffesion prof) {
        proffesionService.saveProffesion(prof);
        return ResponseEntity.ok().body(prof);
    }

    @RequestMapping(value = "/proffesion", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Proffesion prof) {
        if (!proffesionService.checkIfExist(prof.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            proffesionService.saveProffesion(prof);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/proffesion/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        proffesionService.deleteProffesion(id);
        return new RedirectView("/api/proffesions", true);
    }

    @RequestMapping(value = "/proffesion/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer count() {
        return proffesionService.count();
    }
}