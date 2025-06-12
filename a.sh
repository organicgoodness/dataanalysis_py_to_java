#!/bin/bash
################
# コマンド
# chmod +x a.sh
# ./a.sh
# を先に実行？


mvn compile
mvn exec:java -Dexec.mainClass="otameshi.sparkjava.SparkJava"

javac -cp .:json-20250517.jar otameshi/sparkjava/SparkJava.java
java -cp .:json-20250517.jar otameshi/sparkjava/SparkJava

# SparkJava.javaでPOSTリクエストも事項できるように（GETリクエストだけでなく）
# curl -X POST http://localhost:4567/run-java