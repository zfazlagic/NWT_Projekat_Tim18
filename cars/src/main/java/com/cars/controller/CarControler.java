package com.cars.controller;
import com.cars.model.CarDetails;
import com.cars.repository.CarsDetailsInterface;
import com.cars.repository.CarsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cars.model.Cars;

import javax.persistence.PostUpdate;
import java.util.List;


@RestController
@RequestMapping("/cars")
public class CarControler {

    private final CarsRepository carsRepository;




    public CarControler(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;

    }

    //get all cars
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    ResponseEntity<List<Cars>> listAllCars() {
        List<Cars> cars = (List<Cars>) this.carsRepository.findAll();
        return new ResponseEntity<List<Cars>>(cars, HttpStatus.OK);
    }

    // get car by id
       @GetMapping("/car/{id}")
       public Cars getCarById (@PathVariable int id) {
        return carsRepository.findById(id);
    }

        @PutMapping("/delete/{id}")
        public Cars deteteCar(@PathVariable int id) {

        Cars car=this.carsRepository.findById(id);
        car.setDeletable(true);
       return carsRepository.save(car);
    }
    // add new car
    @PostMapping("/addCar")
    Cars addNewCar(@RequestBody Cars newCar) {
        return carsRepository.save(newCar);
    }


    @DeleteMapping("/removeCar/{id}")
    ResponseEntity<String> deleteCarById(@PathVariable int id) {
        carsRepository.deleteById(id);
        return new ResponseEntity<>("Car with id: " + id + " was deleted!", HttpStatus.OK);
    }

}
