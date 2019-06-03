package com.service.controllers;

import com.service.customExceptions.UserNotFoundException;
import com.service.entities.User;
import com.service.entities.UserDetails;
import com.service.repositories.UserDetailRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/userDetails")
@RestController
public class UserDetailsController {

    private final UserDetailRepository repository;

    UserDetailsController(UserDetailRepository repository) {
        this.repository = repository;
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDetails user, UriComponentsBuilder ucBuilder) {
        // ako nema usera
        System.out.println("yerina");
        repository.save(user);
       // userEventHendler.handleUserSave(user);
        System.out.println(user.toString());
        HttpHeaders headers = new HttpHeaders();
      //  headers.setLocation(ucBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @PostMapping("/addUserDetails")
    UserDetails addNewUser(@RequestBody UserDetails newUser) {
        return this.repository.save(newUser);
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

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity<List<UserDetails>> getAllUsers() {
        List<UserDetails> users = (List<UserDetails>) this.repository.findAll();
        if (users.isEmpty()) {
            // check if there are no items in the list
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<UserDetails>>(users, HttpStatus.OK);
    }
}
