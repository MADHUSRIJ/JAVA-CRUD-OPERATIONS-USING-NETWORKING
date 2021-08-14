package project2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class fetchClient extends Thread{
	Socket s;
	InputStream in;
	OutputStream out;
    String uName;
    String[] result = new String[10];
    boolean bool = false;
    boolean exit1 = false;
	boolean exit2 = false;
    public String[] check() {
    	return result;
    }
	public fetchClient(String USERNAME) {
		// TODO Auto-generated constructor stub
		this.uName = USERNAME;
		System.out.println(uName);
		try {
			s = new Socket("127.0.0.1",1324);
			Thread rt = new Thread() {
				
				public void run() {
							while(!exit1) {
								try {
									//System.out.println("I");
									in = s.getInputStream();
									ObjectInputStream dis = new ObjectInputStream(in);
									try {
										System.out.println("INGA");
										result = (String[])dis.readObject();
									} catch (ClassNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									//System.out.println("I");
								} catch (IOException e) {
									System.out.println("fetchclient rt"+e);
								}
							}
						
				}
			};
			
           Thread wt = new Thread() {
				
				public void run() {
						
							while(!exit2) {
								try {
									//System.out.println("H");
									OutputStream ou = s.getOutputStream();
									ObjectOutputStream dos = new ObjectOutputStream(ou);
									dos.writeObject(uName);
									//System.out.println("H");
									dos.flush();
								} catch (IOException e) {
									System.out.println("fetchclient wt"+e);
								}
							}
							
				}
			};
			wt.start();
			try {
   				Thread.sleep(5);
   			}
   			catch(Exception e3) {
   				System.out.println(e3);
   			}
			exit2 = true;
			rt.start();
			try {
   				Thread.sleep(1000);
   			}
   			catch(Exception e3) {
   				System.out.println(e3);
   			}
			exit1 = true;
			
		}
		catch(Exception e) {
			System.out.println("THREAD CHECK :"+e);
		}
				
	}


}

