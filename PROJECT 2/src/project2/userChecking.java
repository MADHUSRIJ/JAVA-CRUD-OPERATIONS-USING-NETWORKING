package project2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class userChecking extends Thread{
	Socket s;
	InputStream in;
	OutputStream out;
    String uName;
    String password;
    private String org_pass = "";
    boolean bool = false;
    public boolean check() {
    	return bool;
    }
	public userChecking(String USERNAME, String given_password) {
		// TODO Auto-generated constructor stub
		this.uName = USERNAME;
		this.password = given_password;	
		try {
			s = new Socket("127.0.0.1",7558);
			Thread rt = new Thread() {
				
				public void run() {
							while(true) {
								try {
									in = s.getInputStream();
									ObjectInputStream dis = new ObjectInputStream(in);
									try {
										org_pass = (String)dis.readObject();
									} catch (ClassNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								} catch (IOException e) {
									System.out.println("USERCHECKING rt"+e);
								}
							}
						
				}
			};
			
           Thread wt = new Thread() {
				
				public void run() {
						
							while(true) {
								try {
									OutputStream ou = s.getOutputStream();
									ObjectOutputStream dos = new ObjectOutputStream(ou);
									dos.writeObject(uName);
									dos.flush();
								} catch (IOException e) {
									System.out.println("USERCHECKING wt"+e);
								}
							}
							
				}
			};
			wt.start();
			try {
   				Thread.sleep(1);
   			}
   			catch(Exception e3) {
   				System.out.println(e3);
   			}
			rt.start();
			try {
   				Thread.sleep(1000);
   			}
   			catch(Exception e3) {
   				System.out.println(e3);
   			}
		}
		catch(Exception e) {
			System.out.println("THREAD CHECK :"+e);
		}
		
		if(org_pass.equals(given_password)) {
			bool = !bool;
		}
		
		
	}


}
