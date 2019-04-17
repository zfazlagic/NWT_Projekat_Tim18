package com.service.repositories;

import com.service.entities.Cars;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Cars, Integer> {
}
