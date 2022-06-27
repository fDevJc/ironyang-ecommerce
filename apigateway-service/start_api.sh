#!/bin/sh
./gradlew clean && ./gradlew build && java -jar ./build/libs/apigateway-service-1.0.jar
