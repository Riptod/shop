package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Item;

public interface ItemService {
       Item save(Item item);

       void deleteItem(Item item);

       List<String> findAllCategories();

       List<Item> findAllByCategory(String category);

       Item findItemById(Long id);
}
