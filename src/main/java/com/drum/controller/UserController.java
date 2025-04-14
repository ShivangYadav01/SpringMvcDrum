package com.drum.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.drum.model.User;

@Controller
public class UserController {

	static List<User> list = new ArrayList<User>();
	
	static {
		list.add(new User("Ankit","ankit@gmail.com","wwwwww"));
		list.add(new User("Muskan","ankit@gmail.com","wwwwww"));
		list.add(new User("Anushka","anushka@gmail.com","wwwwww"));
		list.add(new User("Shivam","shivam@gmail.com","wwwwww"));
	}


	@GetMapping("/")
	public String getResponse() {
		System.out.println("UserController.getResponse()");
		return "hello";
	}

	@GetMapping("/userForm")
	public String showForm(Model model) {
		model.addAttribute("user", new User());
		return "userForm";
	}

	@PostMapping("/submitUser")
	public String submitForm(@ModelAttribute("user") User user, Model model) {
		System.out.println("UserController.submitForm()");
		  list.add(user);
		// You can process or save the user object here
		model.addAttribute("message", "User submitted successfully!");
		return "userResult";
	}
	
	@GetMapping("/getAllUsers")
	public String getAllUsersData() {
		System.out.println("UserController.getAllUsersData()");
		
		return "hello";
	}
	
}