
#Java coding exercise

### RESTful API to manage  longest palindromic substring  operations.  Its functionality is:

-  Receives string input over an API
-  Stores the longest palindrome in provided database
-  Retrieves the stored palindrome over an API


###Technologies used:

*    Spring Boot (https://spring.io/projects/spring-boot)
* 	 Spring Security configuration
* 	 RESTful API with Swagger (i.e. https://springfox.github.io/springfox/)
* 	 H2 Database repo
* 	 Docker  
* 	 Maven 

### To run Automated Tests
* 	  mvn clean test 


### Start the app using maven

Run application 
* 	  mvn spring-boot:run




### Run the app in docker container by directly
Make sure Docker Hub is installed and its Daemon is exposed at port 2375 like below:
<img src="https://i.stack.imgur.com/QetGj.jpg">

Create docker image
* 	  mvn  clean package docker:build
Show all  docker images
```shell
λ docker images --all
REPOSITORY                   TAG       IMAGE ID       CREATED         SIZE
longest-palindrome           latest    fd24559eec8c   3 minutes ago   689MB

```
Run docker image
* 	  docker run -p 8080:8080 -t longest-palindrome
 
### Manually Test API using Swagger UI  
 After starting the application using either maven or docker, open following url in browser
* 	  http://localhost:8080/swagger-ui.html

Enter following credentials in login page:
*     admin/admin

Test the REST API of palindrome-rest-controller

### Manually check Database 
After starting the application using either maven or docker, open following url in browser
* 	  http://localhost:8080/h2

Enter following credentials in login page:
*     admin/admin

Connect to DB using following parameters:
- JDBC Url : jdbc:h2:~/test
-  H2 User name: sa
-  H2 password:

