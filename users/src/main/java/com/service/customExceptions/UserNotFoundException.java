package com.service.customExceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Could NOT find user with id: " + id);
    }
}
