FROM openjdk:8
ADD src/main/resources/apis/airports-assembly-1.1.2.jar airports-assembly-1.1.2.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "airports-assembly-1.1.2.jar"]