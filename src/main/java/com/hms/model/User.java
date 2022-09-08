package com.hms.model;


public class User {

	
	private int id;
	private String name;
	private String bgroup;
	private String disease;
	
	public User(String name, String bgroup, String disease) {
		super();
		this.name = name;
		this.bgroup = bgroup;
		this.disease = disease;
	}
	public User(int id, String name, String bgroup, String disease) {
		super();
		this.id = id;
		this.name = name;
		this.bgroup = bgroup;
		this.disease = disease;
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
	public String getBgroup() {
		return bgroup;
	}
	public void setBgroup(String bgroup) {
		this.bgroup = bgroup;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	
}
