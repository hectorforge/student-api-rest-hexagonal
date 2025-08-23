package com.hector.forge.msapirestalumnos.application.exception;

public class DomainStudentDuplicatedEmailException extends RuntimeException {
    public DomainStudentDuplicatedEmailException(String message) {
        super(message);
    }
}
