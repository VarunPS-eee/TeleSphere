# Telesphere

Telesphere is a comprehensive application designed for managing user accounts and bank details. It includes features for user registration, bank detail management, and more, all while maintaining a clean and responsive UI.

## Table of Contents
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Prerequisites](#prerequisites)
- [Setup Instructions](#setup-instructions)
- [Database Structure](#database-structure)
- [Models](#models)
- [Controllers](#controllers)
- [Services](#services)
- [Repositories](#repositories)
- [Endpoints](#endpoints)
- [Usage](#usage)
- [Workflow](#workflow)
- [Testing the APIs](#testing-the-apis)
- [UI Images](#ui-images)
- [Directory Structure](#directory-structure)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [License](#license)

## Features
- User account management
- Bank detail validation and management
- Secure API endpoints for managing users and bank details
- Responsive front-end with multiple static pages

## Technology Stack
- **Backend**: Java, Spring Boot
- **Frontend**: HTML, CSS, JavaScript
- **Database**: MySQL
- **Build Tool**: Maven

## Prerequisites
- Java 11 or higher
- Maven 3.6 or higher
- MySQL 5.7 or higher

## Setup Instructions
1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/telesphere.git
    cd telesphere
    ```
2. Set up the MySQL database:
    ```sql
    CREATE DATABASE telesphere;
    ```
3. Configure the `application.properties` with your database credentials.
4. Build the project using Maven:
    ```bash
    mvn clean install
    ```
5. Run the application:
    ```bash
    mvn spring-boot:run
    ```

## Database Structure
### Tables
- **Users**
  - `id` (Primary Key)
  - `name`
  - `email`
  - `phoneNumber`
  - `password`

- **Bank Details**
  - `id` (Primary Key)
  - `cardNumber`
  - `cvv`
  - `pin`
  - `user_id` (Foreign Key)

## Models
- **User**: Represents the users in the application.
- **BankDetails**: Represents the bank details associated with each user.

## Controllers
- **UserController**: Handles all HTTP requests related to users.
- **BankDetailsController**: Manages the bank details-related requests.

## Services
- **UserService**: Business logic for user operations.
- **BankDetailsService**: Business logic for handling bank details.

## Repositories
- **UserRepository**: Interface for CRUD operations on the User entity.
- **BankDetailsRepository**: Interface for CRUD operations on the BankDetails entity.

## Endpoints
- **User Endpoints**:
  - `POST /api/users`: Create a new user.
  - `GET /api/users`: Retrieve all users.
  - `GET /api/users/{id}`: Retrieve a user by ID.
  - `PUT /api/users/{id}`: Update a user by ID.
  - `DELETE /api/users/{id}`: Delete a user by ID.

- **BankDetails Endpoints**:
  - `POST /api/bank-details`: Create new bank details.
  - `GET /api/bank-details`: Retrieve all bank details.
  - `GET /api/bank-details/{id}`: Retrieve bank details by ID.
  - `PUT /api/bank-details/{id}`: Update bank details by ID.
  - `DELETE /api/bank-details/{id}`: Delete bank details by ID.
  - `GET /api/bank-details/validate`: Validate bank details using card number, CVV, and PIN.

## Usage
This application can be used for managing user registrations and their associated bank details. The UI provides a smooth experience for handling these tasks.

## Workflow
1. User registration through the UI or API.
2. Bank details creation associated with a user.
3. Validation of bank details during transactions.

## Testing the APIs
Use tools like Postman or cURL to test the API endpoints. Ensure that the application is running and the database is set up correctly before testing.

## UI Images
- **Home Page**
  - ![Home](images/home.jpeg)

- **Customer Management UI**
  - ![Create Customer](images/customer/createCustomer.jpeg)
  - ![Get All Customers](images/customer/getAllCustomers.jpeg)
  - ![Get Customer By ID](images/customer/getCustomerById.jpeg)

- **Plan Management UI**
  - ![Create Plan](images/plan/createPlan.jpeg)
  - ![Delete Plan By ID](images/plan/deletePlanById.jpeg)
  - ![Get All Plans](images/plan/getAllPlans.jpeg)
  - ![Get Plan By ID](images/plan/getPlanById.jpeg)

## Directory Structure
```
src/
  main/
    java/com/telesphere/
      config/
      controller/
      model/
      repository/
      service/
      TelesphereApplication.java
    resources/
      static/
        images/
        about-us.html
        home.html
        index.html
        landing.html
        login.html
        payment-success.html
        payment.html
        plans.html
        services.html
      application.properties
```

## Troubleshooting
- Ensure your database credentials are correct in `application.properties`.
- Make sure the MySQL server is running.

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request for review.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
