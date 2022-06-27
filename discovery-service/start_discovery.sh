#!/bin/sh
./gradlew clean && ./gradlew build && java -jar ./build/libs/discovery-service-1.0.jar
