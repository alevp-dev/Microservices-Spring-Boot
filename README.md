# Microservices with Spring Boot  

This project is a **RESTful API** for managing **purchase orders** using **Java Spring Boot**. It follows a **microservices-based architecture**, leveraging **JPA/Hibernate** for entity relationships and **JUnit/Mockito** for automated testing. The project provides endpoints for handling customers, orders, and products in an e-commerce environment.

Each endpoint has been tested using **Postman**, ensuring reliability and correctness across all entities.  

## Project Structure
```
src/
├── main/
│   ├── java/
│   │   └── storeOnline/
│   │       └── SpringBoot/
│   │           ├── config/
│   │           ├── controller/
│   │           ├── model/
│   │           ├── repository/
│   │           ├── service/
│   │           └── StoreOnlineApplication.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── storeOnline/
            └── SpringBoot/
                └── tests/
```

## Features  
✔️ Microservices-based architecture.  
✔️ Management of **purchase orders, customers, payments, products, notifications, order details, and inventory**.  
✔️ Entity relationships handled with **JPA/Hibernate**.  
✔️ Automated testing using **JUnit and Mockito**.  
✔️ API integration testing with **Postman**.  
✔️ API documentation with **Swagger**.  

## Technologies Used  
* **Java Spring Boot** – Backend implementation and microservices.
* **JPA/Hibernate** – Data persistence and entity relationship management.  
* **Postman** – API testing.  
* **JUnit** – Unit testing.  
* **Mockito** – Mocking dependencies in unit tests.
* **Lombok** 
* **MySQL** 
* **Spring Boot 3.2.2** 
* **Spring Data JPA** 
* **Spring Web MVC** 
* **Springdoc OpenAPI 3.0** 

## API Documentation
The API documentation is available through Swagger UI:

- Swagger UI: http://localhost:8080/swagger-ui.html
- OpenAPI Documentation: http://localhost:8080/api-docs

## Build
To build the project:
```
mvn clean install
```

## Tests  
The project includes automated tests covering the following entities:  

- **Customer**: Creation, update, retrieval, and deletion.  
- **Payment**: Processing and validation.  
- **Product**: Inventory management and availability checks.  
- **Notifier**: Notifications for orders and customers.  
- **Order**: Creation, update, and deletion.  
- **OrderDetail**: Management of order details.  
- **Inventory**: Maintenance and tracking of stock levels.  

Each service is tested using **mocked repositories** with **Mockito**, ensuring expected responses and behaviors through **JUnit** assertions.  

## Running the Tests  
1️⃣ **Clone the repository:**  
````
git clone https://github.com/your-username/your-repo.git
cd your-repo
````
2️⃣ **Ensure that JUnit and Mockito are properly set up.**

3️⃣ **Run the tests using Maven:**
````
mvn test
````
----
# Microservicios con Spring Boot

Este proyecto es una **API RESTful** para la gestión de **órdenes de compra** utilizando **Java Spring Boot**. Sigue una **arquitectura basada en microservicios**, aprovechando **JPA/Hibernate** para las relaciones entre entidades y **JUnit/Mockito** para pruebas automatizadas. El proyecto proporciona endpoints para gestionar clientes, órdenes y productos en un entorno de comercio electrónico.

Cada endpoint ha sido probado usando **Postman**, garantizando confiabilidad y exactitud en todas las entidades.

## Estructura del Proyecto
```
src/
├── main/
│   ├── java/
│   │   └── storeOnline/
│   │       └── SpringBoot/
│   │           ├── config/
│   │           ├── controller/
│   │           ├── model/
│   │           ├── repository/
│   │           ├── service/
│   │           └── StoreOnlineApplication.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── storeOnline/
            └── SpringBoot/
                └── tests/
```

## Funcionalidades  
✔️ Arquitectura basada en microservicios.  
✔️ Gestión de **órdenes de compra, clientes, pagos, productos, notificaciones, detalles de órdenes e inventario**.  
✔️ Relaciones entre entidades manejadas con **JPA/Hibernate**.  
✔️ Pruebas automatizadas usando **JUnit y Mockito**.  
✔️ Pruebas de integración de la API con **Postman**.  
✔️ Documentación de la API con **Swagger**.

## Tecnologías Utilizadas  
- **Java Spring Boot** – Implementación del backend y microservicios  
- **JPA/Hibernate** – Persistencia de datos y gestión de relaciones entre entidades  
- **Postman** – Pruebas de la API  
- **JUnit** – Pruebas unitarias  
- **Mockito** – Simulación de dependencias en pruebas unitarias  
- **Lombok**  
- **MySQL**  
- **Spring Boot 3.2.2**  
- **Spring Data JPA**  
- **Spring Web MVC**  
- **Springdoc OpenAPI 3.0**  


## Documentación de la API  
La documentación de la API está disponible mediante Swagger UI:

- [Swagger UI](http://localhost:8080/swagger-ui.html)  
- [Documentación OpenAPI](http://localhost:8080/api-docs)

## Compilación  
Para compilar el proyecto, ejecuta:
```
mvn clean install
```

## Pruebas  
El proyecto incluye pruebas automatizadas que cubren las siguientes entidades:

- **Cliente**: Creación, actualización, consulta y eliminación  
- **Pago**: Procesamiento y validación  
- **Producto**: Gestión de inventario y verificación de disponibilidad  
- **Notificador**: Notificaciones para órdenes y clientes  
- **Orden**: Creación, actualización y eliminación  
- **Detalle de Orden**: Gestión de los detalles de cada orden  
- **Inventario**: Mantenimiento y seguimiento de niveles de stock

Cada servicio es probado utilizando **repositorios simulados (mocked)** con **Mockito**, garantizando respuestas y comportamientos esperados mediante aserciones de **JUnit**.


## Ejecución de Pruebas  

1️⃣ Clona el repositorio:  
```bash
git clone https://github.com/your-username/your-repo.git
cd your-repo
```

2️⃣ Asegúrate de que JUnit y Mockito estén correctamente configurados.  

3️⃣ Ejecuta las pruebas con Maven:  
```bash
mvn test
```
---

# Contributions
Contributions, issues, and feature requests are welcome! Feel free to fork this repository and submit a pull request.

---
Developed with ❤️ by **Alejandra Villa Posada**


