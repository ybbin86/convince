FROM adoptopenjdk/openjdk11:latest

ENV	USE_PROFILE default

ARG JAR_FILE=build/libs/kurly-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} convince.jar

EXPOSE 8000

CMD ["java", "-Dspring.profiles.active=${USE_PROFILE}",  "-jar", "convince.jar"]