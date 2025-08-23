package com.hector.forge.msapirestalumnos.domain.exception;

public class DomainStudentDateBirthdayNotFutureException extends RuntimeException {
    public DomainStudentDateBirthdayNotFutureException(String message) {
        super(message);
    }
}
