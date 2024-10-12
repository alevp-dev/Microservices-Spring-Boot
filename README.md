# APIs-con-Java-Spring-Boot
Este proyecto consiste en el desarrollo de una API RESTful para la gestión de órdenes de compra utilizando Java Spring Boot. La arquitectura del proyecto está basada en microservicios, y las relaciones entre entidades se gestionan a través de JPA/Hibernate.

Cada endpoint ha sido probado utilizando Postman, y se han implementado pruebas automatizadas con JUnit y Mockito para validar la funcionalidad de los servicios.

Características
Arquitectura basada en microservicios.
Gestión de órdenes de compra y clientes.
Relacionamientos entre entidades manejados mediante JPA/Hibernate.
Pruebas automatizadas utilizando JUnit y Mockito.
Pruebas de integración de APIs utilizando Postman.

Tecnologías utilizadas
Java Spring Boot: Para la implementación del backend y los microservicios.
JPA/Hibernate: Para la persistencia de datos y la gestión de relaciones entre entidades.
Postman: Para la prueba de los endpoints REST.
JUnit: Para las pruebas unitarias.
Mockito: Para la simulación de dependencias en las pruebas unitarias.

Pruebas
El proyecto incluye pruebas automatizadas para los servicios de las siguientes entidades:

Cliente: Creación, actualización, obtención y eliminación de clientes.
Pago: Procesamiento y validación de pagos.
Producto: Gestión de inventario y disponibilidad de productos.
Notificador: Notificaciones relacionadas con órdenes y clientes.
Orden: Creación, actualización y eliminación de órdenes.
OrdenDetalle: Gestión de los detalles de cada orden.
Inventario: Mantenimiento y seguimiento de niveles de inventario.
Cada servicio ha sido probado con simulaciones de repositorios usando Mockito, y las respuestas y comportamientos esperados se validaron con JUnit.

Para ejecutar las pruebas automatizadas:

Clona el repositorio.
Asegúrate de tener JUnit y Mockito configurados en tu proyecto.
Ejecuta los tests desde tu IDE o mediante el comando de Maven:
bash
Copy code
mvn test
