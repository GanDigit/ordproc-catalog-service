FROM java:8
WORKDIR /
ADD build/libs/catalogservice-0.0.1-SNAPSHOT.jar ordproc_catalog_service.jar
EXPOSE 80
RUN sh -c 'touch /ordproc_catalog_service.jar'
ENTRYPOINT ["java","-jar","/ordproc_catalog_service.jar"]
