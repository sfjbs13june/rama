# Build

    mvn clean install

# Run
    mvn spring-boot:run

## Post

curl --location --request POST 'localhost:8083/save/patient' \
--header 'Authorization: Basic YWRtaW4wMTpwYXNzd29yZA==' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=DB12BFCE5EAFB42D78DA3D60CD678B03' \
--data-raw '{"id": "id1","name": "pat01","hospital": "hospital01","disease":"disease01"}'

## Get 

curl --location --request GET 'localhost:8083/get/patient?name=pat01' \
--header 'Authorization: Basic ZG9jdG9yMDI6cGFzc3dvcmQ=' \
--header 'Cookie: JSESSIONID=DB12BFCE5EAFB42D78DA3D60CD678B03'


## Create docker image

```bash
$ mvn install dockerfile:build
```

### Push docker images

```bash
docker login
$ docker push <repository-name>/springsecurity
```

## Running

The application can be start is either locally using maven or start in docker container.

### Running the application in local environment
Using eclipse:It can be run as java application or run configuration to provide the program arguments.
You can run using maven command as:

```bash
$ mvn spring-boot:run
```

### Running the application in docker container

```bash
$ docker run -p 8083:8083 falcon007/hospital-application:1.0.0 
$ docker-compose  pull
$ docker-compose  up
```

## Looking docker image

docker exec -it c555dfd07277 bash



#Show data::

docker exec -it third-mongo-spring-data_mongo_1 bash

mongo

show dbs

use test_db

show tables

db.customer.find()

# swagger 

http://localhost:8083/swagger-ui.html