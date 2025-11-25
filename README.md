# 📦 Nexus Stock Service (API REST)

> **Trabajo Práctico Integrador - Programación III - UTN**
>
> **Alumno:** Luna Marcelo Joaquin
> **Legajo:** 52685

## 📋 Descripción del Proyecto
Este proyecto consiste en el desarrollo de una **API RESTful** profesional para la gestión centralizada de inventario y control de stock ("Nexus Stock Service").

La aplicación implementa una **arquitectura en capas** (Controller, Service, Repository, Model) asegurando la separación de responsabilidades y la escalabilidad. Incluye validaciones robustas, manejo global de excepciones, persistencia de datos y documentación automática.

## 🛠️ Tecnologías Utilizadas
* **Java 17**
* **Spring Boot 3.3.0**
* **Spring Data JPA**
* **H2 Database**
* **Bean Validation**
* **Swagger / OpenAPI**
* **Maven**

---

## 🚀 Instrucciones de Ejecución

### 1. Clonar el repositorio
```bash
git clone [https://github.com/Blinnnnd/Api-Rest-Spring-Boot.git](https://github.com/Blinnnnd/Api-Rest-Spring-Boot.git)
cd Api-Rest-Spring-Boot
2. Ejecutar la aplicaciónEl proyecto utiliza el wrapper de Maven (mvnw) para facilitar la ejecución sin necesidad de tener Maven instalado globalmente.En Windows:DOS./mvnw.cmd spring-boot:run
En Mac/Linux:Bash./mvnw spring-boot:run
La aplicación iniciará en el puerto 8080.🔌 Tabla de Endpoints (API Reference)MétodoRutaDescripciónGET/api/productosObtiene el catálogo completo de productos.GET/api/productos/{id}Busca el detalle de un producto por ID.GET/api/productos/categoria/{cat}Filtra el inventario por categoría (ej: ELECTRONICA).POST/api/productosRegistra un nuevo ítem (valida datos de entrada).PUT/api/productos/{id}Actualiza la información completa de un producto.PATCH/api/productos/{id}/stockAjuste rápido de nivel de stock.DELETE/api/productos/{id}Da de baja un producto del sistema.📚 Documentación y Herramientas🟢 Documentación API (Swagger)Acceso interactivo a la documentación y pruebas de endpoints:👉 http://localhost:8080/swagger-ui.html🗄️ Acceso a Consola H2Para verificar la base de datos en memoria:👉 URL: http://localhost:8080/h2-console⚠️ Importante: Al ingresar, asegúrese de usar esta configuración exacta:JDBC URL: jdbc:h2:mem:productosdbUser Name: saPassword: (dejar vacío)(Nota: Si la consola sugiere testdb por defecto, cámbielo manualmente a productosdb).📸 Evidencia de Pruebas (Screenshots)1. Documentación Completa (Swagger UI)Se muestra la interfaz de Swagger con todos los controladores documentados bajo el nombre "Administración de Inventario".2. Creación de Producto (POST 201 Created)Prueba de creación exitosa de un producto válido.3. Listado de Productos (GET 200 OK)Recuperación de la lista de productos cargados.4. Manejo de Errores (404 Not Found)Intento de obtener un ID que no existe (ej: ID 999).5. Validación de Datos (400 Bad Request)Intento de crear producto con precio negativo o nombre vacío.6. Persistencia en Base de Datos (H2 Console)Evidencia de que los datos se guardaron en la tabla PRODUCTOS.🧠 Conclusiones PersonalesEl desarrollo de este Trabajo Práctico me permitió consolidar los conocimientos sobre la arquitectura REST en el ecosistema Spring Boot. Puntos clave aprendidos:Importancia de la Arquitectura en Capas: Entendí cómo separar la lógica de negocio (Service) del manejo de peticiones (Controller) facilita el mantenimiento.DTOs vs Entidades: Aprendí a no exponer mis entidades de base de datos directamente, utilizando DTOs para controlar qué datos entran y salen de la API.Manejo de Errores: La implementación de GlobalExceptionHandler permite dar respuestas limpias y profesionales al cliente.Documentación Viva: Swagger resulta indispensable para que otros desarrolladores entiendan y prueben la API sin necesidad de leer el código fuente.Tecnicatura Universitaria en Programación - UTN
