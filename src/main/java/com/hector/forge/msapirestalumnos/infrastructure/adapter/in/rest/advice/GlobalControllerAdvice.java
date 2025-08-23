package com.hector.forge.msapirestalumnos.infrastructure.adapter.in.rest.advice;

import com.hector.forge.msapirestalumnos.application.exception.*;
import com.hector.forge.msapirestalumnos.domain.exception.*;
import com.hector.forge.msapirestalumnos.infrastructure.adapter.in.rest.dto.ErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.stream.Collectors;

import static com.hector.forge.msapirestalumnos.infrastructure.adapter.in.rest.dto.ErrorCatalog.*;

@RestControllerAdvice
public class GlobalControllerAdvice {

    // ====== Alumno ======
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DomainStudentNotFoundException.class)
    public ErrorResponse handleStudentNotFound(DomainStudentNotFoundException ex) {
        return ErrorResponse.builder()
                .code(STUDENT_NOT_FOUND.getCode())
                .message(STUDENT_NOT_FOUND.getMessage())
                .details(Collections.singletonList(ex.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DomainStudentDuplicatedEmailException.class)
    public ErrorResponse handleDuplicatedEmail(DomainStudentDuplicatedEmailException ex) {
        return ErrorResponse.builder()
                .code(STUDENT_EMAIL_DUPLICATED.getCode())
                .message(STUDENT_EMAIL_DUPLICATED.getMessage())
                .details(Collections.singletonList(ex.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }

    // ====== Email ======
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DomainEmailInvalidException.class)
    public ErrorResponse handleEmailInvalid(DomainEmailInvalidException ex) {
        return ErrorResponse.builder()
                .code(STUDENT_EMAIL_INVALID.getCode())
                .message(STUDENT_EMAIL_INVALID.getMessage())
                .details(Collections.singletonList(ex.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DomainEmailNotBlankException.class)
    public ErrorResponse handleEmailNotBlank(DomainEmailNotBlankException ex) {
        return ErrorResponse.builder()
                .code(STUDENT_EMAIL_NOT_BLANK.getCode())
                .message(STUDENT_EMAIL_NOT_BLANK.getMessage())
                .details(Collections.singletonList(ex.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }

    // ====== Nombre ======
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DomainStudentNameInvalidException.class)
    public ErrorResponse handleNameInvalid(DomainStudentNameInvalidException ex) {
        return ErrorResponse.builder()
                .code(STUDENT_NAME_INVALID.getCode())
                .message(STUDENT_NAME_INVALID.getMessage())
                .details(Collections.singletonList(ex.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DomainStudentNameNotBlankException.class)
    public ErrorResponse handleNameNotBlank(DomainStudentNameNotBlankException ex) {
        return ErrorResponse.builder()
                .code(STUDENT_NAME_NOT_BLANK.getCode())
                .message(STUDENT_NAME_NOT_BLANK.getMessage())
                .details(Collections.singletonList(ex.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }

    // ====== Apellido ======
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DomainStudentSurnameInvalidException.class)
    public ErrorResponse handleSurnameInvalid(DomainStudentSurnameInvalidException ex) {
        return ErrorResponse.builder()
                .code(STUDENT_SURNAME_INVALID.getCode())
                .message(STUDENT_SURNAME_INVALID.getMessage())
                .details(Collections.singletonList(ex.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DomainStudentSurnameNotBlankException.class)
    public ErrorResponse handleSurnameNotBlank(DomainStudentSurnameNotBlankException ex) {
        return ErrorResponse.builder()
                .code(STUDENT_SURNAME_NOT_BLANK.getCode())
                .message(STUDENT_SURNAME_NOT_BLANK.getMessage())
                .details(Collections.singletonList(ex.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }

    // ====== Fecha de nacimiento ======
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DomainStudentDateBirhdayInvalidException.class)
    public ErrorResponse handleBirthdayInvalid(DomainStudentDateBirhdayInvalidException ex) {
        return ErrorResponse.builder()
                .code(STUDENT_BIRTHDAY_INVALID.getCode())
                .message(STUDENT_BIRTHDAY_INVALID.getMessage())
                .details(Collections.singletonList(ex.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DomainStudentDateBirthdayNotBlankException.class)
    public ErrorResponse handleBirthdayNotBlank(DomainStudentDateBirthdayNotBlankException ex) {
        return ErrorResponse.builder()
                .code(STUDENT_BIRTHDAY_NOT_BLANK.getCode())
                .message(STUDENT_BIRTHDAY_NOT_BLANK.getMessage())
                .details(Collections.singletonList(ex.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DomainStudentDateBirthdayNotFutureException.class)
    public ErrorResponse handleBirthdayNotFuture(DomainStudentDateBirthdayNotFutureException ex) {
        return ErrorResponse.builder()
                .code(STUDENT_BIRTHDAY_NOT_FUTURE.getCode())
                .message(STUDENT_BIRTHDAY_NOT_FUTURE.getMessage())
                .details(Collections.singletonList(ex.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }

    // ====== ID ======
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DomainStudentIdNotBlankException.class)
    public ErrorResponse handleIdNotBlank(DomainStudentIdNotBlankException ex) {
        return ErrorResponse.builder()
                .code(STUDENT_ID_NOT_BLANK.getCode())
                .message(STUDENT_ID_NOT_BLANK.getMessage())
                .details(Collections.singletonList(ex.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }

    // ====== Validaciones con @Valid ======
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        return ErrorResponse.builder()
                .code(INVALID_STUDENT.getCode())
                .message(INVALID_STUDENT.getMessage())
                .details(result.getFieldErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()))
                .timestamp(LocalDateTime.now())
                .build();
    }

    // ====== Genérico ======
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleGeneric(Exception ex) {
        return ErrorResponse.builder()
                .code(GENERIC_ERROR.getCode())
                .message(GENERIC_ERROR.getMessage())
                .details(Collections.singletonList(ex.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }
}
