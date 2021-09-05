### Recipe App

##### Build & Run


    $ ./gradlew clean
    $ docker-compose build --no-cache

After successful build, ensure that no application runs in port 27017,8080 and no port forwarding from your machine's 80 port.

    $ docker-compose up -d

You can access the endpoints after checking all services up and running
    
    $ docker ps


##### Api Documentation 

You can access to the api documentation by navigating to [localhost:8080/swagger-ui.html](localhost:8080/swagger-ui.html). You can also find postman collection in the documents.

##### Api Credentials

    username: username
    password: password



