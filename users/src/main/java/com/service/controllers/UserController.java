package com.service.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.service.services.UserEventHendler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import com.service.customExceptions.UserNotFoundException;
import com.service.entities.User;
import com.service.entities.UserDetails;
import com.service.repositories.UserDetailRepository;
import com.service.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;


@RestController
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserEventHendler userEventHendler;


    UserController(UserRepository repository) {
        this.userRepository = repository;
    }

    //Rabbitmq

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@Valid @RequestBody User user, UriComponentsBuilder ucBuilder) {
        // ako nema usera
        System.out.println("yerina");
        userRepository.save(user);
        userEventHendler.handleUserSave(user);
        System.out.println(user.toString());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }



    // Get all users from the database
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = (List<User>) this.userRepository.findAll();
        if (users.isEmpty()) {
            // check if there are no items in the list
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    // Get only one user from the database, specified by ID
    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    ResponseEntity<?> getUserById(@PathVariable Long userid) {
        Optional<User> user = this.userRepository.findById(userid);
        if (!user.isPresent()) {
            // may implement custom exception, better practice
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Optional<User>>(user, HttpStatus.OK);
    }

    // Add new user to the database
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> createLocation(@Valid @RequestBody User user, UriComponentsBuilder builder) {

        // Check if username already exists
        Iterable<User> users = userRepository.findAll();
        /*if (!users.()) {
            for (User u : users) {
                if (u.getUsername() == user.getUsername())
                    return new ResponseEntity("User with this username already exists!", HttpStatus.CONFLICT);
            }
        }*/

        // Need to check if update to UserDetails TABLE is required...
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    //Update existing user
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("id") long id,@Valid @RequestBody User newUser) {

        Optional<User> existingUser = userRepository.findById(id);

        if (!existingUser.isPresent()) {
            return new ResponseEntity("Unable to upate. Country with id " + id + " not found.",
                    HttpStatus.NOT_FOUND);
        }

        existingUser.get().setUsername(newUser.getUsername());

        userRepository.save(existingUser.get());
        return new ResponseEntity<Optional<User>>(existingUser, HttpStatus.OK);
    }

    // Delete user from the database
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        // Validate that user exists in the Db
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent())
            return new ResponseEntity("User with specific ID: " + id + " was NOT found!", HttpStatus.NOT_FOUND);
        userRepository.deleteById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    // May implement DROP ALL USERS ?!


}
