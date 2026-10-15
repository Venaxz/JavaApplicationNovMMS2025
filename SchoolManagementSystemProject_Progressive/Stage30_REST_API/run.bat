@echo off
cd /d "%~dp0"
if not exist out mkdir out
javac --add-modules jdk.httpserver -encoding UTF-8 -d out src\SchoolRestApiDemo.java
if errorlevel 1 (echo Compilation failed.& pause & exit /b 1)
java --add-modules jdk.httpserver -cp out SchoolRestApiDemo
pause
