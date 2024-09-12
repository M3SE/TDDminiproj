## TDD Mini Project

This project is a simple Spring Boot application demonstrating Test-Driven Development (TDD) practices. It includes basic CRUD operations for an `Order` entity with validation and exception handling.

### Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher

### Setup

1. **Clone the repository:**


2. **Build the project:**
   ```sh
   mvn clean install
   ```

### Running the Application

1. **Run the application:**
   ```sh
   mvn spring-boot:run
   ```

2. **Access the H2 Console:**
    - URL: `http://localhost:8080/h2-console`
    - JDBC URL: `jdbc:h2:mem:testdb`
    - Username: `sa`
    - Password: (leave blank)

### Running Tests

1. **Run all tests:**
   ```sh
   mvn test
   ```

### Project Structure

- `src/main/java/com/example/tddminiproj/`: Main application code
- `src/test/java/com/example/tddminiproj/`: Test cases
- `src/main/resources/application.properties`: Application configuration

### Key Classes

- **Order**: Entity class representing an order.
- **OrderController**: REST controller for handling order-related requests.
- **OrderService**: Service class for business logic.
- **OrderRepository**: Repository interface for data access.
- **OrderNotFoundException**: Custom exception for handling order not found scenarios.

### Validations

- `customerName` must not be empty.
- `shippingAddress` must not be empty.
- `total` must be positive.

### Exception Handling

- **OrderNotFoundException**: Thrown when trying to update or delete a non-existent order.

### Example Endpoints

- **Create Order**: `POST /api/orders`
- **Get All Orders**: `GET /api/orders`
- **Get Order by ID**: `GET /api/orders/{id}`
- **Update Order**: `PUT /api/orders/{id}`
- **Delete Order**: `DELETE /api/orders/{id}`