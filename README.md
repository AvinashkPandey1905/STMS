# Student Management System (STMS)

A robust backend for managing student records, course enrollments, and academic grading, built with Spring Boot and Java 21+.

## 📖 About the Project

The **Student Management System (STMS)** is a professional-grade academic administration tool designed for high scalability and zero-dependency compatibility. It simplifies the complex relationships between students, courses, and academic performance.

### 🌟 Key Philosophy
- **Compatibility First**: Unlike standard Spring Boot apps, STMS uses **manual Boilerplate (Builders/DTOs)** instead of Lombok. This ensures the project runs flawlessly on any Java 21+ or Java 25 environment without IDE plugin dependencies.
- **Relational Integrity**: The system uses JPA to enforce strict academic rules—preventing double enrollments and ensuring grades are only assigned to active student records.
- **Architecture**: Built on the **Controller-Service-Repository** pattern, it provides a "Clean Code" foundation that is ready to be paired with a modern frontend (React/Next.js/Angular).

## 🚀 Features

- **Student Management**: Full CRUD operations for student profiles.
- **Course Catalog**: Manage academic subjects with unique codes and credits.
- **Smart Enrollment**: Link students to courses with double-enrollment prevention.
- **Grading System**: Track student performance with automated validation.
- **RESTful API**: Clean JSON endpoints for front-end integration.

## 🛠️ Technology Stack

- **Java 21/25**
- **Spring Boot 3.4.3**
- **Spring Data JPA**
- **H2 / MySQL** (H2 for local testing, MySQL for production)
- **Maven**

## 🏁 Getting Started

### Prerequisites

- JDK 21 or higher
- Maven 3.8+

### Running Locally

1. Clone the repository:
   ```bash
   git clone https://github.com/YOUR_USERNAME/STMS.git
   cd STMS
   ```

2. Run with H2 In-Memory Database (Test Mode):
   ```bash
   mvn spring-boot:run -Dspring-boot.run.profiles=h2
   ```

3. Access the H2 Console:
   - URL: `http://localhost:9090/h2-console`
   - JDBC URL: `jdbc:h2:mem:stms_db`
   - Credentials: `sa` / (empty password)

### API Reference

| Endpoint | Method | Description |
| :--- | :--- | :--- |
| `/api/students` | `GET`, `POST` | Manage student registry |
| `/api/courses` | `GET`, `POST` | Manage course catalog |
| `/api/enrollments` | `POST` | Process enrollments |
| `/api/grades` | `POST` | Log academic performance |

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
