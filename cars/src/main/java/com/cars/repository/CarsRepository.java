package com.cars.repository;

import com.cars.model.Cars;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface CarsRepository extends CrudRepository <Cars, Long> {
    List<Cars> findAll();
    Cars findUserById(Long id);
}
