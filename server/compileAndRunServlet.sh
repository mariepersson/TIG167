#!/bin/bash

# Project in course TIG167: AfterWorkServlet.

# Compile everything in the project.
javac -cp ".;webroot/WEB-INF/lib/org.json.jar;./winstone.jar;webroot/WEB-INF/classes" webroot/WEB-INF/classes/servlets/AWServlet.java

# Run the servlet.
java -jar winstone.jar --webroot webroot
