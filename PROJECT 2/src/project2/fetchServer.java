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

public class fetchServer extends Thread{
       private ServerSocket ss;
       static Socket s;
       static InputStream in;
       static OutputStream out;
       static String uName = "";
       static String result[] = new String[10];
       static boolean exit3 = false;
	   static boolean exit4 = false;
       
       public  fetchServer(int port) throws Exception{
    	   ss = new ServerSocket(port);
       }
       
       
       public void run() {
   		try {
   			s = ss.accept();
   			System.out.println("fetchServer Connected");
   		}
   		catch(Exception e){
   			System.out.println("Connect thread"+e);
   		}
   	}
       public static void main(String[] args) {
		   
    	   int port = 1324;
    	   try {
    		   Thread connector = new fetchServer(port);
    		   
    		   connector.start();
    		   
    		   try {
    			   connector.join();
    		   }
    		   catch(Exception q) {
    			   System.out.println("JOIN THREAD"+q);
    		   }
    		   
    		   Thread rt = new Thread() {
   				
   				public void run() {
   						
   							while(!exit3) {
   								try {
   									//System.out.println("L");
   	   								in = s.getInputStream();
   	   								ObjectInputStream dis = new ObjectInputStream(in);
   	   								try {
   										uName = (String) dis.readObject();
   									} catch (Exception e) {
   										// TODO Auto-generated catch block
   										System.out.println("CAN'T");
   									}
   	   							//System.out.println("L");
   	   							} catch (IOException e) {
   	   								System.out.println("fetchserver rt"+e);
   	   							}
   							}
   							
   						
   				}
   			};
   			rt.start();
   			try {
   				Thread.sleep(5);
   			}
   			catch(Exception e3) {
   				System.out.println("FETCH SERVER"+e3);
   			}
   			exit3=true;
   			System.out.println(uName);
   			try {
   				Connection conn = getConn.getConnection();
   	    		
   	     	    String query = "SELECT * FROM PROJECT1 WHERE USERNAME=?";
   	     	    PreparedStatement pstmt = conn.prepareStatement(query);
   	     	    pstmt.setString(1, uName);
   	     	    ResultSet rst = pstmt.executeQuery();
   	     	    int i = 0;
			    while(rst.next()) {
			    	result[i++] = rst.getString("FULLNAME");
			    	result[i++] = rst.getString("DOB");
					String age_Str = Integer.toString(rst.getInt("AGE"));
					result[i++] = age_Str;
					result[i++] = rst.getString("GENDER");
					result[i++] = rst.getString("MARITALSTATUS");
					result[i++] = rst.getString("ADDRESS");
					String pin_str = Long.toString(rst.getLong("PINCODE"));
					result[i++] = pin_str;
					result[i++] = rst.getString("STATE");
					String phn_str = Long.toString(rst.getLong("PHONENUMBER"));
					String altPhn_str = Long.toString(rst.getLong("ALTPHONENUMBER"));
					result[i++] = phn_str;
					result[i++] =altPhn_str;
			    }	
   			}
   			catch(Exception e2) {
   				System.out.println("dbChecking db"+e2);
   			}
   			
   			Thread wt = new Thread() {
				public void run() {
						while(!exit4) {
							try {
								//System.out.println("K");
								ObjectOutputStream ou = new ObjectOutputStream(s.getOutputStream());
								ou.writeObject(result);
							} catch (IOException e) {
								System.out.println("fetchserver wt"+e);
							}
							//System.out.println("K");
						}
				}
			};
			
   			wt.start();
   			try {
   				Thread.sleep(5);
   			}
   			catch(Exception e3) {
   				System.out.println("FETCH SERVER"+e3);
   			}
   			exit4 = true;
   			
    	   }
    	   catch(Exception e) {
    		   System.out.println("dbChecking"+e);
    	   }
    	
	}
}
