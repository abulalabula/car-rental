package com.example.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.UserLoginDAO;
import com.example.dao.UserRegisterDAO;
import com.example.pojo.UserLogin;
import com.example.pojo.UserRegister;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;

//@RestController(Controller + ResponseBody) not working for jsp render: only text data sent
@Controller
//@Service
//@Repository
//@Component
public class UserController {
	@GetMapping("/login.htm")
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
	
	@GetMapping("/register.htm")
	public String checkRegisterGet() {
		System.out.println("In checkRegisterGet()");
		return "register-form";
	}
	
	@PostMapping("/register.htm")
	public String registerPost(HttpServletRequest request) {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String psw = request.getParameter("pswrd");
		String customer = "Customer";
		System.out.println("Register: " + email + " " + psw);
		UserRegisterDAO userdao = new UserRegisterDAO();
		UserRegister register = new UserRegister();
		
		register.setFirstName(firstName);
		register.setLastName(lastName);
		register.setEmail(email);
		register.setPassword(psw);
		register.setRole(customer);
		userdao.create(register);
		
//		if (register == null) {
//			request.setAttribute("msg", "Your email or password is not correct.");
//			return "error-page";
//		}
//		request.setAttribute("register", register);
//		System.out.println(login.getUserid()+ " " + login.getEmail() + " " + login.getPassword());
		return "home";
	}
	
	
	
	
	
	
//	@GetMapping("/info.htm")
//	@ResponseBody
//	public String getInfo() {
//		return "info";
//		
//	}
}
