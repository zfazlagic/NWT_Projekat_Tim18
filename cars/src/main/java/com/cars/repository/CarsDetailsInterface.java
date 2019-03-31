package com.cars.repository;

import com.cars.model.CarDetails;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface CarsDetailsInterface extends CrudRepository<CarDetails, Long>{
}
