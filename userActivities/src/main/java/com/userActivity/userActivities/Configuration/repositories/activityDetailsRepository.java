package com.userActivity.userActivities.Configuration.repositories;

import com.userActivity.userActivities.Configuration.models.activityDetails;
import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete


public interface activityDetailsRepository extends JpaRepository<activityDetails, Long> {

}
