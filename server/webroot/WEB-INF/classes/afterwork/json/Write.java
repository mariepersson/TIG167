package afterwork.json;

import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.IOException;
import java.nio.file.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;

/**
 * A class that helps to giv back the json-informaiton to the user.
 */
public class Write {
  private final static String FILETYPE= ".json";
  private final static String CONTENTTYPE = "application/json; ";

  /**
   * Takes a json text and writes it to a file with the specified name.
   *
   * @param json the json text.
   * @param file the wanted name for the file.
   * @throws IOException if the file creation fails.
   */
  public static void jsonFile(String json, String file)
                              throws IOException {
    Path jsonFile = Paths.get(file + FILETYPE);
    Files.write(jsonFile, json.getBytes(UTF_8),
                StandardOpenOption.CREATE);
  }

  /**
   * Takes a json text and writes it to the servlets response.
   *
   * @param json the json text.
   * @param response the response the servlet should send back.
   * @throws IOException if the response can't be created.
   */
  public static void httpResponse(String json,
                                  HttpServletResponse response)
                                  throws IOException {
    response.setContentType(CONTENTTYPE + UTF_8.name());
    PrintWriter out = new PrintWriter(new OutputStreamWriter(
                      response.getOutputStream(), UTF_8), true);
    out.append(json);
    out.println();
    out.flush();
    out.close();
  }

}
