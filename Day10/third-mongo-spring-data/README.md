# Build
```
mvn clean install

```

# Run
```
docker-compose -f docker-compose-mongo.yml up -d
mvn spring-boot:run
docker-compose -f docker-compose-mongo.yml down
```
### Docker containarization:

```
$ mvn install dockerfile:build
```

### Push docker images

```
docker login
$ docker push falcon007/third-mongo-spring-data:1.0.0
```

### Running the application in docker container

```
$ docker run -p 8083:8083 falcon007/third-mongo-spring-data:1.0.0
$ docker-compose  pull
$ docker-compose  up
```
# training
## Post

```
curl -X POST http://localhost:8083/customer/create -H 'content-type: application/json' -d '{"name": "Rama","custId": "1re206","address": "Bangalore"}'
```
## Get 
```
curl -X GET http://localhost:8083/customer/read 
```
## Put
```
curl -X PUT http://localhost:8083/customer/update?custId=1re07&name=Rama 
```
## Delete
```
curl -X DELETE http://localhost:8083/customer/delete?name=Rama
```

## Show data::
```
docker exec -it third-mongo-spring-data_mongo_1 bash

mongo

show dbs

use test_db

show tables

db.customer.find()
```
# swagger 
```
http://localhost:8083/swagger-ui.html
```