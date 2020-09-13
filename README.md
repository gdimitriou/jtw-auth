# jtw-auth
This is a Spring Boot microservice which implements JWT based authentication and authorization.

Steps to run the program:
1. Clone the code to your favorite IDE.
2. Run it.

Instructions to run the Program:
1. Hit POST http://localhost:8080/register

   Request Body : {
                    "bio": "string",
                    "city": "string",
                    "email": "string",
                    "firstName": "string",
                    "lastName": "string",
                    "occupation": "string",
                    "password": "string",
                    "userName": "string"
                    "email": "string",
                    "firstName": "string",
                    "lastName": "string",
                    "occupation": "string",
                    "password": "string",
                    "userName": "string"
                  }        
   This request will create a new user in the Database.               
2. Hit: POST http://localhost:8080/authenticate

   Request Body: { "username": "foo", "password": "foo"}
   This Request will generate a json web token for the user.
3. Hit: GET http://localhost:8080/hello
   Authorization Token: Bearer + generated jwt
4. You are authenticated!
   
Expected Output:
1. After POST hit, you may take as response a json web token.
2. After GET hit, the authorized userDAO may take as response SUCCESS or FORBIDDEN

SwaggerUI can be found at: http://localhost:8080/swagger-ui.html