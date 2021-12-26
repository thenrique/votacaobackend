FROM openjdk:17-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} pauta-service.jar
ENTRYPOINT ["java","-jar","/pauta-service.jar"]