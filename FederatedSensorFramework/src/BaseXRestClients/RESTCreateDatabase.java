package BaseXRestClients;
/**
 * RESTPut: It is used to add a document  the database using PUT http method. It is working fine
 * 
 */
import java.io.*;
import java.net.*;

import org.basex.*;

/**
 * This class is a simple example to demonstrate the REST implementation.
 * It shows the function of the HTTP PUT method.
 *
 */
public final class RESTCreateDatabase {
  /**
   * Runs the example.
   * @throws IOException I/O exception
   */
  static void run() throws IOException {
    System.out.println("=== PUT: create a new database ===");

    // The java URL connection to the resource
    URL url = new URL("http://localhost:8080/BaseX78/rest/sdqml");

    System.out.println("\n* URL: " + url);

    // Establish the connection to the URL
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    // Set an output connection
    conn.setDoOutput(true);
    // Set as PUT request
    conn.setRequestMethod("PUT");


    // Print the HTTP response code
    System.out.println("\n* HTTP response: " + conn.getResponseCode() +
        " (" + conn.getResponseMessage() + ')');

    // Close connection
    conn.disconnect();
  }

  /**
   * Main method.
   * @param args (ignored) command-line arguments
   * @throws Exception exception
   */
  public static void main(final String... args) throws Exception {
    // Start servers
    final BaseXHTTP http = new BaseXHTTP();
    // Run example
    run();
    // Stop servers
    http.stop();
  }
}