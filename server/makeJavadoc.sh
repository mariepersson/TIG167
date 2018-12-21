#!/bin/bash


# A script that will create javadoc for the project.

# The folders with the files that should be documented.
PACKAGES="
  webroot/WEB-INF/classes/servlets/*.java
  webroot/WEB-INF/classes/afterwork/db/*.java
  webroot/WEB-INF/classes/afterwork/json/*.java
  webroot/WEB-INF/classes/afterwork/objects/*.java"

# Creating documentation and saving it in a folder called doc.
javadoc -d doc  $PACKAGES
