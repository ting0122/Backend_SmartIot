
#尚未完成

# First Stage
FROM openjdk:17-jdk-alpine AS build

WORKDIR /app

COPY . .

RUN ./gradlew clean bootJar

# Second Stage
FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT [ "java","-jar","app.jar" ]


# first time
# docker build -t sp_smartiot .

# every time
# docker run -it -p 8080:8080 --rm --name test-container sp_smartiot

