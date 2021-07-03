package com.javaProject.jProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tech.tablesaw.api.Table;

@Controller
public class Router {

//	@Value("${welcome.message:message}")
	private String message = "Hello World";

//	@Value("${welcome.jobs:jobs}")
	private List<WuzzufJob> jobs = new ArrayList<WuzzufJob>();

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		Table df1 = DataFrameInstance.getInstance().getTable("src//main//resources//static//Wuzzuf_Jobs.csv");
		PrepareData d1 = new PrepareData();
		Table df2 = d1.cleanData(df1);
		ManipulateData d2 = new ManipulateData();

		jobs = d2.convertTable2List(df1);

		model.put("jobs", jobs);
		return "welcome";
	}

	@RequestMapping("/next")
	public String next(Map<String, Object> model) {
		Table df1 = DataFrameInstance.getInstance().getTable("src//main//resources//static//Wuzzuf_Jobs.csv");
		PrepareData d1 = new PrepareData();
		Table df2 = d1.cleanData(df1);
		ManipulateData d2 = new ManipulateData();

		jobs = d2.convertTable2List(df1);

		model.put("jobs", jobs);
		return "index";
	}

}
