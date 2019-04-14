package com.cars.controller;

import com.cars.model.CarDetails;
import com.cars.repository.CarsDetailsInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/details")
public class CarDetailsContoller {

    private final CarsDetailsInterface carsDetailsInterface;

    public CarDetailsContoller(CarsDetailsInterface carsDetailsInterface) {
        this.carsDetailsInterface = carsDetailsInterface;
    }

    @GetMapping("/detail/{id}")
    public CarDetails getDetailById (@PathVariable int id) {
        return carsDetailsInterface.findById(id);
    }

    @PostMapping("/addDetail")
    CarDetails addDetail(@RequestBody CarDetails details) {
        return carsDetailsInterface.save(details);
    }

    @PutMapping("/available/{id}")
    public CarDetails updateAvailable(@PathVariable int id) {

        CarDetails car=this.carsDetailsInterface.findById(id);
        car.setAvailable(false);
        return carsDetailsInterface.save(car);
    }
    @DeleteMapping("/removeCarDetails/{id}")
    ResponseEntity<String> deleteCarDetailsById(@PathVariable int id) {
        carsDetailsInterface.deleteById(id);
        return new ResponseEntity<>("Car details with id: " + id + " was deleted!", HttpStatus.OK);
    }
}
