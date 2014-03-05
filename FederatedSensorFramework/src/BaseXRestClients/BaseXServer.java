package BaseXRestClients;

import org.basex.BaseXHTTP;
/**
 * 
 * @author gogineni
 *
 */
public class BaseXServer {
	private static BaseXHTTP http=null;

	/**
	 * @return the http
	 * @throws Exception 
	 */
	public static BaseXHTTP getHttp() throws Exception {
		if(http==null)
		{
			http= new BaseXHTTP();
		}
		return http;
	}

	/**
	 * @param http the http to set
	 */
	public static void setHttp(BaseXHTTP http1) {
		http = http1;
	}
	
	/**
	 * @param http the http to set
	 * @throws Exception 
	 */
	public static void stopHttp() throws Exception {
		http.stop();
		http=null;
	}
}
