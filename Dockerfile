FROM eclipse-temurin:17
COPY target/Revenue-0.0.1-SNAPSHOT.jar rev.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","rev.jar"]