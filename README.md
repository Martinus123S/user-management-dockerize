# Userman Service

Spring Boot REST API for user account management, JWT authentication, transaction history with pagination, and transaction reporting.

---

## Prerequisites

You need Java 17 or newer, Maven 3.6 or newer, and a PostgreSQL database. Optionally, you can use Docker for containerization.

---

## Setup

First, clone the repository with:

```bash
git clone https://github.com/Martinus123S/user-management-dockerize.git
cd <your-repo-folder>

```

Create a PostgreSQL database and user, for example:
```
CREATE DATABASE userman_db;
CREATE USER userman_user WITH PASSWORD 'your_password';
GRANT ALL PRIVILEGES ON DATABASE userman_db TO userman_user;
```

Then update the src/main/resources/application.properties file with your database credentials:
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/userman_db
spring.datasource.username=userman_user
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

```

Generate a secure JWT secret key (at least 64 bytes base64-encoded) using:
```
openssl rand -base64 64
```

Add this secret to your application.properties as:
```
jwt.secret=your_base64_encoded_secret_here
```

Build your maven
```angular2html
mvn clean install
mvn springboot:run
```