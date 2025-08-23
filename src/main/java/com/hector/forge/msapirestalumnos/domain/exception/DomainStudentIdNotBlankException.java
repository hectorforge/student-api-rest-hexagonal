package com.hector.forge.msapirestalumnos.domain.exception;

public class DomainStudentIdNotBlankException extends RuntimeException {
    public DomainStudentIdNotBlankException(String message) {
        super(message);
    }
}
