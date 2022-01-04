package com.practice.demo.springsocialmedia.exceptions;

public class SpringblogException extends RuntimeException {
    public SpringblogException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public SpringblogException(String exMessage) {
        super(exMessage);
    }
}
