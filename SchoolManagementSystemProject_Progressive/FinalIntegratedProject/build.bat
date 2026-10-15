@echo off
setlocal
if not exist out mkdir out
javac --add-modules jdk.httpserver -encoding UTF-8 -d out -sourcepath src src\SchoolManagementSystemProject.java
if errorlevel 1 (
  echo.
  echo BUILD FAILED. Read the compiler errors above and check that JDK 17+ is installed.
  exit /b 1
)
echo.
echo BUILD SUCCESSFUL.
endlocal
