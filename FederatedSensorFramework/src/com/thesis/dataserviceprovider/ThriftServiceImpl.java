package com.thesis.dataserviceprovider;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.thrift.TException;
import org.basex.BaseXHTTP;

import com.thesis.utilities.XMLValidator;

import BaseXRestClients.BaseXServer;
import BaseXRestClients.RESTCreateDocument;

public class ThriftServiceImpl implements ThriftService.Iface{

	@Override
	public boolean pushSDQML(String xml) throws InvalidSDQML, TException {
		// TODO Auto-generated method stub
		try
		{
		 // Start servers
	    BaseXHTTP http;
			http = BaseXServer.getHttp();
		
	    RESTCreateDocument rd= new RESTCreateDocument();
	    rd.setName("inputthrift");
		
		InputStream in = new ByteArrayInputStream(xml.getBytes());
		InputStream in1= new ByteArrayInputStream(xml.getBytes());
		String xsdPath="/home/gogineni/src/sdqml.xsd";
		Boolean isValidated=XMLValidator.validateXMLSchema(xsdPath,in1);
		//System.out.println("Validated:"+isValidated);
			
	    rd.setXml(RESTCreateDocument.getStringFromInputStream(in));
	    in.close();
	    // Run example
	    if(isValidated)
	    {
	     Boolean isRest=rd.run();
	     return isRest;
		}
		else
		{
			return false;
		}
		}
		catch(FileNotFoundException e)
		{
			return false;

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return false;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		}
	}

}
