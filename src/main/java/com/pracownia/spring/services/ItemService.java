package com.pracownia.spring.services;

import com.pracownia.spring.entities.Item;

public interface ItemService {

    Iterable<Item> listAllItems();

    Item getItemById(Integer id);

    Item saveItem(Item item);

    void deleteItem(Integer id);

    Boolean checkIfExist(Integer id);

    Integer count();

    public Iterable<Item> listAllItemsPaging(Integer pageNr, Integer howManyOnPage);

}
