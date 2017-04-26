@echo off

set JDEPEND_HOME=C:\jdepend-2.9.1\
set CLASSPATH=%CLASSPATH%;%JDEPEND_HOME%\lib\jdepend-2.9.1.jar

java jdepend.textui.JDepend ./ > jdepend.txt