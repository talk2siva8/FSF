package BaseXRestClients;
/**
 * RESTPut: It is used to add a document  the database using PUT http method. It is working fine
 * 
 */
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.basex.BaseXHTTP;

import com.thesis.utilities.XMLValidator;

/**
 * This class is a simple example to demonstrate the REST implementation.
 * It shows the function of the HTTP PUT method.
 *
 */
public class RESTCreateDocument {
  /**
   * Runs the example.
   * @throws IOException I/O exception
   */
	private static String xml=null;
	private static String name=null;

  public Boolean run()  {
try
{
    // The java URL connection to the resource
    URL url = new URL("http://localhost:8080/BaseX78/rest/sdqml/"+getName()+".xml");

    //System.out.println("\n* URL: " + url);

    // Establish the connection to the URL
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    // Set an output connection
    conn.setDoOutput(true);
    // Set as PUT request
    conn.setRequestMethod("PUT");

    // Get and cache output stream
    OutputStream out = new BufferedOutputStream(conn.getOutputStream());
    // Create and cache input stream
    
	// convert String into InputStream
	InputStream in = new ByteArrayInputStream(getXml().getBytes());
    
    // Send document to server
    //System.out.println("\n* Send document...");
    for(int i; (i = in.read()) != -1;) out.write(i);
    in.close();
    out.close();

    // Print the HTTP response code
    //System.out.println("\n* HTTP response: " + conn.getResponseCode() +
     //   " (" + conn.getResponseMessage() + ')');

    // Close connection
    conn.disconnect();
}
catch(MalformedURLException e)
{
	e.printStackTrace();
    return false;
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
    return false;

}
    return true;
  }

 
/**
 * @return the xml
 */
public static String getXml() {
	return xml;
}

/**
 * @param xml the xml to set
 */
public void setXml(String xml) {
	this.xml = xml;
}

/**
 * @return the name
 */
public static String getName() {
	return name;
}

/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
//convert InputStream to String
	public static String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}

	 /**
	   * Main method.
	   * @param args (ignored) command-line arguments
	   * @throws Exception exception
	   */
	  public static void main(final String... args) throws Exception {
	    // Start servers
	    final BaseXHTTP http = new BaseXHTTP();
	    RESTCreateDocument rd= new RESTCreateDocument();
	    rd.setName("input10");
		
	    String xmlPath="/home/gogineni/src/sdqmldummy1.xml";
		InputStream in = new FileInputStream(xmlPath);
		InputStream in1= new FileInputStream(xmlPath);
		String xsdPath="/home/gogineni/src/sdqml.xsd";
		Boolean isValidated=XMLValidator.validateXMLSchema(xsdPath,in1);
		System.out.println("Validated:"+isValidated);
			
	    rd.setXml(rd.getStringFromInputStream(in));
	    in.close();
	    // Run example
	    if(isValidated)
	    rd.run();
	    // Stop servers
	    http.stop();
	  }

	
}