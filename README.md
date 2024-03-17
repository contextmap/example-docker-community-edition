# Example Docker Community Edition

## Introduction

This example project demonstrates how to get started with the ContextMap Community Edition docker image.

## How To's

### How to generate documentation for the first time

First check out this project, then from the root folder start the necessary docker images by executing: 
```shell
docker compose up
```

Next, you can manually run the command to trigger compile-time scanning of the shopping-cart-service, via:
```shell
cd shopping-cart-service
mvn clean compile contextmap:scan
```
(Alternatively, you can also enable a Jenkins container to scan the project whenever changes are made, 
to simulate how a real project would be configured. More details on this below.)

Finally, you can start the application locally, which will trigger runtime scanning, 
either via your IDE, or via command-line e.g.
```shell
mvn spring-boot:run
```

If you want to know more about how the ContextMap configuration was done, 
then have a look at this repository's git commit history.  
Also, there is a YouTube TODO

### How to navigate through the documentation for the first time

TODO

## Useful Links

When the docker containers have started and the shopping-cart-service is running then the following will be available.

- **ContextMap** will run on http://localhost:8080
- **Swagger** will run on http://localhost:8084/swagger-ui/index.html (use admin/admin when asked for username/password)
- **RabbitMQ** admin dashboard will run on http://localhost:15672 (use guest/guest when asked for username/password)
- **Jenkins** will run on http://localhost:8081 (but only if you have enabled this)

## About the docker images

TODO explain docker compose especially jenkins
