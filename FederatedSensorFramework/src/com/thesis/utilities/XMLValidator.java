package com.thesis.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;
public class XMLValidator {

	
	public static boolean validateXMLSchema(String xsdPath, InputStream in){
        
        try {
            SchemaFactory factory = 
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(in));
            //validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
        return true;
    }
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String xsdPath="/home/gogineni/src/sdqml.xsd";
		String xmlPath="/home/gogineni/src/sdqml.xml";
		InputStream in = new FileInputStream(xmlPath);
		System.out.println("Validated:"+validateXMLSchema(xsdPath,in));
		in.close();
	}

}
