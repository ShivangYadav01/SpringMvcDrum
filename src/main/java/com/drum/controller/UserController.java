package com.drum.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drum.model.User;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UserController {

	static List<User> list = new ArrayList<User>();
	
	static {
		list.add(new User(1,"Ankit","ankit@gmail.com","wwwwww"));
		list.add(new User(2,"Muskan","ankit@gmail.com","wwwwww"));
		list.add(new User(3,"Anushka","anushka@gmail.com","wwwwww"));
		list.add(new User(4,"Shivam","shivam@gmail.com","wwwwww"));
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
	
	@GetMapping(path= {"/getmapping","fetchMapping"})
	public String get(HttpServletRequest req,HttpServletResponse res) {
		System.out.println("Footwear -Controller");
		return "admin";
	}
@GetMapping(path = {"/getParam"})
	public String getParam(@RequestParam(name ="name",defaultValue="Guest")String name) {
	System.out.println("Controller-  params=name: " + name);
	return "index";
}

@RequestMapping("/")
	public String get() {
	System.out.print("Controller -fetchMapping");
	return"index";
}


@RequestMapping("/setCookie")
public String setCookie(HttpServletResponse response) {
	Cookie cookie = new Cookie("myCookie", "DangerValue");
	cookie.setMaxAge(1110); // Cookie will expire in 1 hour
	response.addCookie(cookie);
	System.out.println("UserController2.setCookie()");
	return "redirect:/second";
	}


@RequestMapping("/second")
	public String secondPage(
			@CookieValue(value = "myCookie", defaultValue = "defaultCookieValue1") String myCookieValue, Model model) {
		// Use myCookieValue in your controller logic
		System.out.println("HelloWorldController2.secondPage()");
		model.addAttribute("cookiesValue", myCookieValue);
		return "second";
	}

	@GetMapping("/getUser/{id}")
	@ResponseBody 
	public User getUsersData(@PathVariable("id") int id) {
		System.out.println("UserController.getAllUsersData()"); 
		for(User user : list ) {
			if(user.getId() == id) {		
		System.out.println(user);
		return user;
			}
			
		}
		
		return null;
	}
	
}