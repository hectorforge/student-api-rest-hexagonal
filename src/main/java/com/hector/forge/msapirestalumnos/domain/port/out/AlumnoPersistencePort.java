package com.hector.forge.msapirestalumnos.domain.port.out;

import com.hector.forge.msapirestalumnos.domain.model.Alumno;

import java.util.List;
import java.util.Optional;

/**
 * Aqui ya podriamos tener Optionals y cosas tecnicas
 * referentes al puerto externo de persistencia
 */
public interface AlumnoPersistencePort {
    List<Alumno> getAll();
    List<Alumno> getAllEnabled();
    Optional<Alumno> getById(String id);
    Optional<Alumno> getByEmail(String email);
    Alumno save(Alumno alumno);
    Alumno update(String id, Alumno alumno);
    void delete(String id);
    boolean existByEmail(String email);
}