package com.dikshant.user.service.services;

import com.dikshant.user.service.entites.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);


}
