package com.hector.forge.msapirestalumnos.infrastructure.adapter.out.persistence;

import com.hector.forge.msapirestalumnos.domain.model.Alumno;
import com.hector.forge.msapirestalumnos.domain.port.out.AlumnoPersistencePort;
import com.hector.forge.msapirestalumnos.infrastructure.adapter.out.persistence.entity.AlumnoEntity;
import com.hector.forge.msapirestalumnos.infrastructure.adapter.out.persistence.mapper.AlumnoMapper;
import com.hector.forge.msapirestalumnos.infrastructure.adapter.out.persistence.repository.AlumnoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Evita RuntimeException en su lugar dejemoslo Optional.empty(), de
 * esa forma dejamos la responsabilidad de lanzar exepciones
 * de negocio a la capa Service del "application"
 */
@Component
@RequiredArgsConstructor
public class AlumnoPersistenceAdapter implements AlumnoPersistencePort {

    private final AlumnoJpaRepository alumnoJpaRepository;
    private final AlumnoMapper alumnoMapper;

    @Override
    public List<Alumno> getAll() {
        return alumnoJpaRepository.findAll()
                .stream()
                .map(AlumnoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Alumno> getAllEnabled() {
        return alumnoJpaRepository.findAll()
                .stream()
                .filter(AlumnoEntity::isActivo)
                .map(AlumnoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Alumno> getById(String id) {
        return alumnoJpaRepository.findById(id)
                .map(AlumnoMapper::toDomain);
    }

    @Override
    public Optional<Alumno> getByEmail(String email) {
        return alumnoJpaRepository.findByEmailIgnoreCase(email)
                .map(AlumnoMapper::toDomain);
    }

    @Override
    public Alumno save(Alumno alumno) {
        AlumnoEntity entity = AlumnoMapper.toEntity(alumno);
        AlumnoEntity saved = alumnoJpaRepository.save(entity);
        return AlumnoMapper.toDomain(saved);
    }

    @Override
    public Alumno update(String id, Alumno alumno) {
        // devolvemos Optional vacío si no existe, la excepción la lanza el Service
        return alumnoJpaRepository.findById(id)
                .map(existing -> {
                    existing.setNombre(alumno.getNombre());
                    existing.setApellido(alumno.getApellido());
                    existing.setEmail(alumno.getEmail().getValue());
                    existing.setFechaNacimiento(alumno.getFechaNacimiento());
                    existing.setActivo(alumno.isActivo());
                    return AlumnoMapper.toDomain(alumnoJpaRepository.save(existing));
                })
                .orElse(null);
    }

    @Override
    public void delete(String id) {
        alumnoJpaRepository.findById(id)
                .ifPresent(alumnoJpaRepository::delete);
    }

    @Override
    public boolean existByEmail(String email) {
        return alumnoJpaRepository.existsByEmailIgnoreCase(email);
    }
}