# restful-api-qnp
Project Assignment QNP

Requirement:
- JDK 17+
- Maven

How to Run:
1. mvn install
2. mvn spring-boot:run

HTTP Request Collection:
- Path: GET http://localhost:8000/contact
- Path: GET http://localhost:8000/contact/{id}
- Path:	POST http://localhost:8000/contact
  Body: {
         "name": "name",
		 "email": "email",
		 "phone": "phone",
		 "address": "address"
		}
- Path: PUT http://localhost:8000/contact
  Body: {
         "name": "name",
		 "email": "email",
		 "phone": "phone",
		 "address": "address"
		}
- Path: DELETE http://localhost:8000/contact/{id}
- Path: GET http://localhost:8000/users-posts

Progress: 
1. (done) Create restful Api with CRUD operation on one entity, Contact, that contains name, email, phone and address with h2/mysql/postgres using Spring Data JPA/JDBC or other ORM you're familiar with.
2. (done) Create an endpoint that fetch 2 data concurrently from https://jsonplaceholder.org, for example fetch Users data and Posts data. Calculated the total time it needs to completed the request.
3. (done) Add rate-limiter to those endpoint for example, that limit to 10 request in 60 seconds. The 11th request within 60 seconds window will return 429 status code and an error message. Use your own algorithm.
4. (not yet) Add JWT validation for those endpoints.