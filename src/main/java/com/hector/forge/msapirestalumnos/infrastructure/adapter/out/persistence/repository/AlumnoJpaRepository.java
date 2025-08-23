package com.hector.forge.msapirestalumnos.infrastructure.adapter.out.persistence.repository;

import com.hector.forge.msapirestalumnos.infrastructure.adapter.out.persistence.entity.AlumnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlumnoJpaRepository extends JpaRepository<AlumnoEntity, String> {
    Optional<AlumnoEntity> findByEmailIgnoreCase(String email);
    boolean existsByEmailIgnoreCase(String email);
}
