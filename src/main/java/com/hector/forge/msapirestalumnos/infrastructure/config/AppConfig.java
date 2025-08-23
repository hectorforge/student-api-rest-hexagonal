package com.hector.forge.msapirestalumnos.infrastructure.config;

import com.hector.forge.msapirestalumnos.application.service.AlumnoService;
import com.hector.forge.msapirestalumnos.domain.port.out.AlumnoPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public AlumnoService getAlumnoService(AlumnoPersistencePort alumnoPersistencePort) {
        return new AlumnoService(alumnoPersistencePort);
    }
}
