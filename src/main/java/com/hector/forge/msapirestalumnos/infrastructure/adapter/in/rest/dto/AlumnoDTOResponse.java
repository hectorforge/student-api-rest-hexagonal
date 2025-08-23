package com.hector.forge.msapirestalumnos.infrastructure.adapter.in.rest.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AlumnoDTOResponse {
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private LocalDate fechaNacimiento;
    private boolean activo;
    private String nombreCompleto;
    private int edad;
}
