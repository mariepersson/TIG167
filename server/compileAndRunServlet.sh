# Compile
javac -cp ".;webroot/WEB-INF/lib/org.json.jar;./winstone.jar;webroot/WEB-INF/classes" webroot/WEB-INF/classes/servlets/AWServlet.java

# Run
java -jar winstone.jar --webroot webroot
