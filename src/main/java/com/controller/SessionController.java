package com.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.LoginBean;
import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class SessionController {

	@Autowired
	UserDao userDao;

	@Autowired
	BCryptPasswordEncoder encoder;

	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public String signup(Model model) {
		model.addAttribute("user", new UserBean());
		return "Signup";// jsp
	}

	@RequestMapping(value = "login") // defult it will take get
	public String login(Model model) {
		model.addAttribute("user", new LoginBean());
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
			user.setRole("USER");

			user.setPassword(encoder.encode(user.getPassword()));
			userDao.addUser(user);
			System.out.println(user.getEmail());
			return "Home";// jsp
		}
	}

	@PostMapping("/authenticate")
	public String authenticate(LoginBean login, Model model, HttpSession session) { // email and password
		UserBean user = userDao.getUserByEmail(login.getEmail());
		if (user != null) {
			System.out.println(" Email Found " + login.getEmail());

			if (encoder.matches(login.getPassword(), user.getPassword())) {
				session.setAttribute("user", user);

				if (user.getRole() == null) {
					model.addAttribute("user", login);
					return "Login";
				} else if (user.getRole().equals("USER")) {
					return "Home";

				} else if (user.getRole().contentEquals("ADMIN")) {
					return "redirect:/dashboard"; // do not open jsp - redirect to dashboard url 
				}
			}
		} else {
			System.out.println("No Email Found " + login.getEmail());

		}
		model.addAttribute("user", login);
		return "Login";
	}
	// method -> model->


	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "Login";
	}

}
