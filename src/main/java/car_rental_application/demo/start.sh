#!/bin/bash

# Fail if anything goes wrong
set -e

# Clean and build the app, skipping tests
./mvnw clean package -DskipTests

# Run the built JAR
java -jar target/CarRental-0.0.1-SNAPSHOT.jar
