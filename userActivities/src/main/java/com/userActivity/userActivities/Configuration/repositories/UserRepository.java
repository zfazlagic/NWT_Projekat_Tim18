package com.userActivity.userActivities.Configuration.repositories;

import com.userActivity.userActivities.Configuration.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
