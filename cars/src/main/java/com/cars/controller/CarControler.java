package com.cars.controller;
import com.cars.model.CarDetails;
import com.cars.repository.CarsDetailsInterface;
import com.cars.repository.CarsRepository;
import com.cars.services.CarEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cars.model.Cars;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.PostUpdate;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/cars")
public class CarControler {

    private final CarsRepository carsRepository;
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CarEventHandler carEventHandler;




    public CarControler(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;

    }

    //Rabbitmq

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@Valid @RequestBody Cars car, UriComponentsBuilder ucBuilder) {
        // ako nema usera
        System.out.println("yerina");
        carsRepository.save(car);
        carEventHandler.handleCarSave(car);
        System.out.println(car.toString());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/car/{id}").buildAndExpand(car.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    //get all cars
    @CrossOrigin(origins = "*")
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
     //   carsRepository.deleteById(id);
        return new ResponseEntity<>("Car with id: " + id + " was deleted!", HttpStatus.OK);
    }

  /*  @GetMapping("/car/dgetDeletable/{deletable}")
    public List<Cars> getCarByisDeletable (@PathVariable boolean deletable) {
        List<Cars> cars =  carsRepository.get
    return cars;
    }*/



}
