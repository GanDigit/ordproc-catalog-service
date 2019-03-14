FROM java:8
WORKDIR /
ADD build/libs/catalogservice-0.0.1-SNAPSHOT.jar ord_catalog_service.jar
EXPOSE 8082
RUN sh -c 'touch /ord_catalog_service.jar'
ENTRYPOINT ["java","-jar","/ord_catalog_service.jar"]
