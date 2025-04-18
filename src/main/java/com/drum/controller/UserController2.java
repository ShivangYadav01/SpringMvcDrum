package com.drum.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserController2 {
	
	
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
	cookie.setMaxAge(10); // Cookie will expire in 1 hour
	response.addCookie(cookie);
	System.out.println("UserController2.setCookie()");
	return "redirect:/footwear/second";
	}


@RequestMapping("/second")
	public String secondPage(
			@CookieValue(value = "myCookie", defaultValue = "defaultCookieValue1") String myCookieValue, Model model) {
		// Use myCookieValue in your controller logic
		System.out.println("HelloWorldController2.secondPage()");
		model.addAttribute("cookiesValue", myCookieValue);
		return "second";
	}
}

