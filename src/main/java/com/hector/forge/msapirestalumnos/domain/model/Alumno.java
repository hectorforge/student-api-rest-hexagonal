package com.hector.forge.msapirestalumnos.domain.model;

import com.hector.forge.msapirestalumnos.domain.event.AlumnoCreado;
import com.hector.forge.msapirestalumnos.domain.exception.*;
import com.hector.forge.msapirestalumnos.domain.valueobject.AlumnoId;
import com.hector.forge.msapirestalumnos.domain.valueobject.Email;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {
    private AlumnoId id;
    private String nombre;
    private String apellido;
    private Email email;
    private LocalDate fechaNacimiento;
    private boolean activo;
    private List<AlumnoCreado> eventos = new ArrayList<>();

    public Alumno(String nombre, String apellido, String email, LocalDate fechaNacimiento) {
        this.id = AlumnoId.generar();
        this.nombre = validarNombre(nombre);
        this.apellido = validarApellido(apellido);
        this.email = new Email(email);
        this.fechaNacimiento = validarFechaNacimiento(fechaNacimiento);
        this.activo = true;

        // Evento de dominio
        this.eventos.add(new AlumnoCreado(this.id, this.nombre, this.apellido));
    }

    public void actualizar(String nombre, String apellido, String email, LocalDate fechaNacimiento) {
        this.nombre = validarNombre(nombre);
        this.apellido = validarApellido(apellido);
        this.email = new Email(email);
        this.fechaNacimiento = validarFechaNacimiento(fechaNacimiento);
    }

    public void desactivar() {
        this.activo = false;
    }

    public void activar() {
        this.activo = true;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public int getEdad() {
        return LocalDate.now().getYear() - fechaNacimiento.getYear();
    }

    private String validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DomainStudentNameNotBlankException("El nombre no puede estar vacío");
        }
        if (nombre.length() < 2 || nombre.length() > 50) {
            throw new DomainStudentNameInvalidException("El nombre debe tener entre 2 y 50 caracteres");
        }
        return nombre.trim();
    }

    private String validarApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new DomainStudentSurnameNotBlankException("El apellido no puede estar vacío");
        }
        if (apellido.length() < 2 || apellido.length() > 50) {
            throw new DomainStudentSurnameInvalidException("El apellido debe tener entre 2 y 50 caracteres");
        }
        return apellido.trim();
    }

    private LocalDate validarFechaNacimiento(LocalDate fecha) {
        if (fecha == null) {
            throw new DomainStudentDateBirthdayNotBlankException("La fecha de nacimiento no puede ser nula");
        }
        if (fecha.isAfter(LocalDate.now())) {
            throw new DomainStudentDateBirthdayNotFutureException("La fecha de nacimiento no puede ser futura");
        }
        if (fecha.isBefore(LocalDate.now().minusYears(100))) {
            throw new DomainStudentDateBirhdayInvalidException("La fecha de nacimiento no puede ser mayor a 100 años");
        }
        return fecha;
    }
}
