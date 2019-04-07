package com.service.controllers;

import com.service.customExceptions.UserNotFoundException;
import com.service.entities.UserDetails;
import com.service.repositories.UserDetailRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class UserDetailsController {

    private final UserDetailRepository repository;

    UserDetailsController(UserDetailRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/addUserDetails")
    UserDetails addNewUser(@RequestBody UserDetails newUser) {
        return repository.save(newUser);
    }

    @GetMapping("/userDetails/{id}")
    UserDetails getUserById(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/removeUserDetails/{id}")
    ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("User with id: " + id + " was deleted!", HttpStatus.OK);

    }
}
