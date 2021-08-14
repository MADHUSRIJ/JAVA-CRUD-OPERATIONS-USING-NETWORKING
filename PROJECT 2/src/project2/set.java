package project2;

import java.io.Serializable;

public class set implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String FullName = "";
	private String UserName = "";
	private String DOB = "";
	private String Age = "";
	private String Gender = "";
	private String Marital = "";
	private String Address = "";
	private String State = "";
	private String Pincode = "";
	private String PhnNumber = "";
	private String AltPhnNumber = "";
	private String PassWord = "";
	
  
	public set(DetailsCheck mn){
		this.FullName = mn.getFullName();
		this.UserName = mn.getUserName();
		this.DOB = mn.getDOB();
		this.Age = mn.getAge();
		this.Gender = mn.getGender();
		this.Marital = mn.getMarital();
		this.Address = mn.getAddress();
		this.State = mn.getState();
		this.Pincode = mn.getPincode();
		this.PhnNumber = mn.getPhnNumber();
		this.AltPhnNumber = mn.getAltPhnNumber();
		this.PassWord = mn.getPassWord();	
	}
	
	public String getFN() {
		return FullName;
	}
	
	public String getUN() {
		return UserName;
	}
	
	public String getDOB() {
		return DOB;
	}
	
	public String getAge() {
		return Age;
	}
	
	public String getG() {
		return Gender;
	}
	
	public String getM() {
		return Marital;
	}
	
	public String getAdd() {
		return Address;
	}
	
	public String getS() {
		return State;
	}
	
	public String getPin() {
		return Pincode;
	}
	
	public String getPhn() {
		return PhnNumber;
	}
	
	public String getAlt() {
		return AltPhnNumber;
	}
	
	public String getPas() {
		return PassWord;
	}
	
}
