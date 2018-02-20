FROM java:8-jdk

RUN mkdir /app
WORKDIR /app
ADD target/tnt-ms-orders-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "java", "-Xmx128m", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar", "--spring.profiles.active=structural,docker"]
EXPOSE 8080

