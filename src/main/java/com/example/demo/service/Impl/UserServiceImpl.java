package com.example.demo.service.Impl;


import com.example.demo.entity.User;
import com.example.demo.exception.RequestCustomException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }


    @Override
    public User addMoney(String userName, Integer value) {
        User user = userRepository.findUserByUserName(userName);
        user.setMoney(user.getMoney() + value);
        return save(user);
      }

    @Override
    public void checkMoneyOnAccount(String userName, Double moneyToPay) {
        User user = userRepository.findUserByUserName(userName);
        if (user.getMoney() < moneyToPay) {
            throw new RequestCustomException("Not enough money on you account");
        }
        user.setMoney(user.getMoney() - moneyToPay);
        userRepository.save(user);
    }
}
