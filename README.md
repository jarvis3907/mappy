# homework
Mappy Homework
## Content

To start with, we provide as part of this repository:

Please start the service in the below order

```
.
├── eureka
    Default Port: 8761
    To start use: mvn spring-boot:run
├── auth
    Default Port: 9180
    To start use: mvn spring-boot:run
└── gateway
    Default Port: 9080
    To start use: mvn spring-boot:run
└── fizzbuzz Service
    Default Port: 8080
    To start use: mvn spring-boot:run


```

### FizzBuzz Service

- To run the project please use the following command **mvn spring-boot:run** the application will be started in port 8080
- The app is integrated to gateway kindly access it via http://localhost:9080/api/compute by providing the access token in the header. You can use the collections under the postman folder
  which is ready to use

#### Api Documentation :
- Once you start the application the  swagger UI can be found in the below mentioned path
  http://localhost:8080/api/swagger-ui.html.

#### Testing 

- Unit testing 
- Integration testing 
- BDD


#### API Testing

- Import the `Mappy.postman_collection.json` and `Mappy.postman_environment.json` which is under postman folder of the project in postman
- Obtain access token and proceed with creating customer and loan applications. Access token in valid for 60 minutes and generate a new one once it is expired.