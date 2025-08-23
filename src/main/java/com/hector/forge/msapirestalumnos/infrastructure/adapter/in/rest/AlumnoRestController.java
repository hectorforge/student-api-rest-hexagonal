package com.hector.forge.msapirestalumnos.infrastructure.adapter.in.rest;

import com.hector.forge.msapirestalumnos.application.service.AlumnoService;
import com.hector.forge.msapirestalumnos.domain.model.Alumno;
import com.hector.forge.msapirestalumnos.infrastructure.adapter.in.rest.dto.AlumnoDTORequest;
import com.hector.forge.msapirestalumnos.infrastructure.adapter.in.rest.dto.AlumnoDTOResponse;
import com.hector.forge.msapirestalumnos.infrastructure.adapter.in.rest.mapper.AlumnoRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/alumnos")
@RequiredArgsConstructor
public class AlumnoRestController {

    private final AlumnoService alumnoService;

    @PostMapping
    public ResponseEntity<AlumnoDTOResponse> crearAlumno(@Valid @RequestBody AlumnoDTORequest request) {
        Alumno alumno = AlumnoRestMapper.toDomain(request);
        Alumno creado = alumnoService.guardar(alumno);
        return ResponseEntity.ok(AlumnoRestMapper.toResponse(creado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDTOResponse> obtenerAlumno(@PathVariable String id) {
        Alumno alumno = alumnoService.obtenerAlumnoPorId(id);
        return ResponseEntity.ok(AlumnoRestMapper.toResponse(alumno));
    }

    @GetMapping
    public ResponseEntity<List<AlumnoDTOResponse>> listarAlumnos() {
        List<Alumno> alumnos = alumnoService.listar();
        return ResponseEntity.ok(
                alumnos.stream()
                        .map(AlumnoRestMapper::toResponse)
                        .collect(Collectors.toList())
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDTOResponse> actualizarAlumno(@PathVariable String id,
                                                              @Valid @RequestBody AlumnoDTORequest request) {
        Alumno alumno = AlumnoRestMapper.toDomain(request);
        Alumno actualizado = alumnoService.actualizar(id, alumno);
        return ResponseEntity.ok(AlumnoRestMapper.toResponse(actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable String id) {
        alumnoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivarAlumno(@PathVariable String id) {
        alumnoService.desactivar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/activar")
    public ResponseEntity<Void> activarAlumno(@PathVariable String id) {
        alumnoService.activar(id);
        return ResponseEntity.noContent().build();
    }
}