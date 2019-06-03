package com.service.repositories;

import com.service.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "userDetails", path = "userDetails")
@Repository
public interface UserDetailRepository extends CrudRepository<UserDetails, Long> {
}
