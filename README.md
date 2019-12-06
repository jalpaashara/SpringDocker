# RESTful Web Service Implementation with Docker

This project is part of assignment at Pace University.

The project uses Maven build and is implemented using Spring Boot.

The web service contains four GET routes:
<ul>
  <li>One that displays a collection of records (List all Customers)</li>
  <li>One that displays a single record that corresponds to an ID (List a particular customer)</li>
  <li>One that displays a collection of records for a given entity (List of orders for individual customer)</li>
  <li>One that displays a single record from a collection of a given entity (List a particular order for individual customer)</li>
</ul>

## Source Data
I have used a static [JSON] (https://github.com/jalpaashara/SpringDocker/blob/master/src/main/resources/data.json) as source for data. 

## Get Requests available 
List all Customers: localhost:8080  
List a particular customer: localhost:8080localhost:8080/id  
List of orders for individual customer: localhost:8080/id/orders  
List a particular order for individual customer: localhost:8080/id/orders/orderId  

### Follow the below steps to create a local environment and run this Spring Boot Application
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
FROM openjdk:8-jdk-alpine  
VOLUME /tmp  
ARG DEPENDENCY=target/dependency  
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib  
COPY ${DEPENDENCY}/META-INF /app/META-INF  
COPY ${DEPENDENCY}/BOOT-INF/classes /app  
ENTRYPOINT ["java","-cp","app:app/lib/*","com.cust.order.SpringCustomerOrderApplication"]  
EXPOSE 8080

This Dockerfile has a DEPENDENCY parameter pointing to a directory.  
So from the terminal or command prompt type in the following:
#### `mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)`
This command will generate the following folders in the target/dependency folder:  
BOOT-INF/classes - with the application classes  
BOOT-INF/lib - with the dependency jars  
META-INF  

## Step 4:
Now we have all the setup we need to build the docker image. To build the image you can use the Docker command line. 
#### `docker build -t springproj/SpringDocker .`
-t -- tags the imagename "SpringDocker", you can optionally f=give a tag name after the imagename and a : (SpringDocker:v1.0).  
If you dont provide a tagname, docker by defuault assigns latest to the tagname.'  
Tagnames are useful when you have to version your build images.  
You can check the image built by typing the following on your terminal/cmd:  
#### `docker images`

## Step 5:
Now you can run the docker image that is built using the following docker run command:
#### `docker run -p 8080:8080 SpringDocker`
-p - publishes a container’s port(s) to the host
Now go to the browser and type localhost:8080 and it will show you a JSON with the list of customers and their orders.
To see the details of individual customer: localhost:8080/4123098 or localhost:8080/4123192 or localhost:8080/4123009
To see the details of orders for individual customer: localhost:8080/4123098/orders or localhost:8080/4123192/orders or localhost:8080/4123009/orders
To see the details of a particular order for individual customer: localhost:8080/4123098/orders/91873 or localhost:8080/4123192/orders/100987 or localhost:8080/4123009/orders/67124

## Step 6 (Optional)
Until now we have used docker locally to build and run in our local environment.  
Now we can push the docker image to docker hub and run it from anywhere.  
The command to push the docker image is:
#### `docker push springproj/SpringDocker`
Before you do this make sure you are logged in to Docker. to login to docker use the command below:
#### `docker login`
And it will authenticate you and login to your docker hub repositories.  
Once your image is on the docker hub, you can run it using the run command in Step 5 from anywhere.

## Other useful docker commands
#### `docker ps`
Lists all the docker container running

#### `docker stop my_container_id`
Stops the running container with id 'my_container_id'. You can get the containerId from docker ps.


