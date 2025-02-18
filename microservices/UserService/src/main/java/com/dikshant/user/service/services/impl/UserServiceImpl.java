package com.dikshant.user.service.services.impl;

import com.dikshant.user.service.entites.User;
import com.dikshant.user.service.exceptions.ResourceNotFoundException;
import com.dikshant.user.service.repositories.UserRepository;
import com.dikshant.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("No user found with this user ID" + userId));
    }
}
