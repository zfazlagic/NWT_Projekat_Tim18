package com.service.repositories;

import com.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;



@RepositoryRestResource(collectionResourceRel = "user", path = "users")
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findById(@Param("id") Long id);
    boolean existsByUsername(String username);
    boolean existsById(Long id);

    Optional<User> findByUsername(@Param("username") String username);
   // User findByUsername(String username);
}
