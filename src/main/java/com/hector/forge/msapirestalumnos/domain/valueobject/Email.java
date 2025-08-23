package com.hector.forge.msapirestalumnos.domain.valueobject;

import com.hector.forge.msapirestalumnos.domain.exception.DomainEmailInvalidException;
import com.hector.forge.msapirestalumnos.domain.exception.DomainEmailNotBlankException;
import lombok.Value;

import java.util.regex.Pattern;

@Value
public class Email {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    String value;

    public Email(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new DomainEmailNotBlankException("El email no puede estar vacío");
        }
        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new DomainEmailInvalidException("Formato de email inválido");
        }
        this.value = value.toLowerCase().trim();
    }
}