package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.nio.file.*;
import java.util.*;
import java.sql.*;
import org.json.*;

import afterwork.objects.Restaurant;
import afterwork.objects.AW;
import afterwork.db.ReadDBtoList;
import afterwork.json.Json;
import afterwork.json.Write;

public class AWServlet extends HttpServlet {

  @Override
  public void init() throws ServletException {
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
        String foodMessage = request.getParameter("food");
        String cityMessage = request.getParameter("city");

        List<Restaurant> listAW = ReadDBtoList.get(foodMessage, cityMessage);

        String jsonAW = Json.create(listAW);

        Write.httpResponse(jsonAW, response);

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

    } catch (IOException ioe) {
      System.err.println("Error writing file: " + ioe.getMessage());
      response.setStatus(HttpServletResponse
                        .SC_INTERNAL_SERVER_ERROR);
    }

  }

}
