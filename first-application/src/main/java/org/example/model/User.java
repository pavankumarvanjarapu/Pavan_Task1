package org.example.model;

public class User {
	private String userName;
	private String password;
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
