# URL Shortener Project

This project is a URL shortener application developed using Spring Boot. It provides functionality to shorten long URLs and redirect users to the original URLs. This README file provides an overview of the project structure, setup instructions, and basic usage.

## Project Overview

The URL Shortener application allows users to shorten long URLs into a unique alias. When users access the shortened URL, they are redirected to the original URL. URLs can also have an expiry date set, after which they are no longer accessible.

## Setup Instructions

### Prerequisites

- JDK 17 or higher
- Maven
- PostgreSQL

### Database Configuration

1. Install PostgreSQL and create a database for the application.
2. Update the `application.properties` file with your PostgreSQL database configuration:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/yourdbname
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
   spring.jpa.hibernate.ddl-auto=update
