package com.cars.repository;

import com.cars.model.CarDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarDetailsRepository extends CrudRepository<CarDetails, Long> {
    List<CarDetails> findAll();
    Optional<CarDetails> findById(Long id);
}
