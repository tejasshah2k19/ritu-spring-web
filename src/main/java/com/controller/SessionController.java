package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SessionController {

	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public String signup() {
		return "Signup";// jsp
	}
	
	@RequestMapping(value="login") //defult it will take get 
	public String login() {
		return "Login";
	}
	
	@GetMapping("forgetpassword") // direct get mapping 
	public String forgetPassword() {
		return "ForgetPassword";
	}
}
