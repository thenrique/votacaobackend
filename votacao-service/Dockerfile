FROM openjdk:17-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} votacao-service.jar
ENTRYPOINT ["java","-jar","/votacao-service.jar"]