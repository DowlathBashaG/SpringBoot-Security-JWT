# Spring Security using JWT (Json Web Token) in Spring Boot

## Spring Security Architecture

![spring security arch diagram](https://user-images.githubusercontent.com/9671419/87207889-a905e500-c32a-11ea-9c81-cc39e39188bd.JPG)
 
 
This Project uses JWT to secure the REST endpoints.

- The Following are the REST end points available in the example.

- /token - Generates the JWT token based on the JSON sent. Its a POST method which expects the JSON: { "username": "name", "id": 123, "role": "admin"}

![pM_post_1](https://user-images.githubusercontent.com/9671419/87172628-26f9ca00-c2f2-11ea-93dc-7422974b1f6e.PNG)

![pM_post_2](https://user-images.githubusercontent.com/9671419/87172622-25c89d00-c2f2-11ea-993d-53648963ea11.PNG)

- /rest/hello - Requires a JWT Token with Header key - "Authorisation" and value - "Token <JWT_Token>"

![postMan_1](https://user-images.githubusercontent.com/9671419/87172626-26f9ca00-c2f2-11ea-981e-128c0436056d.PNG)
