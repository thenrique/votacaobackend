FROM openjdk:17-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} contabilizacao-service.jar
ENTRYPOINT ["java","-jar","/contabilizacao-service.jar"]