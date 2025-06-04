@echo off
javac -cp .:json-20250517.jar java/MainApp.java java/PythonRunner.java java/ResultLoader.java
java -cp .:json-20250517.jar java/MainApp
pause
