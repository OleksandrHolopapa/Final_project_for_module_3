package com.javarush.exceptions;

public class RequestRedirectionException extends RuntimeException {
    public RequestRedirectionException(String message) {
        super("Request Redirection Exception: "+message);
    }
}
