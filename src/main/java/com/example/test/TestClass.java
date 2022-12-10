package com.example.test;

import com.example.dao.UserLoginDAO;
import com.example.pojo.UserLogin;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long id = 1;
	
//		String email = ""
		UserLoginDAO userdao = new UserLoginDAO();
		UserLogin login = userdao.checkUserLogin("test@northeastern.edu", "testPasswd");
		System.out.println(login.getUserid()+ " " + login.getEmail() + " " + login.getPassword());

	}

}
