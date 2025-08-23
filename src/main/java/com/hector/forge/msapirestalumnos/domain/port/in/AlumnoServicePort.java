package com.hector.forge.msapirestalumnos.domain.port.in;

import com.hector.forge.msapirestalumnos.domain.model.Alumno;

import java.util.List;

/**
 * El servicio lo mas limpio sin detalles tecnicos
 * como Optional, ResponseEntity o cosas de ese tipo
 */
public interface AlumnoServicePort {
    List<Alumno> listar();
    List<Alumno> listarActivos();
    Alumno obtenerAlumnoPorId(String id);
    Alumno guardar(Alumno alumno);
    Alumno actualizar(String id, Alumno alumno);
    void eliminar(String id);
    void desactivar(String id);
    void activar(String id);
}
