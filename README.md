# Student Management System (STMS)

A robust backend for managing student records, course enrollments, and academic grading, built with Spring Boot and Java 21+.

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
