FROM maven:3.6.3-jdk-8-slim

RUN mkdir -p /project/src
COPY ./settings.xml /usr/share/maven/conf
COPY ./pom.xml /project
COPY ./src /project/src
COPY ./run-tests /project

WORKDIR /project
ENV JAVA_TOOL_OPTIONS \
    -Djava.security.egd=file:/dev/./urandom \
    -XX:+UseSerialGC \
    -XX:+UnlockExperimentalVMOptions \
    -XX:+UseCGroupMemoryLimitForHeap \
    -XX:MinHeapFreeRatio=20 \
    -XX:MaxHeapFreeRatio=40 \
    -XX:AdaptiveSizePolicyWeight=90 \
    -XX:MaxRAMFraction=1

RUN mvn dependency:go-offline
RUN mvn package -DskipTests=true

ENTRYPOINT /project/run-tests