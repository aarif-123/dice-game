@echo off
echo Compiling and running the latest code...

REM Check if system Java is available
where javac >nul 2>nul
if %ERRORLEVEL% EQU 0 (
    echo Using system Java for compilation and running...
    set USE_SYSTEM_JAVA=true
) else (
    echo System Java compiler not found. Checking for JAVA_HOME...
    if defined JAVA_HOME (
        echo Using JAVA_HOME for compilation and running...
        set USE_SYSTEM_JAVA=true
    ) else (
        echo WARNING: No Java compiler found. Will run the existing JAR file.
        set USE_SYSTEM_JAVA=false
    )
)

REM Do NOT set local JRE path; rely on system Java
REM set LOCAL_JAVA_HOME=%~dp0jre\OpenJDKJRE
REM set PATH=%LOCAL_JAVA_HOME%\bin;%PATH%

if "%USE_SYSTEM_JAVA%"=="true" (
    REM Create bin directory if it doesn't exist
    if not exist bin mkdir bin

    REM Compile the Java source files
    echo Compiling Java files...
    javac -d bin src\com\example\dicegame\*.java

    REM Check if compilation was successful
    if %ERRORLEVEL% NEQ 0 (
        echo Compilation failed! Please fix the errors and try again.
        pause
        exit /b 1
    )

    REM Create a new JAR file with the compiled classes
    echo Creating JAR file...
    cd bin
    jar cfm ..\DiceGameApp.jar ..\MANIFEST.MF com\example\dicegame\*.class
    cd ..
    
    echo Compilation and JAR creation successful!
)

REM Run the application using system Java
echo Running the application...
java -jar DiceGameApp.jar

pause
