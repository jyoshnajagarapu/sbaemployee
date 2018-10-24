package com.verizon.sdmd.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Employees")
public class Employee {
	@Id 
	private int eId;
	private String eName;
	private double basic;
	private String emailId;
	private String mobileNUmber;
	private double hra;
	private String dept;
	private String gender;
	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	
	
	
	public Employee() {
		super();
	}


	


	public int geteId() {
		return eId;
	}


	public void seteId(int eId) {
		this.eId = eId;
	}


	public String geteName() {
		return eName;
	}


	public void seteName(String eName) {
		this.eName = eName;
	}


	public double getBasic() {
		return basic;
	}


	public void setBasic(double basic) {
		this.basic = basic;
	}


	public double getHra() {
		return hra;
	}


	public void setHra(double hra) {
		this.hra = hra;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getMobileNUmber() {
		return mobileNUmber;
	}


	public void setMobileNUmber(String mobileNUmber) {
		this.mobileNUmber = mobileNUmber;
	}


	public Employee(int eId, String eName, double basic, double hra, String dept, String gender,
			String mobileNUmber, String emailId) {
		
		this.eId = eId;
		this.eName = eName;
		this.basic = basic;
		this.hra = hra;
		this.dept = dept;
		this.gender = gender;
		this.emailId=emailId;
		this.mobileNUmber=mobileNUmber;
	}
	

}
