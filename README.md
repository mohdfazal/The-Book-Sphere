# TheBookSphere - Library Management System

TheBookSphere is a Library Management System built using **Spring Boot** with **JPA & Hibernate** for database management.  
It allows you to manage **Authors, Books, Students, Cards, and Transactions** in a structured way.

---

## Features
- Add, update, delete, and fetch **Authors**
- Add, update, delete, and fetch **Students**
- Add and fetch **Books**
- Link multiple **Books** to a single **Author**
- Fetch all **Books** written by a particular Author
- Get the number of Books written by an Author

---

## Tech Stack
- **Java 17+**
- **Spring Boot**
- **Spring Data JPA (Hibernate)**
- **MySQL** (or any relational DB)
- **Maven**

---

## API Endpoints

### Authors (`/author`)
- `POST /author/add` → Add a new Author  
- `DELETE /author/delete?id={id}` → Delete an Author by ID  
- `PUT /author/update?id={id}` → Update Author info by ID  
- `GET /author/get?id={id}` → Get an Author by ID  
- `GET /author/getAll` → Get all Authors  

### Books (`/book`)
- `POST /book/add` → Add a new Book  
- `GET /book/getAll` → Get all Books  
- `GET /book/getBookListOfAnAuthorById?id={authorId}` → Get all Books by an Author  
- `GET /book/getNoOfBookWrittenByAnAuthorById?id={authorId}` → Get number of Books written by an Author  

### Students (`/student`)
- `POST /student/add` → Add a new Student  
- `DELETE /student/delete?id={id}` → Delete a Student by ID  
- `PUT /student/update?id={id}` → Update Student info by ID  
- `GET /student/get?id={id}` → Get a Student by ID  
- `GET /student/getAll` → Get all Students  

---

## Example Data (for DB seeding)

### Author
```json
{
  "name": "George R. R. Martin",
  "age": 75,
  "email": "grrm@example.com"
}
Student
{
  "name": "Alice Johnson",
  "age": 22,
  "email": "alice@example.com"
}

Book
{
  "title": "A Game of Thrones",
  "genre": "FANTASY",
  "noOfPages": 694,
  "price": 499,
  "author": {
    "id": 1
  }
}

Setup Instructions

Clone the repository:

git clone https://github.com/your-username/TheBookSphere.git
cd TheBookSphere


Configure your MySQL database in application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/thebooksphere
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update


Run the application:

mvn spring-boot:run


Open in browser or API client (e.g. Postman):

http://localhost:8080/book/getAll

Future Enhancements

Student registration and library card system

Issue/Return book transactions

Fine calculation for late returns

Role-based authentication (Admin, Student)

Contributing

Contributions are welcome! Please fork this repo, make changes, and create a pull request.

License

This project is open-source and available under the MIT License.
