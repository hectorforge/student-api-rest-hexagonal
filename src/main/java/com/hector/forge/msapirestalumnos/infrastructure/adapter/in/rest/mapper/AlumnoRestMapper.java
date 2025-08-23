package com.hector.forge.msapirestalumnos.infrastructure.adapter.in.rest.mapper;

import com.hector.forge.msapirestalumnos.domain.model.Alumno;
import com.hector.forge.msapirestalumnos.infrastructure.adapter.in.rest.dto.AlumnoDTORequest;
import com.hector.forge.msapirestalumnos.infrastructure.adapter.in.rest.dto.AlumnoDTOResponse;

public class AlumnoRestMapper {

    public static Alumno toDomain(AlumnoDTORequest request) {
        return new Alumno(
                request.getNombre(),
                request.getApellido(),
                request.getEmail(),
                request.getFechaNacimiento()
        );
    }

    public static AlumnoDTOResponse toResponse(Alumno alumno) {
        return AlumnoDTOResponse.builder()
                .id(alumno.getId() != null ? alumno.getId().getValue().toString() : null)
                .nombre(alumno.getNombre())
                .apellido(alumno.getApellido())
                .email(alumno.getEmail().getValue())
                .fechaNacimiento(alumno.getFechaNacimiento())
                .activo(alumno.isActivo())
                .nombreCompleto(alumno.getNombreCompleto())
                .edad(alumno.getEdad())
                .build();
    }
}