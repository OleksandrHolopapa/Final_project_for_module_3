package com.javarush.exceptions;

public class RequestRedirectionException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RequestRedirectionException(String message) {
        super("Request Redirection Exception: "+message);
    }
}
