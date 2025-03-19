package com.dikshant.user.service.services.impl;

import com.dikshant.user.service.entites.Hotel;
import com.dikshant.user.service.entites.Rating;
import com.dikshant.user.service.entites.User;
import com.dikshant.user.service.exceptions.ResourceNotFoundException;
import com.dikshant.user.service.repositories.UserRepository;
import com.dikshant.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId)
                                  .orElseThrow(() -> new ResourceNotFoundException("No user found with this user ID" + userId));

        Rating[] ratingForUsers = restTemplate.getForObject("http://localhost:8083/ratings/users/" + userId,
                                                            Rating[].class);

        List<Rating> listOfRatingForUsers = Arrays.stream(ratingForUsers)
                                                  .toList();

        List<Rating> ratingList = listOfRatingForUsers.stream()
                                                      .peek(rating -> {
                                                          ResponseEntity<Hotel> hotelObject =
                                                                  restTemplate.getForEntity("http://localhost:8082/hotels/" + rating.getHotelId(),
                                                                                            Hotel.class);
                                                          Hotel hotel = hotelObject.getBody();
                                                          rating.setHotel(hotel);

                                                      })
                                                      .toList();

        user.setRatings(ratingList);

        return user;
    }
}
