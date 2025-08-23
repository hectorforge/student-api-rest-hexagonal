package com.hector.forge.msapirestalumnos.domain.exception;

public class DomainStudentNameNotBlankException extends RuntimeException {
    public DomainStudentNameNotBlankException(String message) {
        super(message);
    }
}
