# Online Store - Spring Boot Application

## Project Overview
This project is a part of coursework for **COSC 304 - Introduction to Database Systems** taught by Dr. Ramon Lawrence. It implements a basic online store using Spring Boot framework with SQL Server database integration.

## Description
The Online Store application demonstrates the implementation of database concepts in a real-world e-commerce scenario. The application provides functionality to view products and order details, showcasing the integration between a web application and a relational database system.

## Technical Stack
- **Framework**: Spring Boot
- **Database**: Microsoft SQL Server
- **Template Engine**: Thymeleaf
- **Build Tool**: Maven
- **Database Access**: Spring Data JPA
- **Container**: Docker (for SQL Server database)

## Key Features
- View all available products in the store
- Display comprehensive order history
- Database integration using Spring Data JPA
- MVC architecture implementation
- Docker containerization for database

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
│   │           │   └── OrderProduct.java
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
- **Container Name**: cosc304_sqlserver

## Setup Requirements
1. Java 17 or higher
2. Docker Desktop
3. Maven
4. IDE (recommended: IntelliJ IDEA)

## Running the Application
1. Start the SQL Server Docker container
2. Build the project using Maven
3. Run the Spring Boot application
4. Access the application at `http://localhost:8081/shop`

---
*Note: This project is for educational purposes as part of COSC 304 coursework at UBC Okanagan.*
