SCHOOL MANAGEMENT SYSTEM - EDITABLE JAVA PROJECT
================================================

Project entry point: SchoolManagementSystemProject.java
Java target: JDK 17 or newer (uses the built-in HTTP server module).
Editor: Notepad++ is fine. No IDE is required.

IMPORTANT ABOUT EDITING
- This is a normal multi-file Java project. Every .java file is editable in Notepad++.
- Keep each file in its existing folder because its package declaration must match the folder.
- Do not paste every class into one file. Java package classes are intentionally separated and named for their responsibilities.
- The project builds with the included build.bat on Windows, or with the commands below.

BUILD AND RUN (Windows Command Prompt)
1. Extract the entire ZIP folder.
2. Install a JDK 17+ and ensure `java -version` and `javac -version` work in Command Prompt.
3. Open the extracted SchoolManagementSystemProject folder.
4. Run: build.bat
5. Run: run.bat

MANUAL COMMANDS
  javac --add-modules jdk.httpserver -d out -sourcepath src src/SchoolManagementSystemProject.java
  java --add-modules jdk.httpserver -cp out SchoolManagementSystemProject

HOW TO USE
- Choose options from the console menu.
- Register students, list/search students, record scores and payments, and save records.
- Records are stored in the `data` folder as text files.
- The GUI option opens a basic Swing window.
- The REST option starts a local HTTP server on port 8080; open /students in a browser.
- The network demo starts a small socket server/client demonstration.
- The project includes a SQL schema, a test runner, and documentation notes.

PROGRESSIVE STAGES
The assignment lists 34 stages. `docs/StageMapping.txt` maps concepts to the relevant files.
This project uses separate classes from the start so the design remains editable and understandable.
Some deployment-level items (production authentication, real database credentials, email notifications,
and a production-ready REST deployment) require environment-specific configuration and are identified
in the documentation rather than being falsely presented as production-ready.

DATABASE
The application works with text files by default so it runs without installing a database.
`sql/schema.sql` contains a relational schema for the JDBC/database stage.
A JDBC driver and a running database are required before connecting to an actual DB.

TROUBLESHOOTING
- If `javac` is not recognized, install a JDK and add its `bin` folder to PATH.
- If a class is not found, build from the project root using build.bat.
- Do not remove `package` lines or move files without updating imports.
