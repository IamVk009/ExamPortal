# ExamPortal

**ExamPortal** is a microservices-based platform designed to facilitate online quizzes and examinations. It is built using Spring Boot and leverages service communication, load balancing, and scalable architecture for robust and modular exam management.

---

## Table of Contents

- [Project Structure](#project-structure)
- [Architecture Overview](#architecture-overview)
- [Microservices](#microservices)
  - [ApiGatewayService](#apigatewayservice)
  - [RegistryService](#registryservice)
  - [QuizService](#quizservice)
  - [QuestionService](#questionservice)
- [How It Works](#how-it-works)
- [Running the Application](#running-the-application)
- [Technologies Used](#technologies-used)

---

## Project Structure

```
ExamPortal/
│
├── ApiGatewayService/
├── RegistryService/
├── QuizService/
└── QuestionService/
```

Each directory is an independent Spring Boot microservice.

---

## Architecture Overview

- **Microservice-Based:** Each core domain—Quiz, Question, API Gateway, and Registry—has its own Spring Boot service.
- **Service Discovery & Load Balancing:** Uses service registry (Eureka) and Feign clients for scalable inter-service communication.
- **API Gateway:** Central entry-point, routes client requests to underlying services.
- **Decoupled Design:** Each service can be developed, deployed, and scaled independently.

---

## Microservices

### ApiGatewayService

- **Purpose:** Acts as the single entry point to the system, routing requests to appropriate microservices.
- **Tech:** Likely uses Spring Cloud Gateway.
- **Location:** [`/ApiGatewayService`](./ApiGatewayService/)

### RegistryService

- **Purpose:** Service discovery (Eureka Server). Registers all microservices for dynamic discovery and load balancing.
- **Location:** [`/RegistryService`](./RegistryService/)

### QuizService

- **Purpose:** Manages quizzes—creation, retrieval, and aggregation of quiz questions.
- **Endpoints:**
  - `POST /api/v1/quiz/add` – Add a new quiz
  - `GET /api/v1/quiz/all` – Retrieve all quizzes (with questions)
  - `GET /api/v1/quiz/{id}` – Retrieve quiz by ID (with questions)
- **Inter-Service Communication:** Uses FeignClient (`QuestionClient`) to fetch questions for quizzes from `QuestionService`.
- **Location:** [`/QuizService`](./QuizService/)

### QuestionService

- **Purpose:** Manages individual questions and supports associating questions with quizzes.
- **Endpoints:**
  - `POST /api/v1/questions/add` – Add a new question
  - `GET /api/v1/questions/all` – Retrieve all questions
  - `GET /api/v1/questions/{id}` – Retrieve question by ID
  - `GET /api/v1/questions/quiz/{quizId}` – Get questions for a specific quiz
- **Location:** [`/QuestionService`](./QuestionService/)

---

## How It Works

1. **User** interacts with the system via the API Gateway.
2. The **ApiGatewayService** forwards requests to the correct service.
3. The **QuizService** and **QuestionService** communicate via Feign clients, with Eureka handling service registry and load balancing.
4. Each service has its own data model and database (not shown here but recommended for microservices).

---

## Running the Application

> **Pre-requisites:** Java 17+, Gradle, (optional: Docker for DBs), and recommended: Spring Cloud tools.

1. **Start RegistryService** (Eureka server) first.
2. **Start ApiGatewayService, QuizService, and QuestionService** (order does not matter after registry is running).
3. Access APIs via the API Gateway port.

**Example:**
```bash
cd RegistryService && ./gradlew bootRun
cd ApiGatewayService && ./gradlew bootRun
cd QuizService && ./gradlew bootRun
cd QuestionService && ./gradlew bootRun
```

---

## Technologies Used

- **Java 17+ / Spring Boot**
- **Spring Cloud (Eureka, OpenFeign)**
- **Gradle** (per service)
- **REST APIs**
- **Lombok** (for boilerplate code)
- **JPA/Hibernate** (data access)
- (Optional: Docker, PostgreSQL/MySQL for databases)

---

## Contributors

- [IamVk009](https://github.com/IamVk009)

---

## Acknowledgements

- Spring Cloud documentation
- Community contributors

---
