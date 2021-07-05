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

	private List<String> listHeads = new ArrayList<String>();
	private List<List<String>> list = new ArrayList<List<String>>();
	
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		Table df1 = DataFrameInstance.getInstance().getTable("src//main//resources//static//Wuzzuf_Jobs.csv");
		PrepareData d1 = new PrepareData();
		Table df2 = d1.cleanData(df1);
		ManipulateData d2 = new ManipulateData();

		jobs = d2.convertTable2List(df1);

		model.put("jobs", jobs);
		return "index";
	}

	@RequestMapping("/original")
	public String original(Map<String, Object> model) {
		Table df1 = DataFrameInstance.getInstance().getTable("src//main//resources//static//Wuzzuf_Jobs.csv");
		ManipulateData dm = new ManipulateData();

		jobs = dm.convertTable2List(df1);

		model.put("jobs", jobs);
		return "original";
	}
	
	@RequestMapping("/cleaned")
	public String cleaned(Map<String, Object> model) {
		Table df1 = DataFrameInstance.getInstance().getTable("src//main//resources//static//Wuzzuf_Jobs.csv");
		PrepareData d1 = new PrepareData();
		
		Table df2 = d1.cleanData(df1);
		ManipulateData d2 = new ManipulateData();

		jobs = d2.convertTable2List(df2);

		model.put("jobs", jobs);
		return "cleaned";
	}
	
	
	@RequestMapping("/summary")
	public String summary(Map<String, Object> model) {
		Table df1 = DataFrameInstance.getInstance().getTable("src//main//resources//static//Wuzzuf_Jobs.csv");
		PrepareData d1 = new PrepareData();
		Table df2 = d1.summaryOfData(df1);
		ManipulateData d2 = new ManipulateData();

		listHeads.clear();
		listHeads = d2.getTableHeads(df2);
		
		list.clear();
		list = d2.convertTable2StringList(df2);

		model.put("dataHeads", listHeads);
		model.put("data", list);
		
		return "summary";
	}

	@RequestMapping("/structure")
	public String structure(Map<String, Object> model) {
		Table df1 = DataFrameInstance.getInstance().getTable("src//main//resources//static//Wuzzuf_Jobs.csv");
		PrepareData d1 = new PrepareData();
		Table df2 = d1.structureOfData(df1);
		ManipulateData d2 = new ManipulateData();

		listHeads.clear();
		listHeads = d2.getTableHeads(df2);
		
		list.clear();
		list = d2.convertTable2StringList(df2);
//
		model.put("dataHeads", listHeads);
		model.put("data", list);
		return "structure";
	}
	
	@RequestMapping("/piechart")
	public String piechart(Map<String, Object> model) {
		
		return "pieChart";
	}
	
	@RequestMapping("/barchart")
	public String barchart(Map<String, Object> model) {
		
		return "barChart";
	}
}
