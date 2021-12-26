FROM openjdk:17-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} abrirsessao-service.jar
ENTRYPOINT ["java","-jar","/abrirsessao-service.jar"]