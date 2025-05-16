# Microservices with Spring Boot  

This project is a **RESTful API** for managing **purchase orders** using **Java Spring Boot**. It follows a **microservices-based architecture**, leveraging **JPA/Hibernate** for entity relationships and **JUnit/Mockito** for automated testing.  

Each endpoint has been tested using **Postman**, ensuring reliability and correctness across all entities.  

# Project Structure
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

# Features  
✔️ Microservices-based architecture.  
✔️ Management of **purchase orders, customers, payments, products, notifications, order details, and inventory**.  
✔️ Entity relationships handled with **JPA/Hibernate**.  
✔️ Automated testing using **JUnit and Mockito**.  
✔️ API integration testing with **Postman**.  
✔️ API documentation with **Swagger**.  

# Technologies Used  
🔹 **Java Spring Boot** – Backend implementation and microservices.  
🔹 **JPA/Hibernate** – Data persistence and entity relationship management.  
🔹 **Postman** – API testing.  
🔹 **JUnit** – Unit testing.  
🔹 **Mockito** – Mocking dependencies in unit tests.  
🔹 **Lombok**.
🔹 **MySQL**.
🔹 **Spring Boot 3.2.2**.
🔹 **Spring Data JPA**.
🔹 **Spring Web MVC**.
🔹 **Springdoc OpenAPI 3.0**.

# Tests  
The project includes automated tests covering the following entities:  

- **Customer**: Creation, update, retrieval, and deletion.  
- **Payment**: Processing and validation.  
- **Product**: Inventory management and availability checks.  
- **Notifier**: Notifications for orders and customers.  
- **Order**: Creation, update, and deletion.  
- **OrderDetail**: Management of order details.  
- **Inventory**: Maintenance and tracking of stock levels.  

Each service is tested using **mocked repositories** with **Mockito**, ensuring expected responses and behaviors through **JUnit** assertions.  

# Running the Tests  
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

# Contributions
Contributions, issues, and feature requests are welcome! Feel free to fork this repository and submit a pull request.

---
Developed with ❤️ by **Alejandra Villa Posada**


