package com.hector.forge.msapirestalumnos.infrastructure.adapter.out.persistence.mapper;

import com.hector.forge.msapirestalumnos.domain.model.Alumno;
import com.hector.forge.msapirestalumnos.domain.valueobject.AlumnoId;
import com.hector.forge.msapirestalumnos.domain.valueobject.Email;
import com.hector.forge.msapirestalumnos.infrastructure.adapter.out.persistence.entity.AlumnoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AlumnoMapper {

    public static AlumnoEntity toEntity(Alumno alumno) {
        return AlumnoEntity.builder()
                .id(alumno.getId() != null ? alumno.getId().getValue() : null)
                .nombre(alumno.getNombre())
                .apellido(alumno.getApellido())
                .email(alumno.getEmail().getValue())
                .fechaNacimiento(alumno.getFechaNacimiento())
                .activo(alumno.isActivo())
                .build();
    }

    public static Alumno toDomain(AlumnoEntity entity) {
        return new Alumno(
                new AlumnoId(entity.getId()),
                entity.getNombre(),
                entity.getApellido(),
                new Email(entity.getEmail()),
                entity.getFechaNacimiento(),
                entity.isActivo(),
                new ArrayList<>()
        );
    }
}
