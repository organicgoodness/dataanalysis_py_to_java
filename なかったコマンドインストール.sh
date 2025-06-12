#!/bin/bash
brew install maven
mvn compile
mvn exec:java -Dexec.mainClass="otameshi.sparkjava.SparkJava"

javac -cp .:json-20250517.jar otameshi/sparkjava/SparkJava.java
java -cp .:json-20250517.jar otameshi/sparkjava/SparkJava
