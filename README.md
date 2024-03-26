# Example Docker Community Edition

## Introduction

This example project demonstrates how to get started with the ContextMap Community Edition docker image.  

The main techstack in this example consists of:
- Java
- Spring Boot
- Maven

Furthermore, ContextMap will also document the following technologies used in this project:
- RabbitMQ
- Postgres
- Git
- Spring JPA / Cloud / Web

Also some other information will be documented like feature files, architectural decision records, 
exemplary code, glossary, ...

## How To's

### How to generate documentation for the first time

First check out this project, then from the root folder start the necessary docker images by executing: 
```shell
docker compose up
```

Next, you can manually run the command to trigger compile-time scanning of the shopping-cart-service, via:
```shell
cd shopping-cart-service
./mvnw clean compile contextmap:scan
```
(Alternatively, you can also enable a Jenkins container to scan the project whenever changes are made, 
to simulate how a real project would be configured. More details on this below.)

Finally, you can start the application locally, which will trigger runtime scanning, 
either via your IDE, or via command-line e.g.
```shell
./mvnw spring-boot:run
```

If you want to know more about how the ContextMap configuration was done, 
then have a look at this repository's git commit history.  
Also, there is a YouTube video demonstrating how to configure ContextMap,
starting from the undocumented shopping-cart-service.

### How to navigate through the documentation for the first time

Once the code is scanned and documented, you can navigate to the ContextMap frontend (see link below).
At this point all what's left is for you to decide how to best present the information that was gathered.  
This is done using so-called 'explanatory models' (based on Domain Driven Design). 
Each explanatory model is meant to explain one specific aspect. This way you can focus on either the high level architecture,
component level interactions, domains, storages, eventing or a combination.

## Useful Links

When the docker containers have started and the shopping-cart-service is running then the following will be available.

- **ContextMap** will run on http://localhost:8080
- **Swagger** will run on http://localhost:8084/swagger-ui/index.html (use admin/admin when asked for username/password)
- **RabbitMQ** admin dashboard will run on http://localhost:15672 (use guest/guest when asked for username/password)

## About the docker images

### ContextMap Community Edition
One port is exposed for the backend (8000). This port is used during scanning to send the information to.
A second port is exposed for the frontend (8080). This is used to navigate to the portal.  
An environment variable `BACKEND_URL` is needed to tell the frontend where the backend is running.  
That data which is gathered is stored in a database under a `./tmp` folder.

### RabbitMQ Management
The shopping-cart-service publishes a message to a RabbitMQ-exchange upon checkout of a shopping cart.
This message and its payload will be documented in ContextMap. 
You can navigate to the RabbitMQ admin dashboard to inspect whether messages are arriving correctly (see useful links)

### Postgres
The shopping-cart-service uses postgres (in combination with Flyway and Spring JPA) to store the shopping cart and its items.
The storage and the tables and relations will be documented in ContextMap.
