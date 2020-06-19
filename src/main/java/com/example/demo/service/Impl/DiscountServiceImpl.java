package com.example.demo.service.Impl;

import java.util.Optional;

import com.example.demo.entity.Discounts;
import com.example.demo.repository.DiscountsRepository;
import com.example.demo.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl implements DiscountService {
    @Autowired
    private DiscountsRepository discountsRepository;

    @Override
    public Discounts save(Discounts discounts) {
        return discountsRepository.save(discounts);
    }

    @Override
    public void delete(Discounts discounts) {
        discountsRepository.delete(discounts);
    }

    @Override
    public Optional<Discounts> findDistinctByItem_Id(Long itemId) {
        return discountsRepository.findDistinctByItem_Id(itemId);
    }

}
