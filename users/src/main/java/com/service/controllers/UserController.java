package com.service.controllers;


import com.service.customExceptions.UserNotFoundException;
import com.service.entities.User;
import com.service.entities.UserDetails;
import com.service.repositories.UserDetailRepository;
import com.service.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    private final UserRepository userRepository;


    UserController(UserRepository repository, UserDetailRepository detailsRepository) {
        this.userRepository = repository;
    }

    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/addUser")
    User addNewUser(@RequestBody User newUser) {

        return userRepository.save(newUser);
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/removeUser/{id}")
    ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>("User with id: " + id + " was deleted!", HttpStatus.OK);

    }

}
