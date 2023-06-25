package com.masai;

public class MySql implements Database{

	private String URL;
	private String userName;
	private String PassWord;
	
	public void setURL(String uRL) {
		URL = uRL;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	@Override
	public String toString() {
		return "MsSql [URL=" + URL + ", userName=" + userName + ", PassWord=" + PassWord + "]";
	}
	
	@Override
	public void getConnection() {
		System.out.println("Hi I am MySQL");
	}
	
}
