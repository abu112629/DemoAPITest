FROM maven:3.6.3-jdk-8-slim

RUN mkdir -p /project/src
COPY ./settings.xml /usr/share/maven/conf
COPY ./pom.xml /project
COPY ./src /project/src
COPY ./run-tests.sh /project

WORKDIR /project

RUN mvn dependency:go-offline
RUN mvn package -DskipTests=true

ENTRYPOINT /project/run-tests.sh