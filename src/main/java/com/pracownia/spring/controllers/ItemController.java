package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Item;
import com.pracownia.spring.services.ItemService;
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
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/items", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Item> list(Model model) {
        return itemService.listAllItems();
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Item getByPublicId(@PathVariable("id") Integer publicId) {
        return itemService.getItemById(publicId);
    }

    @RequestMapping(value = "/items/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Item> list(@PathVariable("page") Integer pageNr, @RequestParam("size") Optional<Integer> howManyOnPage) {
        return itemService.listAllItemsPaging(pageNr, howManyOnPage.orElse(2));
    }

    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public ResponseEntity<Item> create(@RequestBody @Valid @NotNull Item item) {
        itemService.saveItem(item);
        return ResponseEntity.ok().body(item);
    }


    @RequestMapping(value = "/item", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Item item) {
        if (!itemService.checkIfExist(item.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            itemService.saveItem(item);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        itemService.deleteItem(id);
        return new RedirectView("/api/items", true);
    }

    @RequestMapping(value = "/item/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer count() {
        return itemService.count();
    }
}

