package com.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.UserBean;

@Controller
public class SessionController {

	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public String signup(Model model) {
		model.addAttribute("user", new UserBean());
		return "Signup";// jsp
	}

	@RequestMapping(value = "login") // defult it will take get
	public String login() {
		return "Login";
	}

	@GetMapping("forgetpassword") // direct get mapsping
	public String forgetPassword() {
		return "ForgetPassword";
	}

	@PostMapping("saveuser")
	public String saveUser(@ModelAttribute("user") @Valid UserBean user, BindingResult result, Model model) {
		// get
		// valid
		model.addAttribute("user", user);
  
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "Signup";
		} else {
			// bean
			// dao -> db
			System.out.println(user.getEmail());
			return "Home";// jsp
		}
	}
	// method -> model->
}
