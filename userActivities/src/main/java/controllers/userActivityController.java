package controllers;

import exceptions.activityNotFound;
import models.activity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import repositories.activityRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/activity")
public class userActivityController {
    private final activityRepository activityRepo;

    userActivityController(activityRepository repository) {
        this.activityRepo = repository;
    }

    @GetMapping("/activities")
    public Iterable<activity> getAllActivities() {
        return activityRepo.findAll();
    }



    @PostMapping("/addActivity")
    activity addNewActivity(@RequestBody activity newActivity) {
        return activityRepo.save(newActivity);
    }


    @GetMapping("/activities/{id}")
    activity getActivityById(@PathVariable Long id) {

        return activityRepo.findById(id)
                .orElseThrow(() -> new activityNotFound(id));
    }

    @DeleteMapping("/removeActivity/{id}")
    ResponseEntity<String> deleteActivityById(@PathVariable Long id) {
        activityRepo.deleteById(id);
        return new ResponseEntity<>("Activity with id: " + id + " was deleted!", HttpStatus.OK);

    }
}





