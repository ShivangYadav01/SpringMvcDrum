package com.drum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v2/")
public class NewController {
	@RequestMapping("/")
	public String getResponse()
	{
		System.out.println("NewController.getResponse()");
		return "Welcome";
	}
	
	@RequestMapping("/login")
	public String loginRequest() {
		System.out.println("loginRequest.getResponse()");
		
		return "profile";
	}
	
	
	

}