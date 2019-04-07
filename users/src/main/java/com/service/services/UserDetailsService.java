package com.service.services;

import com.service.entities.User;
import com.service.entities.UserDetails;
import com.service.repositories.UserDetailRepository;
import com.service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class UserDetailsService {
    
    @Autowired
    private UserDetailRepository userDetailsRepository;
    @Autowired
    private UserRepository userRepository;
    
    void saveUserDetails(String role, String username, String password, String firstName, String lastName,
                         String email, Long userActivities, Integer verified, Date createdAt) {

        UserDetails userDetails = new UserDetails(firstName,lastName,email,createdAt,verified,userActivities);
        User user = new User(role, username, password, userDetails);
        userRepository.save(user);
        userDetailsRepository.save(userDetails);
    }

}
