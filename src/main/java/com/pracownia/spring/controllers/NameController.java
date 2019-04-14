package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Name;
import com.pracownia.spring.services.NameService;
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
public class NameController {

    @Autowired
    private NameService nameService;

    @RequestMapping(value = "/names", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Name> list(Model model) {
        return nameService.listAllNames();
    }

    @RequestMapping(value = "/name/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Name getByPublicId(@PathVariable("id") Integer publicId) {
        return nameService.getNameById(publicId);
    }

    @RequestMapping(value = "/name", method = RequestMethod.POST)
    public ResponseEntity<Name> create(@RequestBody @Valid @NotNull Name name) {
        nameService.saveName(name);
        return ResponseEntity.ok().body(name);
    }

    @RequestMapping(value = "/names/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Name> list(@PathVariable("page") Integer pageNr, @RequestParam("size") Optional<Integer> howManyOnPage) {
        return nameService.listAllNamesPaging(pageNr, howManyOnPage.orElse(2));
    }

    @RequestMapping(value = "/name", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Name name) {
        if (!nameService.checkIfExist(name.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            nameService.saveName(name);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/name/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        nameService.deleteName(id);
        return new RedirectView("/api/names", true);
    }

    @RequestMapping(value = "/name/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer count() {
        return nameService.count();
    }
}
