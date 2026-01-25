# CRUD MVC con Thymeleaf — RA3

## 1) Datos del alumno/a
- Entidad elegida : Cancion

## 2) Repositorio (fork) y gestión de versiones
- Repositorio base: https://github.com/profeInformatica101/tareasSpringBoot
- Enlace a MI fork: https://github.com/SergioCamposDelgado/tareasSpringBoot
- Nº de commits realizados: 10

## 3) Arquitectura
Explica brevemente cómo has organizado:
- Controller: com.example.ra3.controlador.CancionController
- Service: com.example.ra3.servicio.CancionServicio
- Repository: com.example.ra3.datos.IniciarDatos
- Entity: com.example.ra3.entidad.Cancion

## 4) Base de datos elegida (marca una)
- [X] H2
- [ ] MySQL
- [ ] PostgreSQL

## 5) Configuración de la base de datos
### 5.1 Dependencias añadidas
      <dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-h2console</artifactId>
		</dependency>

### 5.2 application.properties / application.yml

spring.application.name=ra3
server.port=9000

spring.h2.console.enabled=true
spring.h2.console.path=/h2

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.hibernate.ddl-auto=create-drop

### 5.3 Pasos para crear la BD (si aplica)
No aplica (H2 esta en memoria)

## 6) Cómo ejecutar el proyecto
1. Requisitos (Java versión, Maven/Gradle, DB instalada si aplica)
   Java 17 + Maven
2. Comando de arranque:
   - ./mvnw spring-boot:run   (o equivalente)
3. URL de acceso:
   - http://localhost:9000/

## 7) Pantallas / Rutas MVC
- GET /entidad (listar)
- GET /entidad/nuevo (formulario alta)
- POST /entidad (crear)
- GET /entidad/{id}/editar (editar)
- POST /entidad/{id} (actualizar)
- POST /entidad/{id}/borrar (eliminar)


## 8) Mejoras extra (opcional)
- Validaciones
- Estilos Bootstrap
- Búsqueda
- Pruebas
- Paginación
