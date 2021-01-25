FROM openjdk:8
ADD target/wmbd-backend-main-1.jar docker-wmbd-backend-main.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","docker-wmbd-backend-main.jar"]