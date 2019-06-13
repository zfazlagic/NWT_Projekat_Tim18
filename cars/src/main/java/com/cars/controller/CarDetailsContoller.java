package com.cars.controller;

import com.cars.model.CarDetails;
import com.cars.repository.CarDetailsRepository;
import com.cars.repository.CarsDetailsInterface;
import com.cars.repository.CarsRepository;
import com.cars.services.CarEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carDetails")
public class CarDetailsContoller {

    private final CarsDetailsInterface carsDetailsInterface;

    private final CarDetailsRepository carDetailsRepository;
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CarEventHandler carEventHandler;

    public CarDetailsContoller(CarsDetailsInterface carsDetailsInterface, CarDetailsRepository carDetailsRepository) {
        this.carsDetailsInterface = carsDetailsInterface;
        this.carDetailsRepository = carDetailsRepository;
    }

    // get all cars
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    ResponseEntity<List<CarDetails>> listAllCars() {
        List<CarDetails> cars = (List<CarDetails>) this.carDetailsRepository.findAll();
        return new ResponseEntity<List<CarDetails>>(cars, HttpStatus.OK);
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

    @CrossOrigin(origins = "*")
    @DeleteMapping("/removeCarDetails/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable("id") Long id) {
        this.carDetailsRepository.deleteById(id);
        return new ResponseEntity<CarDetails>(HttpStatus.NO_CONTENT);
    }
//    @CrossOrigin(origins = "*")
//    @DeleteMapping("/removeCarDetails/{id}")
//    ResponseEntity<String> deleteCarDetailsById(@PathVariable int id) {
//        //carsDetailsInterface.deleteById(id);
//        return new ResponseEntity<>("Car details with id: " + id + " was deleted!", HttpStatus.OK);
//    }
}
