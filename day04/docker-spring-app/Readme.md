## Simple calculator app

### Build application

    mvn clean install

### Run Application
    mvn spring-boot:run

### Create docker image

    mvn install dockerfile:build

### Run docker image

    docker run -p 8080:8080 falcon007/docker-spring-app:1.0.0


### List the docker active containers
    docker ps

### List all docker containers (active and inactive container)
    docker ps -a

### Stop active running container
    docker stop <containerid> ex: e471a90e5266

### Remove the containers
    docker rm <container-id> ex: e471a90e5266

### List all docker images
    docker images

### Remove docker images
    docker rmi <imageaid>