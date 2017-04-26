@echo off

java -jar checkstyle-7.6.1-all.jar -c /google_checks.xml ./ > chekstyle.txt
