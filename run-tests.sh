#!/bin/bash

TEST_RUN=${TEST_RUN:-""}
MAVEN_OPTS=${MAVEN_OPTS:-""}

__tags__=""

case ${TEST_RUN} in
    regressionBroadReach )
        __tags__="@regressionBroadReach"
    ;;
    regressionAnalytic )
        __tags__="@regressionAnalytic"
    ;;
    regressionPackage )
        __tags__="@regressionPackage"
    ;;
    all )
       __tags__="@regressionBroadReach, @regressionAnalytic, @regressionPackage"
    ;;
esac


if [[ -z ${__tags__} ]]; then
    echo "Define env variable TEST_RUN={regressionBroadReach|regressionAnalytic|regressionPackage|all} for run tests!"
    exit 1
fi

if [[ -z ${JAVA_TOOL_OPTIONS} ]]; then
    export JAVA_TOOL_OPTIONS="-XX:+UseSerialGC \
        -XX:+UnlockExperimentalVMOptions \
        -XX:+UseCGroupMemoryLimitForHeap \
        -XX:MinHeapFreeRatio=20 \
        -XX:MaxHeapFreeRatio=40 \
        -XX:AdaptiveSizePolicyWeight=90 \
        -XX:MaxRAMFraction=1"
fi
mvn test -Denv=stage -Dcucumber.options="--tags ${__tags__}" ${MAVEN_OPTS}
