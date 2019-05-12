package com.cars.repository;

import com.cars.model.Cars;
import com.cars.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {
   // List<Cars> carsgetUserByDeletable(boolean isDeletable);
}
