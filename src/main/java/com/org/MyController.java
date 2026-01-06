package com.org;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController//ResponseBody and Controller
public class MyController {
	
	@RequestMapping("/hello")
//	@ResponseBody
	public String m1() {
		
		System.out.println("hello executed");
		return "Hello!!!! Welcome to Spring Boot";
	}
}
