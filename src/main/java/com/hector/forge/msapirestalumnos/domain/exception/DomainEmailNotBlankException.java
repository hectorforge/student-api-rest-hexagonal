package com.hector.forge.msapirestalumnos.domain.exception;

public class DomainEmailNotBlankException extends RuntimeException {
    public DomainEmailNotBlankException(String message) {
        super(message);
    }
}
