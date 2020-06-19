package com.example.demo.controller;

import javax.annotation.PostConstruct;

import com.example.demo.entity.Discounts;
import com.example.demo.entity.Item;
import com.example.demo.entity.User;
import com.example.demo.service.DiscountService;
import com.example.demo.service.ItemService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class InitController {
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private DiscountService discountService;

    @PostConstruct
    public void addInfo() {
        User user1 = new User();
        user1.setUserName("Bob");
        user1.setMoney(4500D);
        User user2 = new User();
        user2.setUserName("Martin");
        user2.setMoney(3900D);
        userService.save(user1);
        userService.save(user2);
        Item laptop_ROG = new Item();
        laptop_ROG.setCategory("laptop");
        laptop_ROG.setName("ASUS ROG");
        laptop_ROG.setPrice(1200);
        itemService.save(laptop_ROG);
        Item laptop_Alien = new Item();
        laptop_Alien.setCategory("laptop");
        laptop_Alien.setName("Alien");
        laptop_Alien.setPrice(1050);
        itemService.save(laptop_Alien);
        Item phone_SamsungS10 = new Item();
        phone_SamsungS10.setCategory("phone");
        phone_SamsungS10.setName("Samsung S10");
        phone_SamsungS10.setPrice(500);
        itemService.save(phone_SamsungS10);
        Item phone_Xiaomi = new Item();
        phone_Xiaomi.setCategory("phone");
        phone_Xiaomi.setName("Redmi 8A");
        phone_Xiaomi.setPrice(200);
        itemService.save(phone_Xiaomi);
        Item TV_Samsung = new Item();
        TV_Samsung.setCategory("TV");
        TV_Samsung.setName("Samsung V.1");
        TV_Samsung.setPrice(700);
        itemService.save(TV_Samsung);
        Item TV_SamsungV2 = new Item();
        TV_SamsungV2.setCategory("TV");
        TV_SamsungV2.setName("Samsung V.2");
        TV_SamsungV2.setPrice(800);
        itemService.save(TV_SamsungV2);
        Item Console_XBOX = new Item();
        Console_XBOX.setCategory("Console");
        Console_XBOX.setName("X-BOX One");
        Console_XBOX.setPrice(700);
        itemService.save(Console_XBOX);
        Item Console_PlayStation = new Item();
        Console_PlayStation.setCategory("Console");
        Console_PlayStation.setName("PlayStation");
        Console_PlayStation.setPrice(650);
        itemService.save(Console_PlayStation);
        Discounts laptop_ROG_discounts = new Discounts();
        laptop_ROG_discounts.setItem(laptop_ROG);
        laptop_ROG_discounts.setDiscount(0.85);
        discountService.save(laptop_ROG_discounts);
        Discounts phone_SamsungS10_discounts = new Discounts();
        phone_SamsungS10_discounts.setItem(phone_SamsungS10);
        phone_SamsungS10_discounts.setDiscount(0.80);
        discountService.save(phone_SamsungS10_discounts);
        Discounts Console_XBOX_discounts = new Discounts();
        Console_XBOX_discounts.setItem(Console_XBOX);
        Console_XBOX_discounts.setDiscount(0.87);
        discountService.save(Console_XBOX_discounts);
        Discounts Console_PlayStation_discounts = new Discounts();
        Console_PlayStation_discounts.setItem(Console_PlayStation);
        Console_PlayStation_discounts.setDiscount(0.85);
        discountService.save(Console_PlayStation_discounts);
    }
}
