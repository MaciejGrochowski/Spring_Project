package com.pracownia.spring.services;

import com.pracownia.spring.entities.Item;
import com.pracownia.spring.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Iterable<Item> listAllItemsPaging(Integer pageNr, Integer howManyOnPage) {
        return itemRepository.findAll(new PageRequest(pageNr,howManyOnPage));
    }

    @Override
    public Iterable<Item> listAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Integer id) {
        return itemRepository.findOne(id);
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void deleteItem(Integer id) {
        itemRepository.delete(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        return itemRepository.checkIfExist(id);
    }

    @Override
    public Integer count(){
        return itemRepository.Count();
    }

    public void setItemRepository(ItemRepository rep) {
        this.itemRepository = rep;
    }
}
