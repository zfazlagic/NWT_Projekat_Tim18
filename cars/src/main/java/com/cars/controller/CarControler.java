package com.cars.controller;
import com.cars.model.CarDetails;
import com.cars.repository.CarsDetailsInterface;
import com.cars.repository.CarsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cars.model.Cars;
import java.util.List;
import java.util.Optional;


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

       @GetMapping("/user/{id}")
       public Cars getCarById (@PathVariable long id) {

           return carsRepository.findById(id);

       }


    @RequestMapping(method = RequestMethod.GET, value = "/carDetail{carId}")
    public ResponseEntity<List<Cars>> getCarDetails(long carId) {
        CarDetails carDetail = this.carsDetailsInterface.findCarDetailsById(carId);
       /* if (countries.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }*/
        return new ResponseEntity(carDetail, HttpStatus.OK);
    }

    @PostMapping("/addCar")
    Cars addNewCar(@RequestBody Cars newCar) {
        return carsRepository.save(newCar);
    }
}
