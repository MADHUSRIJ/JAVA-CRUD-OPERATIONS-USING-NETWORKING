package project2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Database {
	
	public void dbinsert(set mn){
    	
    	try {
    		
    		String FULLNAME = mn.getFN();
    		String USERNAME = mn.getUN();
    		String DOB = mn.getDOB();
    		Integer AGE = Integer.parseInt(mn.getAge());
    		String GENDER = mn.getG();
    		String MARITALSTATUS = mn.getM();
    		String ADDRESS = mn.getAdd();
    		String STATE = mn.getS();
    		Long PINCODE = Long.parseLong(mn.getPin());
    		Long PHONENUMBER = Long.parseLong(mn.getPhn());
    		Long ALTPHONENUMBER = Long.parseLong(mn.getAlt());
    		String PASSWORD = mn.getPas();
    		
    		Connection conn = getConn.getConnection();
    		Statement stmt = conn.createStatement();
    		
    		String query = "insert into Project1 values('"+FULLNAME+"','"+USERNAME+"','"+DOB+"',"+AGE+",'"+GENDER+"','"+MARITALSTATUS+"','"+ADDRESS+"','"+STATE+"',"+PINCODE+","+PHONENUMBER+","+ALTPHONENUMBER+",'"+PASSWORD+"')";
    		
    		stmt.executeUpdate(query);
    		conn.setAutoCommit(true);
    		
    		JOptionPane.showMessageDialog(null, "Hi ! "+FULLNAME+"\nYOUR REGISTRATION WAS SUCCESSFUL !\nTHANK YOU !\nHAVE A NICE DAY !");
    		viewDetails vd = new viewDetails(USERNAME);
    	}
    	
    	catch(Exception e) {
    		JOptionPane.showMessageDialog(null, "SORRY THERE IS AN ERROR IN REGISTERING YOUR DETAILS\n ERROR : "+e.toString());
    	}
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Database();
	}


	

}
