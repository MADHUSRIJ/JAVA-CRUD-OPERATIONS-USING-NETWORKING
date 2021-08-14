package project2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class dbChecking extends Thread{
       private static ServerSocket ss;
       static Socket s;
       static InputStream in;
       static OutputStream out;
       static String uName = "";
       static String password = "";
       static boolean exit = false;
       
       public dbChecking(int port) throws Exception{
    	   ss = new ServerSocket(port);
       }
       
       
       public void run() {
   		try {
   			s = ss.accept();
   			System.out.println("Connected");
   		}
   		catch(Exception e){
   			System.out.println("Connect thread"+e);
   		}
   	}
       public static void main(String[] args) {
		
    	   int port = 7558;
    	   try {
    		   Thread connector = new dbChecking(port);
    		   
    		   connector.start();
    		   
    		   try {
    			   connector.join();
    		   }
    		   catch(Exception q) {
    			   System.out.println("JOIN THREAD"+q);
    		   }
    		   
    		   Thread rt = new Thread() {
   				
   				public void run() {
   						
   							while(true) {
   								try {
   	   								in = s.getInputStream();
   	   								ObjectInputStream dis = new ObjectInputStream(in);
   	   								try {
   										uName = (String) dis.readObject();
   									} catch (Exception e) {
   										// TODO Auto-generated catch block
   										System.out.println("CAN'T");
   									}
   	   							} catch (IOException e) {
   	   								System.out.println("dbChecking rt"+e);
   	   							}
   							}
   							
   						
   				}
   			};
   			rt.start();
   			try {
   				Thread.sleep(2);
   			}
   			catch(Exception e3) {
   				System.out.println(e3);
   			}
   			
   			
   			try {
   				Connection conn = getConn.getConnection();
   	    		
   	     	    String query = "SELECT PASSWORD FROM PROJECT1 WHERE USERNAME=?";
   	     	    PreparedStatement pstmt = conn.prepareStatement(query);
   	     	    pstmt.setString(1, uName);
   	     	    ResultSet rst = pstmt.executeQuery();
			    if(rst.next()) {
			    	password = rst.getString("PASSWORD");
			    }	
   			}
   			catch(Exception e2) {
   				System.out.println("dbChecking db"+e2);
   			}
   			
   			Thread wt = new Thread() {
				public void run() {
						while(true) {
							try {
								ObjectOutputStream ou = new ObjectOutputStream(s.getOutputStream());
								ou.writeObject(password);
							} catch (IOException e) {
								System.out.println("dbChecking wt"+e);
							}
						}
				}
			};
			
   			wt.start();
   			try {
   				Thread.sleep(3);
   			}
   			catch(Exception e3) {
   				System.out.println(e3);
   			}
    	   }
    	   catch(Exception e) {
    		   System.out.println("dbChecking"+e);
    	   }
    	   
    	
	}
}
