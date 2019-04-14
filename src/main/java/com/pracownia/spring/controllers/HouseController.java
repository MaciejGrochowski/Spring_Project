package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.House;
import com.pracownia.spring.services.HouseService;
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
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @RequestMapping(value = "/houses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<House> list(Model model) {
        return houseService.listAllHouses();
    }

    @RequestMapping(value = "/house/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public House getByPublicId(@PathVariable("id") String publicId) {
        return houseService.getHouseById(publicId);
    }

    @RequestMapping(value = "/houses/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<House> list(@PathVariable("page") Integer pageNr, @RequestParam("size") Optional<Integer> howManyOnPage) {
        return houseService.listAllHousesPaging(pageNr, howManyOnPage.orElse(2));
    }

    @RequestMapping(value = "/house", method = RequestMethod.POST)
    public ResponseEntity<House> create(@RequestBody @Valid @NotNull House house) {
        house.SetHouseId(UUID.randomUUID().toString());
        houseService.saveHouse(house);
        return ResponseEntity.ok().body(house);
    }

    @RequestMapping(value = "/house", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull House house) {
        if (!houseService.checkIfExist(house.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            houseService.saveHouse(house);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/house/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        houseService.deleteHouse(id);
        return new RedirectView("/api/houses", true);
    }

    @RequestMapping(value = "/house/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer count() {
        return houseService.count();
    }
}
