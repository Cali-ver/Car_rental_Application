# Car Rental Management System

A robust backend microservices-based Car Rental Management System built with Spring Boot. The application provides a complete REST API solution for managing car rentals, user bookings, and vehicle inventory with secure JWT authentication.

## 🚀 Features

- **User Authentication & Authorization**: Secure JWT-based login and role-based access control
- **Car Management**: Comprehensive CRUD operations for vehicle inventory
- **Booking System**: Complete rental booking workflow with status management
- **RESTful APIs**: 15+ well-documented endpoints for all operations
- **Microservices Architecture**: Decoupled services for better scalability and maintainability
- **Data Persistence**: Efficient database management with JPA/Hibernate

## 🛠️ Tech Stack

### Backend
- **Java 17** - Core programming language
- **Spring Boot** - Application framework
- **Spring Security** - Authentication and authorization
- **JPA/Hibernate** - ORM and database management
- **MySQL** - Primary database
- **JWT** - Token-based authentication
- **Maven** - Dependency management

### DevOps & Tools
- **Docker** - Containerization
- **Git** - Version control
- **Postman** - API testing
- **JUnit** - Unit testing

## 📋 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/auth/signin` | User authentication |
| GET | `/api/cars` | Get all available cars |
| POST | `/api/bookings` | Create new booking |
| GET | `/api/bookings/user/{userId}` | Get user bookings |
| PUT | `/api/bookings/{id}` | Update booking status |
| GET | `/api/users/profile` | Get user profile |

## 🗄️ Database Schema

Key Entities:
- **User** - User information and credentials
- **Car** - Vehicle details and availability status
- **Booking** - Rental transactions and booking history
- **Payment** - Payment records and transaction details

## 🔧 Installation & Setup

### Prerequisites
- Java 17
- MySQL 5.7+
- Maven 3.6+


# Build and run the application
mvn clean install
mvn spring-boot:run
