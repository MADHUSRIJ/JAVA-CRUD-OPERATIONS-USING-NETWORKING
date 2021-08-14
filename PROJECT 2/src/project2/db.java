package project2;


import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class db implements Runnable{
	private ServerSocket ss;
	Socket sd;
	ObjectInputStream dis;
	set mn = null;
	public db() {
		// TODO Auto-generated method stub
		try {
			ss = new ServerSocket(7211);
			while(true) {
				sd = ss.accept();
				InputStream in = sd.getInputStream();
	    		dis = new ObjectInputStream(in);
	    		mn = (set)dis.readObject();
	    		Database dd = new Database();
	    		dd.dbinsert(mn);
			}
		}
		catch(Exception ee) {
			System.out.println("SERVER"+ee);
		}
		
		
	}
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new db();
	}

}
