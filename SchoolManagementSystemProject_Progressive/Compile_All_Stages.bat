@echo off
setlocal
for /d %%D in (Stage*) do (
  echo.
  echo ===== %%D =====
  pushd "%%D"
  if not exist out mkdir out
  if "%%D"=="Stage30_REST_API" (
    for %%F in (src\*.java) do javac --add-modules jdk.httpserver -encoding UTF-8 -d out "%%F"
  ) else (
    for %%F in (src\*.java) do javac -encoding UTF-8 -d out "%%F"
  )
  if errorlevel 1 echo Compile issue in %%D
  popd
)
echo.
echo Stage compilation pass finished. Database connection for Stage24 requires a JDBC driver and database.
pause
