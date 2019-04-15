package com.cars.repository;

import com.cars.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface UsersRepository extends CrudRepository<User, Long> {
}
