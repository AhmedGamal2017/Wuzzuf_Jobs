package com.javaProject.jProject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Router {

	@RequestMapping("/gamal")
	public String gamal(
			/* "send  parameter" @RequestParam(value = "test", defaultValue = "non") String val */ ) 
	{return "Gamal Page";}
	
	@RequestMapping("/mady")
	public String mady(
			/* "send  parameter" @RequestParam(value = "test", defaultValue = "non") String val */ ) 
	{return "Mady Page";}
	
	@RequestMapping("/atef")
	public String atef(
			/* "send  parameter" @RequestParam(value = "test", defaultValue = "non") String val */ ) 
	{return "Atef Page";}
	
}
