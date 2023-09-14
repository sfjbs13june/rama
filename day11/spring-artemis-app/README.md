## Build
    mvn clean install
## Run
    docker-compose -f docker-compose-artemis.yml up -d

## Show data::

    http://localhost:8161/

## Start producer

     artemis-demo-producer> mvn spring-boot:run

## Send some message though producer

    curl -X GET http://localhost:1230/send?msg=test

## Start consumer
    artemis-demo-consumer> mvn spring-boot:run

## Stop Container

    docker-compose -f docker-compose-artemis.yml down




