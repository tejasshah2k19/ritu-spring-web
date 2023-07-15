package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class AdminController {

	@Autowired
	UserDao userDao; 
	
	@GetMapping("dashboard")
	public String dashboard(Model model) {
		
		//get all users from db 

		List<UserBean> users = userDao.getAllUsers();
		model.addAttribute("users",users); // key : value 
		return "Dashboard"; 
	}
}
