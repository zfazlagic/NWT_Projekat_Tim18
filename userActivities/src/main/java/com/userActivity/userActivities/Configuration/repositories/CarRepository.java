package com.userActivity.userActivities.Configuration.repositories;

import com.userActivity.userActivities.Configuration.models.Cars;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Cars, Integer> {
}
