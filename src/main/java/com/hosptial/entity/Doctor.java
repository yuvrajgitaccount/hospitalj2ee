package com.hosptial.entity;

public class Doctor {

	private int id;

	private String name;

	private String dob;

	private String quali;

	private String spcailistname;

	private String email;
	private String mobno;
	
	private String password;

	
	public Doctor(int id, String name, String dob, String quali, String spcailistname, String email, String mobno,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.quali = quali;
		this.spcailistname = spcailistname;
		this.email = email;
		this.mobno = mobno;
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getQuali() {
		return quali;
	}


	public void setQuali(String quali) {
		this.quali = quali;
	}


	public String getSpcailistname() {
		return spcailistname;
	}


	public void setSpcailistname(String spcailistname) {
		this.spcailistname = spcailistname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobno() {
		return mobno;
	}


	public void setMobno(String mobno) {
		this.mobno = mobno;
	}


	public String getPassword() {
		return password;
	}


	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", dob=" + dob + ", quali=" + quali + ", spcailistname="
				+ spcailistname + ", email=" + email + ", mobno=" + mobno + ", password=" + password + "]";
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
}
