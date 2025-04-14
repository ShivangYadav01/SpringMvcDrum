package com.drum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1")
public class WelcomeController {
	@RequestMapping("/")
	@ResponseBody
	public String getResponse()
	{
		System.out.println("WelcomeController.getResponse()");
		return "This is myfirst Response without View";
	}
	@RequestMapping("/login")
	public String loginRequest(@RequestParam("user") String userName , @RequestParam("pass")String pass, Model m)
	{ 
	
		System.out.println("Your Username is : "+userName);
		System.out.println("Your Password is : "+pass);
		System.out.println("loginRequest.getResponse()");
		
		String str = "Hello"+userName+"Now all yours";
		m.addAttribute("msg",str);
		return "profile";
	}	

}
