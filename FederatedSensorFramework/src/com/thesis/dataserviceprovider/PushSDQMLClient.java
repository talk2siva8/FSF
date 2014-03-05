package com.thesis.dataserviceprovider;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class PushSDQMLClient {
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

 public static void main(String[] args) throws FileNotFoundException {

  try {
   TTransport transport;

   transport = new TSocket("localhost", 7928);
   transport.open();

   TProtocol protocol = new TBinaryProtocol(transport);
   ThriftService.Client client = new ThriftService.Client(protocol);
String xml="";

InputStream in= new FileInputStream("/home/gogineni/src/sdqmldummy.xml");
xml=getStringFromInputStream(in);
long startTime = System.currentTimeMillis();
System.out.println("started!!!!!!!!!!!!!!! Yay!!");
for(int i=0; i<10;i++)
	   client.pushSDQML(xml);

   //System.out.println(client.pushSDQML(xml));

long endTime = System.currentTimeMillis();
System.out.println("That took " + (endTime - startTime)/1000 + " seconds");

   transport.close();
  } catch (TTransportException e) {
   e.printStackTrace();
  } catch (TException x) {
   x.printStackTrace();
  }
 }

}