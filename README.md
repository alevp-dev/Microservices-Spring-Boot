# Microservices Spring Boot
This project involves the development of a RESTful API for managing purchase orders using Java Spring Boot. The architecture is based on microservices, and relationships between entities are handled through JPA/Hibernate.
Each endpoint has been tested using Postman, and automated tests have been implemented using JUnit and Mockito to validate the functionality of the services for all the entities in the project.

Features
---------
Microservices-based architecture.
Management of purchase orders, customers, payments, products, notifications, order details, and inventory.
Entity relationships managed through JPA/Hibernate.
Automated tests using JUnit and Mockito.
API integration testing using Postman.
Technologies Used
Java Spring Boot: For backend implementation and microservices.
JPA/Hibernate: For data persistence and managing entity relationships.
Postman: For testing RESTful endpoints.
JUnit: For unit testing.
Mockito: For mocking dependencies in unit tests.

Tests
------
The project includes automated tests for the services of the following entities:

Customer: Creation, update, retrieval, and deletion of customers.
Payment: Processing and validation of payments.
Product: Inventory management and product availability.
Notifier: Notifications related to orders and customers.
Order: Creation, update, and deletion of orders.
OrderDetail: Management of order details.
Inventory: Maintenance and tracking of inventory levels.
Each service has been tested using mocked repositories with Mockito, and expected responses and behaviors were validated using JUnit.

Instructions to Run the Tests
-----------------------------
Clone the repository.
Ensure that JUnit and Mockito are set up in your project.
Run the tests from your IDE or via Maven:
mvn test

