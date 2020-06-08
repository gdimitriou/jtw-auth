# jtw-auth
This is a Spring Boot microservice which implements JWT based authentication and authorization.

Steps to run the program:
1. Clone the code to your favorite IDE.
2. Run it.

Test the Program:
1. Hit: POST http://localhost:8080/authenticate
   Request Body: { "username": "foo", "password": "foo"}
2. You may take as response a json web token.
3. Hit: GET http://localhost:8080/hello
   Authorization Token: Bearer + generated jwt
   
Expected Output:
1. After POST hit, you may take as response a json web token.
2. After GET hit, the authorized user may take as response a simple "Hello World" and the unauthorized user "Forbidden"

swaggerUI can be found at: http://localhost:8080/swagger-ui.html