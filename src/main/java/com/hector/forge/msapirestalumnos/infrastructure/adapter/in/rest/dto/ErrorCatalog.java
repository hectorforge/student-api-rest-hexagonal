package com.hector.forge.msapirestalumnos.infrastructure.adapter.in.rest.dto;

import lombok.Getter;

@Getter
public enum ErrorCatalog {

    // Alumno no encontrado
    STUDENT_NOT_FOUND("ERR_STUDENT_001", "Alumno no encontrado."),

    // Email
    STUDENT_EMAIL_INVALID("ERR_STUDENT_002", "Formato de email inválido."),
    STUDENT_EMAIL_NOT_BLANK("ERR_STUDENT_003", "El email no puede estar vacío."),
    STUDENT_EMAIL_DUPLICATED("ERR_STUDENT_004", "El email ya está registrado."),

    // Nombre
    STUDENT_NAME_INVALID("ERR_STUDENT_005", "El nombre es inválido."),
    STUDENT_NAME_NOT_BLANK("ERR_STUDENT_006", "El nombre no puede estar vacío."),

    // Apellido
    STUDENT_SURNAME_INVALID("ERR_STUDENT_007", "El apellido es inválido."),
    STUDENT_SURNAME_NOT_BLANK("ERR_STUDENT_008", "El apellido no puede estar vacío."),

    // Fecha de nacimiento
    STUDENT_BIRTHDAY_INVALID("ERR_STUDENT_009", "Fecha de nacimiento inválida."),
    STUDENT_BIRTHDAY_NOT_BLANK("ERR_STUDENT_010", "La fecha de nacimiento no puede estar vacía."),
    STUDENT_BIRTHDAY_NOT_FUTURE("ERR_STUDENT_011", "La fecha de nacimiento no puede ser futura."),

    // ID
    STUDENT_ID_NOT_BLANK("ERR_STUDENT_012", "El identificador no puede estar vacío."),

    // Invalid
    INVALID_STUDENT("ERR_STUDENT_013","Formato invalido"),

    // Error generico
    GENERIC_ERROR("ERR_GEN_001", "Ha ocurrido un error inesperado.");

    private final String code;
    private final String message;

    ErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}