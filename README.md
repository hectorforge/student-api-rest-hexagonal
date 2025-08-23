# 🚀 API de gestion de Alumnos (ARQUITECTURA HEXAGONAL)

Este proyecto expone un conjunto de endpoints REST.

## 📸 Ejemplos de pruebas en Postman

### 🔹 Endpoint: Listar Alumnos
![Crear Usuario](assets/listarAlumnos.png)

### 🔹 Endpoint: Obtener Alumno Por ID
![Crear Usuario](assets/obtenerAlumno.png)

### 🔹 Endpoint: Crear Alumno
![Crear Usuario](assets/crearAlumno.png)

### 🔹 Endpoint: Actualizar Alumno
![Crear Usuario](assets/actualizarAlumno.png)

### 🔹 Endpoint: Eliminar Alumno
![Crear Usuario](assets/eliminarAlumno.png)

### 🔹 Endpoint: Activar a un Alumno
![Crear Usuario](assets/activar.png)

### 🔹 Endpoint: Desactivar a un Alumno
![Crear Usuario](assets/desactivar.png)

## 📂 Colección Postman

Puedes importar la colección de Postman para probar los endpoints:  
[Descargar colección aquí](postman/Crud-Alumnos.postman_collection.json)

## 🏠 Estructura del proyecto 

```plaintext
+---main
|   +---java
|   |   \---com
|   |       \---hector
|   |           \---forge
|   |               \---msapirestalumnos
|   |                   |   MsApirestAlumnosApplication.java
|   |                   |
|   |                   +---application
|   |                   |   +---exception
|   |                   |   |       DomainStudentDuplicatedEmailException.java
|   |                   |   |       DomainStudentNotFoundException.java
|   |                   |   |
|   |                   |   \---service
|   |                   |           AlumnoService.java
|   |                   |
|   |                   +---domain
|   |                   |   +---event
|   |                   |   |       AlumnoCreado.java
|   |                   |   |
|   |                   |   +---exception
|   |                   |   |       DomainEmailInvalidException.java
|   |                   |   |       DomainEmailNotBlankException.java
|   |                   |   |       DomainStudentDateBirhdayInvalidException.java
|   |                   |   |       DomainStudentDateBirthdayNotBlankException.java
|   |                   |   |       DomainStudentDateBirthdayNotFutureException.java
|   |                   |   |       DomainStudentIdNotBlankException.java
|   |                   |   |       DomainStudentNameInvalidException.java
|   |                   |   |       DomainStudentNameNotBlankException.java
|   |                   |   |       DomainStudentSurnameInvalidException.java
|   |                   |   |       DomainStudentSurnameNotBlankException.java
|   |                   |   |
|   |                   |   +---model
|   |                   |   |       Alumno.java
|   |                   |   |
|   |                   |   +---port
|   |                   |   |   +---in
|   |                   |   |   |       AlumnoServicePort.java
|   |                   |   |   |
|   |                   |   |   \---out
|   |                   |   |           AlumnoPersistencePort.java
|   |                   |   |
|   |                   |   \---valueobject
|   |                   |           AlumnoId.java
|   |                   |           Email.java
|   |                   |
|   |                   \---infrastructure
|   |                       +---adapter
|   |                       |   +---in
|   |                       |   |   \---rest
|   |                       |   |       |   AlumnoRestController.java
|   |                       |   |       |
|   |                       |   |       +---advice
|   |                       |   |       |       GlobalControllerAdvice.java
|   |                       |   |       |
|   |                       |   |       +---dto
|   |                       |   |       |       AlumnoDTORequest.java
|   |                       |   |       |       AlumnoDTOResponse.java
|   |                       |   |       |       ErrorCatalog.java
|   |                       |   |       |       ErrorResponse.java
|   |                       |   |       |
|   |                       |   |       \---mapper
|   |                       |   |               AlumnoRestMapper.java
|   |                       |   |
|   |                       |   \---out
|   |                       |       \---persistence
|   |                       |           |   AlumnoPersistenceAdapter.java
|   |                       |           |
|   |                       |           +---entity
|   |                       |           |       AlumnoEntity.java
|   |                       |           |
|   |                       |           +---mapper
|   |                       |           |       AlumnoMapper.java
|   |                       |           |
|   |                       |           +---repository
|   |                       |           |       AlumnoJpaRepository.java
|   |                       |           |
|   |                       |           \---seeder
|   |                       |                   AlumnoSeeder.java
|   |                       |
|   |                       +---config
|   |                       |       AppConfig.java
|   |                       |
|   |                       \---exception
|   \---resources
|       |   application.yml
|       |
|       +---static
|       \---templates
\---test
    \---java
        \---com
            \---hector
                \---forge
                    \---msapirestalumnos
                            MsApirestAlumnosApplicationTests.java
```
