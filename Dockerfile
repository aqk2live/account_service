FROM openjdk:17-alpine
WORKDIR /app
COPY target/account_service-0.0.1-SNAPSHOT.jar /app/account_service-0.0.1.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","account_service-0.0.1.jar"]