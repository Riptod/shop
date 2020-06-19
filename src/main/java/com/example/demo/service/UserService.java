package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
    User save(User user);

    User findByUserName(String userName);

    User addMoney(String userName, Integer value);

    void checkMoneyOnAccount(String userName, Double moneyToPay);
}
