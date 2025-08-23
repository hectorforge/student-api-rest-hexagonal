package com.hector.forge.msapirestalumnos.domain.valueobject;

import com.hector.forge.msapirestalumnos.domain.exception.DomainStudentIdNotBlankException;
import lombok.Value;

import java.util.UUID;

@Value
public class AlumnoId {
    String value;

    public AlumnoId(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new DomainStudentIdNotBlankException("El ID del alumno no puede estar vacío");
        }
        this.value = value.trim();
    }

    public static AlumnoId generar() {
        return new AlumnoId(UUID.randomUUID().toString());
    }

    public static AlumnoId of(String value) {
        return new AlumnoId(value);
    }
}
