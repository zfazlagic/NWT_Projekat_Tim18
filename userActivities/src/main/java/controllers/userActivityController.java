package controllers;

import exceptions.activityNotFound;
import models.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.activityRepository;
import services.UserActivityService;

@RestController
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


    @RequestMapping(value = "/addActivity", method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody activity addNewActivity(activity newActivity) {

        return activityRepo.save(newActivity);
    }

    @GetMapping("/activities/{id}")
    activity getActivityById(@PathVariable Long id) {

        return userActivityService.getActivityById(id)
                .orElseThrow(() -> new activityNotFound(id));
    }

    @DeleteMapping("/removeActivity/{id}")
    ResponseEntity<String> deleteActivityById(@PathVariable Long id) {
        activityRepo.deleteById(id);
        return new ResponseEntity<>("Activity with id: " + id + " was deleted!", HttpStatus.OK);

    }
}





