package com.cg.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="Login")
public class WasherLogin 
{
	@Id
	private String name;
	private String password;
	public WasherLogin(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "WasherLogin [name=" + name + ", password=" + password + "]";
	}
	
	
}
