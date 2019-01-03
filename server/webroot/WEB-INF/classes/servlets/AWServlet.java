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

/**
 * Controles tne request to the servlet and creates a sutable response.
 */
public class AWServlet extends HttpServlet {

  /**
   * Initiate the servlet.
   *
   * @throws ServletException if the servlet doesn't work.
   */
  @Override
  public void init() throws ServletException {
    try {
      Class.forName("org.sqlite.JDBC");
    } catch(ClassNotFoundException cnfe) {
      System.err.println("Could not find the SQLite JDBC driver: " +
                         cnfe.getMessage());
    }
  }

  /**
   * Takes the parameters from the http request and uses them to get specific
   * information about Rsstaurants holding After Work from the database. With
   * the information it creates a json text that it sends as a http response. 
   *
   * @param request contains information about the parameters sent to the servlet.
   * @param response controles the response the servlet will send.
   */
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
