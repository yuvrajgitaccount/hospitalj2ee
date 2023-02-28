package com.hosptial.entity;

public class Specialist {
	
	
	private int id;
	
	private String spcailistname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpcailistname() {
		return spcailistname;
	}

	public void setSpcailistname(String spcailistname) {
		this.spcailistname = spcailistname;
	}

	public Specialist(int id, String spcailistname) {
		super();
		this.id = id;
		this.spcailistname = spcailistname;
	}

	public Specialist() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Specialist [id=" + id + ", spcailistname=" + spcailistname + "]";
	}
	
	

}
