package com.example.perestoronin.springbook.simple_spring_boot_mvc.service.exception;

import org.hibernate.service.spi.ServiceException;

public class UserNotFoundException extends ServiceException {

    private static final long serialVersionUID = 6804000735049830517L;


    public UserNotFoundException(Integer id) {
        this("User with id " + id + " was not found.");
    }

    public UserNotFoundException(String message) {
        super(message);
    }

}