# Use maven:3.8.4-openjdk-17-slim as build environment
FROM maven:3.8.4-openjdk-17-slim as build
WORKDIR /app
# Copy pom.xml and source code to the container
COPY ./pom.xml ./pom.xml
COPY ./src ./src
# Run the tests
RUN mvn -Dtest=LoginTest test -X
# Package the application
RUN mvn package -DskipTests -X

# Use openjdk:17-jdk-slim for the runtime environment
FROM openjdk:17-jdk-slim
WORKDIR /app
# Copy the JAR file from the build stage
COPY --from=build /app/target/test-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
