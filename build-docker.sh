#!/bin/bash

PUSH=${PUSH:-0}

REGISTRY=${REGISTRY:-npmemacr.azurecr.io}
TAG=`mvn help:evaluate -Dexpression=project.version -q -DforceStdout`
ARTIFACT=`mvn help:evaluate -Dexpression=project.artifactId -q -DforceStdout`
IMAGE_NAME=${REGISTRY}/${ARTIFACT}:${TAG}

echo "Start build for image ${IMAGE_NAME}"

docker build -t ${IMAGE_NAME} .

if [[ ${PUSH} -eq 1 ]]; then
    docker push "${IMAGE_NAME}"
fi