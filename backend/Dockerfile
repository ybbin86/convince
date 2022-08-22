FROM openjdk:11-jdk-alpine

ARG JAR_FILE=build/libs/kurly-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} convince.jar

EXPOSE 8000

CMD ["java",  "-jar", "convince.jar"]

