package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Component
@Entity
public class User implements  Serializable
{
	public User()
	{}
	
	private static final long serialVersionUID = -5294671367987983736L;
	@Id
	@GeneratedValue
	 @Column(name = "USER_ID")
	private int id;
	private String username;
	private String email;
	private boolean enable;
	private String password;
	private String role;

	private String contact;
	


	public boolean isEnable() {
		return enable;
	}

	
	public void setEnable(boolean enable) 
	{
		this.enable = enable;
	}


	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getUsername() 
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;

	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getContact() 
	{
		return contact;
	}
	public void setContact(String contact) 
	{
		this.contact = contact;
	}
	
	
	
}	
	