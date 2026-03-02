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
2. Set Environment Variables

Set a secure JWT secret for production:

# Windows PowerShell
setx JWT_SECRET "YourSuperSecureJWTKey1234567890"

# macOS / Linux
export JWT_SECRET="YourSuperSecureJWTKey1234567890"

Note: application.properties uses a fallback key for local development:

jwt.secret=${JWT_SECRET:ThisIsOnlyForLocalDevelopmentKey123456789012}
3. Build & Run

Using Maven:

mvn clean install
mvn spring-boot:run

Spring Boot will start at:

http://localhost:8080
4. Test Endpoints with Postman
4.1 Register a User

POST http://localhost:8080/api/auth/register

Body (JSON):

{
  "username": "john",
  "password": "password123",
  "role": "ROLE_USER",
  "name": "John Doe",
  "age": 30
}
4.2 Login and Get JWT

POST http://localhost:8080/api/auth/login

Body (JSON):

{
  "username": "john",
  "password": "password123"
}

Copy the JWT from the response.

4.3 Access Protected Endpoint

GET http://localhost:8080/users

Headers:

Authorization: Bearer <your-jwt-token>
🔹 Security Notes

Never commit real secrets to GitHub.

Use environment variables for production secrets (JWT_SECRET).

BCrypt ensures passwords are securely hashed.

JWT expiration set to 1 hour (configurable).

🔹 Folder Structure
usermanagement/
├─ src/main/java/com/example/usermanagement/
│  ├─ controller/          # UserController
│  ├─ dto/                 # LoginRequestDTO, UserRequestDTO
│  ├─ entity/              # User entity
│  ├─ repository/          # UserRepository
│  ├─ security/            # JWT filter, config, utilities
│  └─ service/             # UserService
├─ src/main/resources/
│  └─ application.properties
├─ pom.xml
└─ .gitignore
🔹 Future Improvements

Add role-based access control (ADMIN vs USER endpoints)

Replace H2 with MySQL/PostgreSQL for production

Add refresh tokens for JWT

Add unit and integration tests

🔹 Author

Pruthvi M S – Spring Boot & Java Backend Developer
