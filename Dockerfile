FROM openjdk:17
ARG JAR_PATH=./build/libs
COPY ${JAR_PATH}/be-0.0.1-SNAPSHOT.jar application.jar
ENTRYPOINT ["java", "-jar"]
CMD ["/application.jar"]
