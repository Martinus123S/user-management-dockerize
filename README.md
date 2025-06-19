# Userman Service

Spring Boot REST API for user account management, JWT authentication, transaction history with pagination, and transaction reporting.

---

## Prerequisites

You need Java 21 or newer, Maven 3.6 or newer, and a PostgreSQL database. Optionally, you can use Docker for containerization.

---

## Setup

First, clone the repository with:

```bash
git clone https://github.com/Martinus123S/user-management-dockerize.git
cd <your-repo-folder>

```

Build your maven
```angular2html
mvn clean install
docker compose up (if you use docker) or podman compose up (if you use podman)
Open in your chrome
http://localhost:8080/swagger-ui/index.html
```