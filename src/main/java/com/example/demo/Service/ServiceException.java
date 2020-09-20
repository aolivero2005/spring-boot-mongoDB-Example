package com.example.demo.Service;

public class ServiceException extends Exception {

    private static final long serialVersionUID = 6238063933362747784L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }
}
