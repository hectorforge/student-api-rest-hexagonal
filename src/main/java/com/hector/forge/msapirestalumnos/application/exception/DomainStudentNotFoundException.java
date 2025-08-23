package com.hector.forge.msapirestalumnos.application.exception;

public class DomainStudentNotFoundException extends RuntimeException {
    public DomainStudentNotFoundException(String message) {
        super(message);
    }
}
