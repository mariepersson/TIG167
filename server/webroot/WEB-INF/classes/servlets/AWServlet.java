package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.sql.*;
import java.util.*;
import org.json.*;
import java.nio.file.*;
import afterwork.objects.Restaurant;
import afterwork.objects.AW;
import afterwork.db.ReadDBtoAW;
import afterwork.db.ReadDBtoRestaurant;
import afterwork.json.Json;
import afterwork.json.Write;

public class AWServlet extends HttpServlet {

  @Override
  public void init() throws ServletException { //initierar koppling till sql i lib-mappen, från var?
    try {
      Class.forName("org.sqlite.JDBC");
    } catch(ClassNotFoundException cnfe) {
      System.err.println("Could not find the SQLite JDBC driver: " +
                         cnfe.getMessage());
    }
  }

  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response) {

    try (PrintWriter out = new PrintWriter(new OutputStreamWriter(
                      response.getOutputStream(), UTF_8), true);) {

      try {
        List<AW> listAW = ReadDBtoAW.get();
        List<Restaurant> listRestaurants = ReadDBtoRestaurant.get();

        String json = Json.create(listAW, listRestaurants);

        Write.jsonFile(json, "jsonAfterWork");
        Write.httpResponse(json, response);

        /* (rikard)
            String id = request.getParameter("id");
            String action =request.getParameter("action");
            System.out.println("id: " + id);
            System.out.println("action: " + action);
          */

          /* (övning)
          String format = request.getParameter("format");
          if(format!=null && format.equals("json")){
            response.setContentType("application/json");
          }
          */

      } catch (JSONException jsone) {
        System.err.println("JSON error: " + jsone.getMessage());
        response.setStatus(HttpServletResponse
                          .SC_INTERNAL_SERVER_ERROR);
        response.setContentType("text/html; " + UTF_8.name());
        out.println("<em style=\"color: red;\">JSON error: " +
                    jsone.getMessage() + "</em>");

      } catch (IOException ioe) {
        System.err.println("Error writing file: " + ioe.getMessage());
        response.setStatus(HttpServletResponse
                          .SC_INTERNAL_SERVER_ERROR);
        response.setContentType("text/html; " + UTF_8.name());
        out.println("<em style=\"color: red;\">Error writing file: " +
                    ioe.getMessage() + "</em>");

      } catch (SQLException sqle) {
        System.err.println("Database error: " + sqle.getMessage());
        response.setStatus(HttpServletResponse
                          .SC_INTERNAL_SERVER_ERROR);
        response.setContentType("text/html; " + UTF_8.name());
        out.println("<em style=\"color: red;\">Database error: " +
                    sqle.getMessage() + "</em>");
      }

    } catch (IOException ioe){
      System.err.println("Error writing file: " + ioe.getMessage());
      response.setStatus(HttpServletResponse
                        .SC_INTERNAL_SERVER_ERROR);
      // kan inte ha out här, kan man skriva respons på annat sätt?
    }

  }

}
