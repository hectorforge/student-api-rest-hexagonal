package com.hector.forge.msapirestalumnos.application.service;

import com.hector.forge.msapirestalumnos.application.exception.DomainStudentDuplicatedEmailException;
import com.hector.forge.msapirestalumnos.application.exception.DomainStudentNotFoundException;
import com.hector.forge.msapirestalumnos.domain.model.Alumno;
import com.hector.forge.msapirestalumnos.domain.port.in.AlumnoServicePort;
import com.hector.forge.msapirestalumnos.domain.port.out.AlumnoPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Aqui ya tenemos que lanzar las excepciones del negocio
 * del "domain"
 */
@Service
@RequiredArgsConstructor
public class AlumnoService implements AlumnoServicePort {

    private final AlumnoPersistencePort alumnoPersistencePort;

    @Override
    public List<Alumno> listar() {
        return alumnoPersistencePort.getAll();
    }

    @Override
    public List<Alumno> listarActivos() {
        return alumnoPersistencePort.getAllEnabled();
    }

    @Override
    public Alumno obtenerAlumnoPorId(String id) {
        return alumnoPersistencePort.getById(id)
                .orElseThrow(() -> new DomainStudentNotFoundException(id));
    }

    @Override
    public Alumno guardar(Alumno alumno) {
        if (alumnoPersistencePort.existByEmail(alumno.getEmail().getValue())) {
            throw new DomainStudentDuplicatedEmailException(alumno.getEmail().getValue());
        }
        return alumnoPersistencePort.save(alumno);
    }

    @Override
    public Alumno actualizar(String id, Alumno alumno) {
        Alumno updated = alumnoPersistencePort.update(id, alumno);
        if (updated == null) {
            throw new DomainStudentNotFoundException(id);
        }
        return updated;
    }

    @Override
    public void eliminar(String id) {
        if (alumnoPersistencePort.getById(id).isEmpty()) {
            throw new DomainStudentNotFoundException(id);
        }
        alumnoPersistencePort.delete(id);
    }

    @Override
    public void desactivar(String id) {
        Alumno alumno = obtenerAlumnoPorId(id);
        alumno.desactivar();
        alumnoPersistencePort.update(id, alumno);
    }

    @Override
    public void activar(String id) {
        Alumno alumno = obtenerAlumnoPorId(id);
        alumno.activar();
        alumnoPersistencePort.update(id, alumno);
    }
}