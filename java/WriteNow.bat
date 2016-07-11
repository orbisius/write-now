@ECHO OFF
rem add the folder that contains the bat file to the class path
set CLASSPATH=%CLASSPATH%;%~dp0

rem http://stackoverflow.com/questions/8938944/how-to-run-java-application-by-bat-file
%JAVA_HOME%\bin\java -Xms128m -Xmx384m -Xnoclassgc WriteNow
