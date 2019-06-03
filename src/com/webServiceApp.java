package com;
import  javax.xml.ws.Endpoint;  

public class webServiceApp {  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
         System.out.println("web service start");  
	     wsImpl implementor = new wsImpl();  
         String address = "http://localhost:9092/CXF/ws";  
         Endpoint.publish(address, implementor);  
         System.out.println("web service started");  
    }  
  
}  