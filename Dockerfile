FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
COPY ./target/APIEquipos-0.0.1-SNAPSHOT.jar appPruebaTecnica.jar
ENTRYPOINT ["java","-jar","/appPruebaTecnica.jar"]