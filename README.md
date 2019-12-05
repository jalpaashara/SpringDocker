# RESTful Web Service Implementation with Docker

This project is part of assignment at Pace University.

The project uses Maven build and is implemented using Spring Boot.

To run this application follow the steps below.


Alternatively you can follow the below steps to create a local environment and upload it to your docker hub as a tutorial for spring boot with Docker
## Step 1:
[Download](https://github.com/jalpaashara/SpringDocker/archive/master.zip) and unzip the source repository or clone it using Git:
#### `git clone https://github.com/jalpaashara/SpringDocker.git`

## Step 2:
Go to terminal or command prompt and change the directory to where you have cloned or downloaded the project. 
Type in the following:
#### `./mvnw package`
This command is used to execute all Maven phases until the package phase. It does the job of compiling, verifying and building the project.
It builds the jar file and places it in the target directory under the root project folder.

## Step 3:
Containerize the project:
Docker has a simple "Dockerfile" file format that it uses to specify the layers of an image. 
Dockerfile is included in this project and below is how I have created the Dockerfile:
`FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.cust.order.SpringCustomerOrderApplication"]
EXPOSE 8080`

This Dockerfile has a DEPENDENCY parameter pointing to a di
docker build -t springio/gs-spring-boot-docker .rectory where we have unpacked the fat jar. 
So from the terminal or command prompt type in the following:
#### `mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)`
This command will generate the following folders in the target/dependency folder
BOOT-INF/classes - with the application classes
BOOT-INF/lib - with the dependency jars
META-INF

## Step 4:
Now we have all the setup we need to build the docker image. To build the image you can use the Docker command line. 
docker build -t springproj/SpringDocker .
-t -- tags the imagename "SpringDocker", you can optionally f=give a tag name after the imagename and a : (SpringDocker:v1.0). 
If you dont provide a tagname, docker by defuault assigns latest to the tagname.' 
Tagnames are useful when you have to version your build images.
You can check the image built by typing the following on your terminal/cmd:
#### `docker images`

##Step 5:
Now you can run the docker image that is built using the following docker run command:
#### `docker run -p 8080:8080 SpringDocker`
Now go to the browser and type localhost:8080 and it will show you a JSON with the list of customers and their orders.
To see details of individual customer: localhost:8080/id 
In this case I just have 3 customers which you can check with localhost:8080/4123098 or localhost:8080/4123192 or localhost:8080/4123009








