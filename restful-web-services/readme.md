# Todo and Hello World Rest APIs with My SQL

### Purpose

This app is an exercise in building a REST API with Java 17/Spring Boot 3 and connecting it to a React front end
The code for the front end can be found [here](https://github.com/ilyaflaks/java-todo-app-frontend)

The whole app back end is hosted on AWS EC2 and the front end is on AWS S3. Feel free to explore the front end [here](http://todoapp-ilyaflaks.s3-website-us-west-1.amazonaws.com/todos). If the link is not working, that means AWS started charging me more money than I'm willing to pay and I deleted the backend.

### Running on local machine

To run the backend of this app

- Install Eclipse, Postman and Docker Containers if you don't already have it
- From the command line run the following command to launch the MySQL database:
  **docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=todos-user --env MYSQL_PASSWORD=dummytodos --env MYSQL_DATABASE=todos --name mysql --publish 3306:3306 mysql:8-oracle**
  If you get an error, you probably have some other process on port 3306. Kill it and try again.

- In Eclipe, go to the top of the screen where it says File -> Import -> Existing Maven Projects -> Browse to where you cloned the repo to -> Click Finish
- Open **RestfulWebServicesApplication.java** file of the java-todo-app, right click on the code, select Run As -> 1 Java Application
  It should sayd "Application runing on port 5000" on the Eclipse console
- Feel free to execute a few HTTP requests from Postman or TalendAPI, such as

**GET** to http://localhost:5000/

Should return "Success!"

**POST** to http://localhost:5000/authenticate

```json
{
  "username": "in28minutes",
  "password": "dummy"
}
```

You should get a JWT back

**GET** to http://localhost:5000/users/in28minutes/todos

Make sure to add an "Authorization" header the body of which should be "Bearer <JWT you got back earlier>"

# Sources

This project is a part of [Master Spring Boot 3 & Spring Framework 6 with Java](https://www.udemy.com/course/spring-boot-and-spring-framework-tutorial-for-beginners) from **in28minutes**. All the credit goes to the in28minutes team.
