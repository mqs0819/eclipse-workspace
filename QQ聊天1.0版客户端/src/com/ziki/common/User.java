package com.ziki.common;

import java.io.Serializable;

public class User implements Serializable{
	private String userId;
	private String passWord;

	public void setUserId(String userId){
		this.userId = userId;
	}
	public String getUserId(){
		return userId;
	}

	public void setPassWord(String passWord){
		this.passWord = passWord;
	}
	public String getPassWord(){
		return passWord;
	}

}