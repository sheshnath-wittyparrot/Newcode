package com.springrest.springrest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entity.Course;

@RestController
public class MyConroller {
	@GetMapping("/home")
	public String home() {
	return "this is mynhome";	
	}
	
	
	public List<Course> getCourse()
	{
		
	}

}
