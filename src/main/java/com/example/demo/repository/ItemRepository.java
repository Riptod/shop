package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByCategory(String category);

    @Query(value = "SELECT distinct category FROM ITEMS", nativeQuery = true)
    List<String> findAllCategories();

    Item findItemById(Long id);
}
