@echo off
cd /d "%~dp0"
if not exist out mkdir out
javac -encoding UTF-8 -d out src\SchoolNetworkingDemo.java
if errorlevel 1 (echo Compilation failed.& pause & exit /b 1)
java -cp out SchoolNetworkingDemo
pause
