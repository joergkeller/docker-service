# Docker-Service
Simple docker service to integrate docker with gradle build scripts.
There are 3 different options to run a demo service:
1. A stand-alone jar containing all dependencies and a webserver
2. A docker image using the micro profile
3. A docker image using the same micro profile but with hot deployment of the code

## The REST resource
See in the module `rest-app` the java class HelloResource. It contains JAX-RS annotations
to 'GET /rest/hello', delivering a simple text string.

## Build a war
The module `rest-app` can create a war file:
> gradlew war

The war can be deployed to any java web container, e.g. Tomcat, Jetty, Glassfish etc.

## Build a stand-alone jar
The module `jetty-app` can create a fat-jar consisting of a jetty webserver and the `rest-app`:
> gradlew shadowJar\
> java -jar jetty-app/build/libs/jetty-app-1.0-all.jar\
> http://localhost:8080/rest/hello

## Dockerized java micro profile
Building the war file above automatically copied the result into `docker/jee-micro`. 
The Dockerfile allows to build and run a microservice containing the Payara micro image and the war:
> docker build -t jee-micro .\
> docker run -p 8080:8080 jee-micro\
> http://localhost:8080/rest/hello

## Dockerized java micro profile for development
To build/run a docker container after each development step is a hassle. For development it would be
much nicer to have a running server and hot-deploy all the changes.

Currently not every incremental build by the IDE will be deployed, but each creation of the war (see above)
will also create an 'exploded' target and hot-deploy that target in a specialized docker instance `jee-micro-dev`.
> gradlew war

Initial creation of the war file and explode it for deploment as a docker-volume.

> docker build -t jee-micro-dev .\
> docker run -it -p 8080:8080 -v /hello-service/rest-app/build/exploded:/opt/payara/deployments/hello jee-micro-dev\
> http://localhost:8080/rest/hello

> gradlew war

etc.