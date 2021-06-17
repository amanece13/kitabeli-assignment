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

#API Details

GET APIs
Fetch active deals - http://localhost:8080/active/deals
Fetch expired deals - http://localhost:8080/expired/deals
Manually refresh deals - http://localhost:8080/refresh/deals
Fetch all product - http://localhost:8080/products
Fetch product by id - http://localhost:8080/product/{id}



POST APIs
Add product - 
http://localhost:8080/product

sample json
    
    {
		"name": "Reebok Men Shoe",
		"description": "Reebok Sneakers",
		"category_id": 10,
		"inventory_id": 10,
		"price": 20100.0,
		"created_at": 1623912171
    } 

Add multiple products - 
http://localhost:8080/products

sample json

    [
    	
    	{
    		"name": "Horlicks",
    		"description": "Grocery",
    		"category_id": 9,
    		"inventory_id": 9,
    		"price": 2000.0,
    		"created_at": 1623912171
    	},
    	{
    		"name": "Baby soap Men Shoe",
    		"description": "Baby Products",
    		"category_id": 12,
    		"inventory_id": 12,
    		"price": 2000.0,
    		"created_at": 1623912171
    	},
    	{
    		"name": "Puma Men's Wear",
    		"description": "puma men t-shirt",
    		"category_id":11,
    		"inventory_id": 11,
    		"price": 2000.0,
    		"created_at": 1623912171
    	},
    	{
    		"name": "Reebok Men Shoe",
    		"description": "Reebok Sneakers",
    		"category_id": 10,
    		"inventory_id": 10,
    		"price": 20100.0,
    		"created_at": 1623912171
    	}
    ]
	
