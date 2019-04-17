package com.userActivity.userActivities.Configuration.controllers;

import com.userActivity.userActivities.Configuration.exceptions.activityDetailsNotFound;

import com.userActivity.userActivities.Configuration.models.activityDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.userActivity.userActivities.Configuration.repositories.activityDetailsRepository;
import com.userActivity.userActivities.Configuration.services.ActivityDetailsService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/activityDetails")
public class activityDetailsController {

    @Autowired
    ActivityDetailsService detailsService;

    private final activityDetailsRepository detailsRepo;


    activityDetailsController(activityDetailsRepository repository) {
        this.detailsRepo = repository;
    }

    @GetMapping("/all")
    public Iterable<activityDetails> getAllActivityDetails() {
        return detailsService.getAllActivityDetails();
    }

    @PostMapping("/addDetail")
    activityDetails addNewActivityDetail(@RequestBody activityDetails newDetail) {
        return detailsRepo.save(newDetail);
    }


    @GetMapping("/activityDetail/{id}")
    activityDetails getActivityDetailsById(@PathVariable Long id) {

        return detailsService.getActivityDetailById(id)
                .orElseThrow(() -> new activityDetailsNotFound(id));
    }

    @DeleteMapping("/removeActivityDetail/{id}")
    ResponseEntity<String> deleteActivityDetailById(@PathVariable Long id) {

        Optional<activityDetails> existingDetail = detailsRepo.findById(id);

        if (!existingDetail.isPresent()) {
            return new ResponseEntity("Unable to remove. Activity detail with id " + id + " not found.",
                    HttpStatus.NOT_FOUND);
        }

        detailsRepo.deleteById(id);
        return new ResponseEntity<>("Activity detail with id: " + id + " was deleted!", HttpStatus.OK);

    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateActivityDetails(@PathVariable("id") long id,@Valid @RequestBody activityDetails newDetail) {

        Optional<activityDetails> existingDetail = detailsRepo.findById(id);

        if (!existingDetail.isPresent()) {
            return new ResponseEntity("Unable to update. Activity detail with id " + id + " not found.",
                    HttpStatus.NOT_FOUND);
        }
        existingDetail.get().setBeginDate(newDetail.getBeginDate());
        existingDetail.get().setEndDate((newDetail.getEndDate()));
        existingDetail.get().setLocation(newDetail.getLocation());
        existingDetail.get().setActivityId(newDetail.getActivityId());

        detailsRepo.save(existingDetail.get());
        return new ResponseEntity<Optional<activityDetails>>(existingDetail, HttpStatus.OK);
    }
}





