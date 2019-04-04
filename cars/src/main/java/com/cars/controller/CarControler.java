package com.cars.controller;
import com.cars.model.CarDetails;
import com.cars.repository.CarsDetailsInterface;
import com.cars.repository.CarsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cars.model.Cars;
import java.util.List;


@RestController
@RequestMapping("/cars")
public class CarControler {

    private final CarsRepository carsRepository;
    private final CarsDetailsInterface carsDetailsInterface;



    public CarControler(CarsRepository carsRepository, CarsDetailsInterface carsDetailsInterface) {
        this.carsRepository = carsRepository;
        this.carsDetailsInterface=carsDetailsInterface;
    }

    //get all cars
    @GetMapping("/all")
    public Iterable<Cars> listAllCars() {
       return carsRepository.findAll();

    }

    // get car by id

       @GetMapping("/car/{id}")
       public Cars getCarById (@PathVariable int id) {
        return carsRepository.findById(id);
    }

        // get car detail

    @GetMapping("/detail/{id}")
    public CarDetails getDetailById (@PathVariable int id) {
        return carsDetailsInterface.findById(id);
    }


        @PostMapping("/delete/{id}")
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

    // add detail about car
    @PostMapping("/addDetail")
    CarDetails addDetail(@RequestBody CarDetails details) {
        return carsDetailsInterface.save(details);
    }
}
