package com.userActivity.userActivities.Configuration.controllers;

import com.userActivity.userActivities.Configuration.exceptions.activityNotFound;
import com.userActivity.userActivities.Configuration.models.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.userActivity.userActivities.Configuration.repositories.activityRepository;
import com.userActivity.userActivities.Configuration.services.UserActivityService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/activity")
public class userActivityController {

    @Autowired
    UserActivityService userActivityService;

    private final activityRepository activityRepo;


    userActivityController(activityRepository repository) {
        this.activityRepo = repository;
    }

    @GetMapping("/activities")
    public Iterable<activity> getAllActivities() {
        return userActivityService.getAllUserActivities();
    }



    @PostMapping("/addActivity")
    activity addNewActivity(@RequestBody activity newActivity) {
        return activityRepo.save(newActivity);
    }


    @GetMapping("/activities/{id}")
    activity getActivityById(@PathVariable Long id) {

        return userActivityService.getActivityById(id)
                .orElseThrow(() -> new activityNotFound(id));
    }

    @DeleteMapping("/removeActivity/{id}")
    ResponseEntity<String> deleteActivityById(@PathVariable Long id) {

        Optional<activity> existingActivity = activityRepo.findById(id);

        if (!existingActivity.isPresent()) {
            return new ResponseEntity("Unable to delete. Activity with id " + id + " not found.",
                    HttpStatus.NOT_FOUND);
        }

        activityRepo.deleteById(id);
        return new ResponseEntity<>("Activity with id: " + id + " was deleted!", HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateUserActivity(@PathVariable("id") long id,@Valid @RequestBody activity newActivity) {

        Optional<activity> existingActivity = activityRepo.findById(id);

        if (!existingActivity.isPresent()) {
            return new ResponseEntity("Unable to update. Activity with id " + id + " not found.",
                    HttpStatus.NOT_FOUND);
        }
        existingActivity.get().setCarId(newActivity.getCarId());
        existingActivity.get().setIsRental(newActivity.getIsRental());
        existingActivity.get().setIsReservation(newActivity.getIsReservation());
        existingActivity.get().setUserId(newActivity.getUserId());

        activityRepo.save(existingActivity.get());
        return new ResponseEntity<Optional<activity>>(existingActivity, HttpStatus.OK);
    }
}





