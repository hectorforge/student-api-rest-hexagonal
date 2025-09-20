package com.hector.forge.msapirestalumnos.infrastructure.adapter.out.persistence.seeder;

import com.hector.forge.msapirestalumnos.infrastructure.adapter.out.persistence.entity.AlumnoEntity;
import com.hector.forge.msapirestalumnos.infrastructure.adapter.out.persistence.repository.AlumnoJpaRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AlumnoSeeder {

    private final AlumnoJpaRepository alumnoRepository;

    @PostConstruct
    public void seed() {
        if (alumnoRepository.count() == 0) {
            List<AlumnoEntity> alumnos = List.of(
                    AlumnoEntity.builder().id("1").nombre("Juan").apellido("Pérez").email("juan.perez@example.com").fechaNacimiento(LocalDate.of(2000, 5, 10)).activo(true).build(),
                    AlumnoEntity.builder().id("2").nombre("María").apellido("García").email("maria.garcia@example.com").fechaNacimiento(LocalDate.of(1999, 8, 15)).activo(true).build(),
                    AlumnoEntity.builder().id("3").nombre("Carlos").apellido("López").email("carlos.lopez@example.com").fechaNacimiento(LocalDate.of(2001, 1, 20)).activo(true).build(),
                    AlumnoEntity.builder().id("4").nombre("Ana").apellido("Martínez").email("ana.martinez@example.com").fechaNacimiento(LocalDate.of(2002, 3, 5)).activo(true).build(),
                    AlumnoEntity.builder().id("5").nombre("Pedro").apellido("Fernández").email("pedro.fernandez@example.com").fechaNacimiento(LocalDate.of(1998, 12, 12)).activo(true).build(),
                    AlumnoEntity.builder().id("6").nombre("Lucía").apellido("Sánchez").email("lucia.sanchez@example.com").fechaNacimiento(LocalDate.of(2000, 7, 8)).activo(true).build(),
                    AlumnoEntity.builder().id("7").nombre("Miguel").apellido("Ramírez").email("miguel.ramirez@example.com").fechaNacimiento(LocalDate.of(2001, 9, 30)).activo(true).build(),
                    AlumnoEntity.builder().id("8").nombre("Elena").apellido("Torres").email("elena.torres@example.com").fechaNacimiento(LocalDate.of(1997, 4, 25)).activo(true).build(),
                    AlumnoEntity.builder().id("9").nombre("Diego").apellido("Ruiz").email("diego.ruiz@example.com").fechaNacimiento(LocalDate.of(1999, 11, 18)).activo(true).build(),
                    AlumnoEntity.builder().id("10").nombre("Laura").apellido("Morales").email("laura.morales@example.com").fechaNacimiento(LocalDate.of(2002, 2, 28)).activo(true).build()
            );

            //alumnoRepository.saveAll(alumnos);
        }
    }
}