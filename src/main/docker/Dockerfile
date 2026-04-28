FROM eclipse-temurin:17-jre-alpine
LABEL authors="renz.ayala"

COPY ./bankingMsProducts-0.0.1-SNAPSHOT.jar ./ms-products.jar
EXPOSE 11102

ENTRYPOINT ["java", "-Duser.timezone=America/Lima", "-jar", "ms-products.jar"]

## .\gradlew clean build -x test --no-daemon
## cp .\build\libs\bankingMsProducts-0.0.1-SNAPSHOT.jar  .\src\main\docker\
## cd .\src\main\docker\
## docker container stop ms-products
## docker build . -t bank/ms-products:latest
## docker run -d --rm --name ms-products --env-file .env -p 11102:11102 bank/ms-products:latest