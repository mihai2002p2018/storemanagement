# Store Management API

A backend REST API for managing a store’s products and users, built with Java 17, Spring Boot 3, Maven, and PostgreSQL.  
This project is backend-only (no front-end), role-based authentication, error handling, and testability.

---

## Features

- Add, update, and view products
- Bulk insert products
- Change product price
- Find products by ID
- Basic Authentication (HTTP Basic Auth)
- Role-based access (ADMIN/USER)
- Standard error handling (JSON)
- Logging for key actions
- Unit tests with Mockito

---

## Technologies Used

- Java 17
- Spring Boot 3.5.x
- Spring Data JPA
- Spring Security
- PostgreSQL
- Maven

---

## Check/modify the application.properties file

---

## API Endpoints (Summary)
Method	Endpoint	           Role Required   Description
GET	/api/products	           USER, ADMIN	   List all products
GET	/api/products/{id}	   USER, ADMIN	   Get product details by ID
POST	/api/products	           ADMIN       	   Add a product
POST	/api/products/bulk	   ADMIN	   Bulk add products
PATCH	/api/products/{id}/price   ADMIN	   Change product price