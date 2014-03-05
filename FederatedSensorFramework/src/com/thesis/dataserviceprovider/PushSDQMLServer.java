package com.thesis.dataserviceprovider;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class PushSDQMLServer {
	 private int port;
	 public PushSDQMLServer(int port)
	 {
		 this.port=port;
	 }
    private void start() {
        try {
            TServerSocket serverTransport = new TServerSocket(port);
 
            ThriftService.Processor processor = new ThriftService.Processor(new ThriftServiceImpl());
 
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).
                    processor(processor));
            System.out.println("Starting server on port "+port+" ...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
 
    public static void main(String[] args) {
    	int portNo=7928;
        PushSDQMLServer srv = new PushSDQMLServer(portNo);
        srv.start();
    }
 
}