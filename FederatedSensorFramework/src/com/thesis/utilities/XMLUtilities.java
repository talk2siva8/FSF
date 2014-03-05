/**
 * 
 */
package com.thesis.utilities;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.thesis.utilities.results.Results;
import com.thesis.utilities.results.Results.Result;

/**
 * Converts an SURL into a valid XPath for querying pur
 * 
 * @author gogineni
 * 
 */
public class XMLUtilities {
	public static String SDQMLToXPATH(String xml) {
		// SURLToObject(xml);
		String xpath = null;
		// The field to be retrieved in our case it is the storage
		String baseurl = "//SDQML/SFDL/description/storage";
		// conditions
		String conditions = "[//SDQML/SFDL/sensor/location/latitude>90.70 and //SDQML/SFDL/sensor/location/longitude>90.70 and //SDQML/SFDL/sensor/frequency>10 and number(translate(//SDQML/SFDL/sensor/duration/@start,'-,:,T','')) > 20100530083000]";
		xpath = baseurl + conditions;
		return xpath;
	}
	public static Object SURLToObject(String xml) {
		return new Object();
	}
	/**
	 * 
	 * @param xml
	 * @return
	 */
	public static Results BaseXResultsToObject(String xml) {

		Results results = new Results();
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(Results.class);
			InputStream in = new ByteArrayInputStream(xml.getBytes());
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			results = (Results) jaxbUnmarshaller.unmarshal(in);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		// http://www.javacodegeeks.com/2011/02/jaxb-generate-xml-xsd.html
		// http://theopentutorials.com/examples/java/jaxb/generate-java-class-from-xml-schema-using-jaxb-xjc-command/
		return results;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Results results = BaseXResultsToObject("<?xml version=\"1.0\"?><results><result>    <storage>databasename</storage></result><result>    <storage>databasename</storage></result><result>    <storage>databasename</storage></result><result>    <storage>databasename</storage></result><result>    <storage>databasename</storage></result><result>    <storage>databasename</storage></result><result>    <storage>databasename</storage></result></results>");
		System.out.println(results);
		List<Result> list = (results.getResult());
		Iterator<Result> it = list.iterator();
		while (it.hasNext()) {
			Result r = it.next();
			System.out.println(r.getStorage());
		}
	}

}
