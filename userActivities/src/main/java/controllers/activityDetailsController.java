package controllers;

import exceptions.activityDetailsNotFound;

import models.activityDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.activityDetailsRepository;
import services.ActivityDetailsService;

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
        detailsRepo.deleteById(id);
        return new ResponseEntity<>("Activity detail with id: " + id + " was deleted!", HttpStatus.OK);

    }
}





