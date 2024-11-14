# Online Store Spring Boot Application

## Project Description
This is a Spring Boot web application that implements a basic online store system. The application provides functionality to view products and order information from a SQL Server database. It follows the MVC (Model-View-Controller) architecture pattern and demonstrates core features of Spring Boot including database integration, JPA entity relationships, and Thymeleaf templating.

## Key Features
- View all products in the store
- Display comprehensive order history including:
  - Order details (ID, date, total amount)
  - Customer information
  - Products ordered with quantities and prices

## Technical Stack
- **Framework**: Spring Boot
- **Database**: Microsoft SQL Server
- **ORM**: Spring Data JPA/Hibernate
- **Template Engine**: Thymeleaf
- **Build Tool**: Maven
- **Database Container**: Docker

## Project Structure
```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── store/
│   │           ├── OnlineStoreApplication.java
│   │           ├── model/                    
│   │           │   ├── Product.java          
│   │           │   ├── OrderSummary.java
│   │           │   ├── Customer.java
│   │           │   ├── OrderProduct.java
│   │           │   └── OrderProductPK.java
│   │           ├── controller/               
│   │           │   ├── ShopController.java    
│   │           │   └── OrderController.java   
│   │           └── repository/               
│   │               └── OrderSummaryRepository.java
│   └── resources/
│       ├── templates/
│       │   ├── shop.html
│       │   └── listOrders.html
│       └── application.properties
```

## Database Configuration
- **Database Name**: orders
- **Schema**: dbo
- **Port**: 1433
- **Running in**: Docker container (cosc304_sqlserver)

## Prerequisites
- Java 17 or higher
- Docker Desktop
- Maven
- SQL Server instance running in Docker

## Setup and Installation
1. Clone the repository
2. Ensure Docker is running with the SQL Server container
3. Update application.properties with your database credentials if different
4. Run `mvn clean install` to build the project
5. Start the application using `mvn spring-boot:run`
6. Access the application at `http://localhost:8081/shop`

## Entity Relationships
- OrderSummary ↔ Customer (Many-to-One)
- OrderSummary ↔ OrderProduct (One-to-Many)
- OrderProduct ↔ Product (Many-to-One)

This project serves as a practical demonstration of building a database-driven web application using Spring Boot, focusing on core functionality rather than frontend aesthetics.

---
License

            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
                    Version 2, December 2004

 Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>

 Everyone is permitted to copy and distribute verbatim or modified
 copies of this license document, and changing it is allowed as long
 as the name is changed.

            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION

  0. You just DO WHAT THE FUCK YOU WANT TO.
