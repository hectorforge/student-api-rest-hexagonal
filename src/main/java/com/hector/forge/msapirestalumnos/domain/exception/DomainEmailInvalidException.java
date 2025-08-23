package com.hector.forge.msapirestalumnos.domain.exception;

public class DomainEmailInvalidException extends RuntimeException {
    public DomainEmailInvalidException(String message) {
        super(message);
    }
}
