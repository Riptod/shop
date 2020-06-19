package com.example.demo.service.Impl;

import java.util.List;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void deleteItem(Item item) {
        itemRepository.delete(item);
    }

    @Override
    public List<String> findAllCategories() {
        return itemRepository.findAllCategories();
    }

    @Override
    public List<Item> findAllByCategory(String category) {
        return itemRepository.findAllByCategory(category);
    }

    @Override
    public Item findItemById(Long id) {
        return itemRepository.findItemById(id);
    }
}
