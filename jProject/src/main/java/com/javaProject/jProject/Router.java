package com.javaProject.jProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Router {
	
	@Value("${welcome.message:message}")
	private String message = "Hello World";
	
	private List<WuzzufJob> jobs = new ArrayList<WuzzufJob>();

//	@RequestMapping("/gamal")
//	public String gamal(
//			/* "send  parameter" @RequestParam(value = "test", defaultValue = "non") String val */ ) 
//	{return "Gamal Page";}
//	
//	@RequestMapping("/mady")
//	public String mady(
//			/* "send  parameter" @RequestParam(value = "test", defaultValue = "non") String val */ ) 
//	{return "Mady Page";}
//	
//	@RequestMapping("/atef")
//	public String atef(
//			/* "send  parameter" @RequestParam(value = "test", defaultValue = "non") String val */ ) 
//	{return "Atef Page";}

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}

	@RequestMapping("/next")
	public String next(Map<String, Object> model) {
		model.put("message", "You are in new page !!");
		return "next";
	}

}
