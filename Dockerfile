# Choose base
FROM zenika/alpine-maven

# Install the pre-requisites
RUN apk update && apk add ca-certificates wget && update-ca-certificates

# Install Maven and set the env variables
RUN apk add vim
RUN mvn archetype:generate -B -D archetypeGroupId=net.alchim31.maven -D archetypeArtifactId=seleniumDemo -D archetypeVersion=1.7 -D groupId=com.myproject -D artifactId=seleniumDemo -D version=0.1-SNAPSHOT -D package=com.scalascrape
# Set the working directory
WORKDIR /usr/src/app/MyProject

# Copy your project to Docker
RUN rm pom.xml
COPY pom.xml .