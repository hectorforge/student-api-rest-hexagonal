package com.hector.forge.msapirestalumnos.domain.event;

import com.hector.forge.msapirestalumnos.domain.valueobject.AlumnoId;
import lombok.Value;
import java.time.LocalDateTime;

@Value
public class AlumnoCreado {
    AlumnoId alumnoId;
    String nombre;
    String apellido;
    LocalDateTime fechaCreacion;

    public AlumnoCreado(AlumnoId alumnoId, String nombre, String apellido) {
        this.alumnoId = alumnoId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaCreacion = LocalDateTime.now();
    }
}