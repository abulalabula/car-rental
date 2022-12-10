package com.example.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.UserLoginDAO; 
import com.example.pojo.UserLogin;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;

//@RestController(Controller + ResponseBody) not working for jsp render
@Controller
public class UserController {
	@GetMapping("/login.htm")

//	@ResponseBody
	public String checkLoginGet() {
		System.out.println("In checkLoginGet()");
		return "login-form";
	}
	
	// submit botton -> POST links to jsp 
	@PostMapping("/login.htm")
	public String checkLoginPost(HttpServletRequest request) {
		String email = request.getParameter("email");
		String psw = request.getParameter("pswrd");
		System.out.println(email + " " + psw);
		UserLoginDAO userdao = new UserLoginDAO();
		UserLogin login = userdao.checkUserLogin(email, psw);
		
		if (login == null) {
			request.setAttribute("msg", "Your email or password is not correct.");
			return "error-page";
		}
		request.setAttribute("login", login);
//		System.out.println(login.getUserid()+ " " + login.getEmail() + " " + login.getPassword());
		return "home";
	}
	
	@GetMapping("/info.htm")
	@ResponseBody
	public String getInfo() {
		return "info";
		
	}
}
