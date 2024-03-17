# Example Docker Community Edition

## Introduction

This example project demonstrates how to get started with the community edition docker image.

## How to use this project

First start the necessary docker images by executing 
```shell
docker compose up
```

Next, you can manually run the command to trigger compile-time scanning of the shopping-cart-service, via
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

## Useful 

- **ContextMap** will run on http://localhost:8080
- **Swagger** is available when the shopping-cart-service is running via http://localhost:8084/swagger-ui/index.html. Use admin/admin when asked for username/password.
- **RabbitMQ** admin dashboard will run on http://localhost:15672. Use guest/guest when asked for username/password.


TODO explain docker compose
