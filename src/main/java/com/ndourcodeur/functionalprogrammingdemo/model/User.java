package com.ndourcodeur.functionalprogrammingdemo.model;

/**
 * 
 * @author NdourCodeur
 * @version 1.0
 * @since 07/21/2022
 *
 */
public class User {
	
	private int id;
	private String name;
	private String email;
	private String phone;
	private boolean isActive;
	private int age;
	
	public User() {}
	
	public User(int id, String name, String email, String phone, boolean isActive, int age) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.isActive = isActive;
		this.age = age;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
