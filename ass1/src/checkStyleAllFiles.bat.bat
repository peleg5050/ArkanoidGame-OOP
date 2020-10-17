@ECHO OFF 
ECHO Please wait... Checking style for all java files
java -jar "C:\Program Files\Java\checkstyle-5.7-all.jar" -c "C:\Program Files\Java\biuoop.xml" *.java
PAUSE