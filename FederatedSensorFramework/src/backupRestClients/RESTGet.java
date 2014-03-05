package backupRestClients;

import java.io.*;
import java.net.*;

import org.basex.*;

/**
 * This class is a simple example to demonstrate the REST implementation.
 * It shows the function of the HTTP GET method.
 *
 * @author BaseX Team 2005-12, BSD License
 */
public final class RESTGet {
  /**
   * Runs the example.
   * @throws IOException I/O exception
   */
  static void run() throws IOException {
    System.out.println("=== GET: execute a query ===");

    // The java URL connection to the resource
    String base = "http://localhost:8080/BaseX78/rest/";
    URL url = new URL(base + "sdqml/input1.xml");

    //URL url = new URL(base + "sdqml?query=/SDQML/SFDL/description/storage[//SDQML/SFDL/sensor/location/latitude>90.70 and //SDQML/SFDL/sensor/location/longitude>90.70 and //SDQML/SFDL/sensor/frequency>10]");
    System.out.println("\n* URL: " + url);

    // Establish the connection to the URL
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");

    // Print the HTTP response code
    int code = conn.getResponseCode();
    System.out.println("\n* HTTP response: " + code +
        " (" + conn.getResponseMessage() + ')');

    // Check if request was successful
    if(code == HttpURLConnection.HTTP_OK) {
      // Print the received result to standard output
      System.out.println("\n* Result:");

      // Get and cache input as UTF-8 encoded stream
      BufferedReader br = new BufferedReader(new InputStreamReader(
          conn.getInputStream(), "UTF-8"));

      // Print all lines of the result
      for(String line; (line = br.readLine()) != null;) {
        System.out.println(line);
      }
      br.close();
    }

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