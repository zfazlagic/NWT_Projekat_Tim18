package com.userActivity.userActivities.Configuration.repositories;

import com.userActivity.userActivities.Configuration.models.activity;
import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete


public interface activityRepository extends JpaRepository<activity, Long> {

}
