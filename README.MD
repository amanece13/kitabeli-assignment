#Solution Insight
* This is a Spring Boot application with a data store used as H2.
* We have changed the storage to file storage.
* Exception handling has been added for normal flow of the application.
* Extra functionalities for fetching all products or products with ids have been given.
* We have attached the database diagram

#Prerequisite to run
* Java >= 1.8
* Maven >= 3.6

#How to run
* Compile the application and run it.
* Sample datasets have been provided along with the application to intialize the database.
* Open the url http://localhost:8080/h2 on your browser.
* Upon opening the above url please use jdbc:h2:mem:dealsdb;DB_CLOSE_DELAY=-1 in the textarea of JDBC URL
  and press Connect
* Navigate to /app and run run command npm i and then npm start
