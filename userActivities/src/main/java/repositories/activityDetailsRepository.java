package repositories;

import org.springframework.data.repository.CrudRepository;

import models.activityDetails;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface activityDetailsRepository extends CrudRepository<activityDetails, Integer> {

}

