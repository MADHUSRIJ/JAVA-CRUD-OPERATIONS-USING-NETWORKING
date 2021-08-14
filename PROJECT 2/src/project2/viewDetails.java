package project2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class viewDetails extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel title,name,userName,DOB,age,gender,marital,address,state,pincode,phn,altPhn;
	JLabel name_t,userName_t,dob_t,age_t,gender_t,marital_t,address_t,state_t,pincode_t,phn_t,altPhn_t;
	String name_s = "",userName_s="",dob_s="",age_s="",gender_s="",marital_s="",address_s="",state_s="",pincode_s="",phn_s="",altPhn_s="";
	Container co;
	String result[] = new String[10];
	JPanel jp; 
	viewDetails(String USERNAME){
		
		fetchClient fc = new fetchClient(USERNAME);
		result = fc.check();
		
		name_s = result[0];
		dob_s = result[1];
		age_s = result[2];
		gender_s = result[3];
		marital_s = result[4];
		address_s = result[5];
		pincode_s = result[6];
		state_s = result[7];
		phn_s = result[8];
		altPhn_s = result[9];
		
		this.userName_s = USERNAME;
         
		co = getContentPane();
		co.setLayout(null);
		
		title = new JLabel("<HTML><U>"+name_s+" - DETAILS</U></HTML>");
		name = new JLabel("FULL NAME");
		userName = new JLabel("USERNAME");
		DOB = new JLabel("DATE OF BIRTH");
		age = new JLabel("AGE");
		gender = new JLabel("GENDER");
		marital = new JLabel("MARITAL STATUS");
		address = new JLabel("ADDRESS");
		state = new JLabel("STATE");
		pincode = new JLabel("PINCODE");
		phn = new JLabel("PHONE NUMBER");
		altPhn = new JLabel("ALTERNATE PHONE NUMBER");
		
		
		name_t = new JLabel(name_s);
		userName_t = new JLabel(userName_s);
		dob_t = new JLabel(dob_s);
		age_t = new JLabel(age_s);
		gender_t = new JLabel(gender_s);
		marital_t = new JLabel(marital_s);
		address_t = new JLabel(address_s);
		state_t = new JLabel(state_s);
		pincode_t = new JLabel(pincode_s);
		phn_t = new JLabel(phn_s);
		altPhn_t = new JLabel(altPhn_s);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		title.setBounds(400,10,1000,80);
		title.setFont(new Font("Serif", Font.BOLD,  25));
		title.setForeground(new Color(29,70,165));
		
		
		name.setBounds(100,120,200,30);
		name.setFont(new Font("SERIF", Font.BOLD,  20));
		name_t.setBounds(280,120,200,30);
		name_t.setFont(new Font("SERIF", Font.PLAIN,  20));
		userName.setBounds(600,120,200,30);
		userName.setFont(new Font("SERIF", Font.BOLD,  20));
		userName_t.setBounds(920,120,200,30);
		userName_t.setFont(new Font("SERIF", Font.PLAIN,  20));
		
		DOB.setBounds(100,170,200,30);
		DOB.setFont(new Font("SERIF", Font.BOLD,  20));
		dob_t.setBounds(280,170,200,30);
		dob_t.setFont(new Font("SERIF", Font.PLAIN,  20));
		age.setBounds(600,170,200,30);
		age.setFont(new Font("SERIF", Font.BOLD,  20));
		age_t.setBounds(920,170,200,30);
		age_t.setFont(new Font("SERIF", Font.PLAIN,  20));
		
		gender.setBounds(100,220,200,30);
		gender.setFont(new Font("SERIF", Font.BOLD,  20));
		gender_t.setBounds(280,220,200,30);
		gender_t.setFont(new Font("SERIF", Font.PLAIN,  20));
		marital.setBounds(600,220,200,30);
		marital.setFont(new Font("SERIF", Font.BOLD,  20));
		marital_t.setBounds(920,220,200,30);
		marital_t.setFont(new Font("SERIF", Font.PLAIN,  20));
		
		address.setBounds(100,270,200,30);
		address.setFont(new Font("SERIF", Font.BOLD,  20));
		address_t.setBounds(280,270,200,30);
		address_t.setFont(new Font("SERIF", Font.PLAIN,  20));
		state.setBounds(600,280,200,30);
		state.setFont(new Font("SERIF", Font.BOLD,  20));
		state_t.setBounds(920,280,200,30);
		state_t.setFont(new Font("SERIF", Font.PLAIN,  20));
		pincode.setBounds(600,330,200,30);
		pincode.setFont(new Font("SERIF", Font.BOLD,  20));
		pincode_t.setBounds(920,330,200,30);
		pincode_t.setFont(new Font("SERIF", Font.PLAIN,  20));
		
		phn.setBounds(100,380,200,30);
		phn.setFont(new Font("SERIF", Font.BOLD,  20));
		phn_t.setBounds(280,380,200,30);
		phn_t.setFont(new Font("SERIF", Font.PLAIN,  20));
		altPhn.setBounds(600,380,300,30);
		altPhn.setFont(new Font("SERIF", Font.BOLD,  20));
		altPhn_t.setBounds(920,380,200,30);
		altPhn_t.setFont(new Font("SERIF", Font.PLAIN,  20));
		
		
		
		jp = new JPanel();
		jp.setBounds(160,150,1200,470);
		jp.setLayout(null);
		jp.setOpaque(true);
		jp.setVisible(true);
		jp.setBackground(new Color(255,235,235));
		jp.setBorder(BorderFactory.createLineBorder(new Color(255,178,178), 3, false));
		
		jp.add(title);
		jp.add(name);
		jp.add(name_t);
		jp.add(userName);
		jp.add(userName_t);
		jp.add(DOB);
		jp.add(dob_t);
		jp.add(age);
		jp.add(age_t);
		jp.add(gender);
		jp.add(gender_t);
		jp.add(marital);
		jp.add(marital_t);
		jp.add(address);
		jp.add(address_t);
		jp.add(state);
		jp.add(state_t);
		jp.add(pincode);
		jp.add(pincode_t);
		jp.add(phn);
		jp.add(phn_t);
		jp.add(altPhn);
		jp.add(altPhn_t);
		
		co.add(jp);
		
		setSize(2000,2000);
		co.setBackground(new Color(255,212,212));
		setVisible(true);

	}
    public static void main(String[] args) {
		new viewDetails("");
	}
}
