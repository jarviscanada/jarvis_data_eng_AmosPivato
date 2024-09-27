# Introduction
The Grep App is a tool that allows for the user to find string data that can be matched by a pattern within files throughout a given directory.  This app is designed and implemented in Java which is a Platform independent language and therefore allows this app to be used by anyone at anytime, given that a JDK is installed.  Having multiple implementations was a key feature so the app is designed and set up using a Java interface to allow for easy class implementation and api integration based on the application needs.  
Other tools used in the design are; maven for project library and application management using project object management, Docker was used to create an image of the application that is available on Docker Hub for easy distribution, using lambda functions along with the Java 8 stream libraries was used to reimplement the app wwithout using for loops, slf4j was used for logging output of the app for testing and debugging, Junit used for unit testing

# Quick Start
Commands to run the Grep app:
- Using .jar file:
```
#if you don't have jar file run the mavan command to build the app from POM
mvn clean compile package

#using for loop implementation
java -cp target/grep-1.0-SNAPSHOT.jar ca.jrvs.apps.grep.JavaGrepImp regex_patter source_dir output_dir_file

#using lambda stream api implementation
java -cp target/grep-1.0-SNAPSHOT.jar ca.jrvs.apps.grep.JavaGrepLambdaImp regex_patter source_dir output_dir_file

```
- Using Docker image:
```
#make sure you have the apivato/grep docker image pulled from docker hub
docker pull apivato21/grep

#to run docker image in container and run application within and output to log dir
docker run --rm -v `pwd`/data:/data -v `pwd`/log:/log ${docker_user}/grep .*Romeo.*Juliet.* /data /log/grep.out

```
- Can also be run and built in any IDE that supports Maven

# Implemenation
## Pseudocode
The following is the design for how the process of the grep app is implemented in both the lambda stream version and the for loop version o the app:
```
matchedLines = []
for file in listFilesRecursively(rootDir)
  for line in readLines(file)
      if containsPattern(line)
        matchedLines.add(line)
writeToFile(matchedLines)
```

## Performance Issue
There were memory issues when running the for loop implementation of the app as searching through verry large amounts of data would result in the OutOfMemory exception.This was due to the JVM's heapspace becoming too full and the GC overhead limit being surpased as the BufferedReader being used would have be processing amounts of data larger than the heap's size.

To solve this issue, I decided to reimplement the app using Java 8 Stream Api's to reduce the amount of overhead that would be required when reading from files.  Using Java Stream's allows for the data to be computed on demand and not stored in memory.  This way we can produce a pipeline of data that operates on the source of its data structure (collection and array) and implement internal iterations to be applied on the data itself.

# Test
Manual Testing was conducted as follows both in command line and intellij:
- Tested how the for loop implementation handled user misinput to make sure errors were handled properly.
- Tested app output on various regex patterns and directories to make sure it traversed properly and located every matching string within the files found.
- Tested memory usage to see if app would run with smaller heapspace and thus leading to the lambda stream api implementation.
- Junittested Lambda Stream api to make sure that the implementation was done correctly and proper datatypes were being returned by the helper functions. 
- finally tested the application using Docker image to make sure uberjar and docker image were working correctly.

# Deployment
The app was dockerized by having a Dockerfile created to then create a docker images, this image was designed to contain the grep uberjar:
```
#dockerfile code to create image containing 
FROM openjdk:8-alpine
COPY target/grep*.jar /usr/local/app/grep/lib/grep.jar
ENTRYPOINT ["java","-jar","/usr/local/app/grep/lib/grep.jar"]
```

Once the image was built from the Dockerfile, the image was pushed to DockerHub for easy distribution.  
can be viewed at https://hub.docker.com/repository/docker/apivato21/grep
can be pulled using docker pull apivato21/grep

# Improvement
A few things I would like to improve for this project:
- Add more application error handling to make sure the app runs fine if inputed with faulty arguments
- Implement a string pattern vs regex string option as its is defaulted to regex
- I would also like to have it be implemented as a class function, with out using commandline arguments, to be used in other applications if needed
