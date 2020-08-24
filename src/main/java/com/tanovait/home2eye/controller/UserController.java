package com.tanovait.home2eye.controller;

import com.tanovait.home2eye.model.City;
import com.tanovait.home2eye.model.Property;
import com.tanovait.home2eye.model.User;
import com.tanovait.home2eye.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<User> create(UriComponentsBuilder ucBuilder, @RequestBody User user){
        User newUser = userRepository.save(user);
        return ResponseEntity.
                created(ucBuilder.path("/users/{userId}").buildAndExpand(newUser.getId()).toUri()).build();
    }
}
