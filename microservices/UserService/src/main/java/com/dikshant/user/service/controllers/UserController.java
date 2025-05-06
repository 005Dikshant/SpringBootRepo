package com.dikshant.user.service.controllers;

import com.dikshant.user.service.entites.User;
import com.dikshant.user.service.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    private static final Logger logger=LoggerFactory.getLogger(UserController.class);


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        String randomUserId=UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        User user1=userService.saveUser(user);

        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        User user=userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    // Fallback method for circuit breaker
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {

        logger.info("Fallback is executed because service is down: {}", ex.getMessage());

        return ResponseEntity.ok(User.builder().email("dummyUser@.com").name("dummyUser").userId("dummyUserId")
                                     .about("This is dummy user. Please try again later.").build());
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUser=userService.getAllUser();

        return ResponseEntity.ok(allUser);
    }
}
