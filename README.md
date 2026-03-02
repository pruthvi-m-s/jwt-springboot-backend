# JWT Spring Boot Backend

A **fully functional Spring Boot backend** demonstrating JWT authentication, user registration, login, and protected endpoints. This project is perfect for showcasing professional backend skills.

---

## 🔹 Features

- **User Registration** (`/api/auth/register`)  
- **User Login** (`/api/auth/login`) → returns JWT token  
- **Protected `/users` endpoint** → only accessible with valid JWT  
- **Password encryption** using BCrypt  
- **JWT authentication and validation**  
- **Exception handling** for validation and authentication errors  
- Fully **environment variable–friendly** for secrets (`JWT_SECRET`)  
- In-memory H2 database for local testing  

---

## 🔹 Tech Stack

- Java 17+  
- Spring Boot 3+  
- Spring Security  
- JWT (JSON Web Tokens)  
- H2 Database (default)  
- Maven  

---

## 🔹 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/pruthvi-m-s/jwt-springboot-backend.git
cd jwt-springboot-backend
