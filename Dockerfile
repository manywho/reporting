FROM jeanblanchard/java:8

EXPOSE 8080

CMD ["java", "-jar", "reporting-1.0-SNAPSHOT.jar"]

WORKDIR /app

ADD . ./
