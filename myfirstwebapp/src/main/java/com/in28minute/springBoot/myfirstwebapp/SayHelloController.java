package com.in28minute.springBoot.myfirstwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller 
public class SayHelloController {
//"say-hello"=>"Hello! what are you learning today?"
	//http://localhost:8082/say-hello
	@RequestMapping("say-hello")
	@ResponseBody
	
	public String sayHello() {
		
		return "Hello! what are you learning today?";
	}
	@RequestMapping("say-hello")
	@ResponseBody
	
	public String sayHelloHtml() {
		StringBuffer sb=new StringBuffer();
		
		return "Hello! what are you learning today?";
	}
}
