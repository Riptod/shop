package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Discounts;

public interface DiscountService {
    Discounts save(Discounts discounts);

    void delete(Discounts discounts);

    Optional<Discounts> findDistinctByItem_Id(Long itemId);
}
