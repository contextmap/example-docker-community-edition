# Shopping Cart Service


"Binds": [
"/Users/psavat/dev/villaratio/repos/firstproject:/my-project:ro"
],


TODO describe how to configure this project in a jenkins docker

## Compile & Run
First run `mvn clean package` to build the jar.
Afterwards `cd src/main/resources/docker`, then `docker compose up`.

The docker compose exposes the default RabbitMQ and Postgres ports. If you have 
a local installation of this software make sure to stop it first. Otherwise
the docker compose will not be able to bind to the specific ports.

> Note: Possibly the first time docker compose is started it will fail, because 
> of slow initialization. This should be automatically fixed by restarting the 
> docker compose.

## Connect

##### REST

Basic authorization credentials are ...

##### RabbitMQ

Credentials are guest/guest

##### Postgres

Credentials are root/root
