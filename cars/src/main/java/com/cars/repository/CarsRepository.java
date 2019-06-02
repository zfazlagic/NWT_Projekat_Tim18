package com.cars.repository;

import com.cars.model.Cars;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarsRepository extends CrudRepository <Cars, Integer> {
    List<Cars> findAll();
    Cars findById(int id);
}
