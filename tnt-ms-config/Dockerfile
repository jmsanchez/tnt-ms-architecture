FROM java:8
RUN mkdir /app
WORKDIR /app
ADD target/tnt-ms-config-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar", "--spring.profiles.active=native"]
EXPOSE 8888
