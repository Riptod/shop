package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.demo.dto.PayDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Item;
import com.example.demo.entity.User;
import com.example.demo.exception.RequestCustomException;
import com.example.demo.service.DiscountService;
import com.example.demo.service.ItemService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private DiscountService discountService;

    @PostMapping(value = "/create_user")
    public void createUser(@RequestBody UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setMoney(userDto.getMoney());
        userService.save(user);
    }

    @GetMapping(value = "/add_money")
    public void addMoney(@RequestParam String name, Integer value) {
        userService.addMoney(name, value);
    }

    @GetMapping(value = "/list")
    public List<String> categoryList() {
        return itemService.findAllCategories();
    }

    @GetMapping(value = "/list/")
    public List<Item> getItemsByCategory(@RequestParam String category) {
        return itemService.findAllByCategory(category);
    }

    @PostMapping(value = "/pay")
    public Double pay(@RequestBody PayDto payDto) {
        Double moneyToPay = 0D;
        Set<Long> distinctItemsId = new HashSet<>(payDto.getItemsId());
        List<Long> discountItemsList = new ArrayList<>();
        Map<Long, Long> allItems = new HashMap<>();
        for (Long itemId : distinctItemsId) {
            allItems.put(itemId, 0L);
            if (discountService.findDistinctByItem_Id(itemId).isPresent()) {
                discountItemsList.add(itemId);
            }
        }

        for (Long itemId : payDto.getItemsId()) {
            allItems.put(itemId, allItems.get(itemId) + 1);
        }

        if (discountItemsList.size() > 3) {
            List<Double> discountValues = new ArrayList<>();
            for (Long id : discountItemsList) {
                discountValues.add((double) (itemService.findItemById(id).getPrice() * allItems.get(id))
                * (1 - discountService.findDistinctByItem_Id(id).get().getDiscount()));
            }
            Collections.sort(discountValues);
            Collections.reverse(discountValues);
            for (Long distinctId : distinctItemsId) {
                moneyToPay += itemService.findItemById(distinctId).getPrice() * allItems.get(distinctId);
            }
            moneyToPay = moneyToPay - discountValues.get(0) - discountValues.get(1) - discountValues.get(2);
            userService.checkMoneyOnAccount(payDto.getUsername(), moneyToPay);
            return moneyToPay;
        }

        for (Long itemId:distinctItemsId) {
            if (discountService.findDistinctByItem_Id(itemId).isPresent()) {
                moneyToPay += itemService.findItemById(itemId).getPrice() * allItems.get(itemId)
                        * discountService.findDistinctByItem_Id(itemId).get().getDiscount();
            } else {
                moneyToPay += itemService.findItemById(itemId).getPrice() * allItems.get(itemId);
            }
        }
        userService.checkMoneyOnAccount(payDto.getUsername(), moneyToPay);
        return moneyToPay;
    }
}
