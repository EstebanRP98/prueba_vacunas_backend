# # Prueba Vacunas Kruger

## Especificaciones del Proyecto
- Tecnologías que se utilizaron en el proyecto es:
    * Lenguaje: JAVA
    * Framework: Spring boot.
    * Base de datos: Postgresql.
      Puerto: 5432
      Nombre Base de Datos: kruvacunas
      User: admin
      Password: admin
    * Docker
    * JUnit 5 TDD
    * Swagger 3

  
## Generacion del Proyecto
- El proyecto esta basado en Maven, se procedio a crear la base de datos en postgresql mediante un script.
    Se creo el proyecto para poder llevar un inventario de empleados, y registrar su vacunacion:
    **ADMIN**
    * Crear, buscar, eliminar y filtrar a los empleados.
    **Empleado**
    * Actualizar su informacion de las vacunas como la cantidad de dosis que posee.
    
Para crear los contendedores se utilizo docker compose.

## TDD

- Para el proyecto se hizo unas pruebas TDD simples de JPA, con los repositorios para probar el listado y el ingreso del empleado, con ello se realizo la prueba de los campos con sus respectivas validaciones.

## Desplegar la aplicación

  **Requisitos**
    Descargar docker
    
  * Context Path
    context-path=/api/kruvacunas
    
    **Pasos**
    1. Primero se procede a clonar el repositorio
        https://github.com/EstebanRP98/prueba_vacunas_backend.git
    2. Despues se procede a ingresar al proyecto y en la misma raiz del proyecto corremos el siguiente comando
        **docker-compose up -d** 
    3. Procedemos a Ingresar a swagger ui 3 mediante el siguiente link
    http://localhost:9100/api/kruvacunas/swagger-ui/index.html?configUrl=/api/kruvacunas/v3/api-docs/swagger-config#
    4. Probar los endpoint generados para el proyecto.

Gracias.
