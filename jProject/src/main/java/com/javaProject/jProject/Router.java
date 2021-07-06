package com.javaProject.jProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import tech.tablesaw.api.Table;

@Controller
public class Router {

//	@Value("${welcome.message:message}")
	private String message = "Hello World";

//	@Value("${welcome.jobs:jobs}")
	private List<WuzzufJob> jobs = new ArrayList<WuzzufJob>();
	
	PrepareData dp = new PrepareData();
	ManipulateData dm = new ManipulateData();
	VisualizeData dv = new VisualizeData();

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
		Table original = DataFrameInstance.getInstance().getTable("src//main//resources//static//Wuzzuf_Jobs.csv");

		Table structure = dp.structureOfData(original);
		Table summary = dp.summaryOfData(original);

		jobs = dm.convertTable2List(original);

		model.put("DataStructure", dm.convertTable2StringList(structure));
		model.put("StructureHeads", dm.getTableHeads(structure));
		model.put("DataSummary", dm.convertTable2StringList(summary));
		model.put("SummaryHeads", dm.getTableHeads(summary));

		model.put("jobs", jobs);
		return "original";
	}

	@RequestMapping("/cleaned")
	public String cleaned(Map<String, Object> model) {
		Table original = DataFrameInstance.getInstance().getTable("src//main//resources//static//Wuzzuf_Jobs.csv");

		Table cleaned = dp.cleanData(original);
		Table structure = dp.structureOfData(cleaned);
		Table summary = dp.summaryOfData(cleaned);

		jobs = dm.convertTable2List(cleaned);

		model.put("DataStructure", dm.convertTable2StringList(structure));
		model.put("StructureHeads", dm.getTableHeads(structure));
		model.put("DataSummary", dm.convertTable2StringList(summary));
		model.put("SummaryHeads", dm.getTableHeads(summary));

		model.put("jobs", jobs);
		return "cleaned";
	}

	@RequestMapping("/summary")
	public String summary(Map<String, Object> model) {
		Table df1 = DataFrameInstance.getInstance().getTable("src//main//resources//static//Wuzzuf_Jobs.csv");
		Table df2 = dp.summaryOfData(df1);

		model.put("dataHeads", dm.getTableHeads(df2));
		model.put("data", dm.convertTable2StringList(df2));

		return "summary";
	}

	@RequestMapping("/structure")
	public String structure(Map<String, Object> model) {
		Table df1 = DataFrameInstance.getInstance().getTable("src//main//resources//static//Wuzzuf_Jobs.csv");
		Table df2 = dp.structureOfData(df1);

		model.put("dataHeads", dm.getTableHeads(df2));
		model.put("data", dm.convertTable2StringList(df2));
		
		return "structure";
	}

	@RequestMapping("/factorization")
	public String factorize(Map<String, Object> model) {
		Table original = DataFrameInstance.getInstance().getTable("src//main//resources//static//Wuzzuf_Jobs.csv");
		Table cleaned = dp.cleanData(original);
		Table target = dm.factorizeYearsExp(cleaned);

		model.put("dataHeads", dm.getTableHeads(target));
		model.put("data", dm.convertTable2StringList(target));

		return "factorize";
	}

	@RequestMapping("/piechart")
	public String piechart(Map<String, Object> model) {

		return "pieChart";
	}

	@RequestMapping("/barchart")
	public String barchart(Map<String, Object> model) {

		Table original = DataFrameInstance.getInstance().getTable("src//main//resources//static//Wuzzuf_Jobs.csv");

		Table cleaned = dp.cleanData(original);

		Table mostPupular = dm.getMostPopular(cleaned, "Title"); 
		
		model.put("lables", dm.convertTable2StringList(mostPupular).get(0));
		model.put("values", dm.convertTable2StringList(mostPupular).get(1));
		
		return "barChart";
	}

	@RequestMapping("/trendcomp")
	public String trendingCompanies(Map<String, Object> model) {

		Table original = DataFrameInstance.getInstance().getTable("src//main//resources//static//Wuzzuf_Jobs.csv");
		Table cleaned = dp.cleanData(original);
		Table target = dm.countCompanyJobs(cleaned);
		
		model.put("dataHeads", dm.getTableHeads(target));
		model.put("data", dm.convertTable2StringList(target));
		
		return "comp";
	}

	@RequestMapping("/trendjob")
	public String trendingJobs(Map<String, Object> model) {

		Table original = DataFrameInstance.getInstance().getTable("src//main//resources//static//Wuzzuf_Jobs.csv");
		Table cleaned = dp.cleanData(original);
		Table target = dm.getMostPopular(cleaned, "Title");
		
		model.put("dataHeads", dm.getTableHeads(target));
		model.put("data", dm.convertTable2StringList(target));
		
		return "jobs";
	}
	
	@RequestMapping("/trendarea")
	public String trendingAreas(Map<String, Object> model) {

		Table original = DataFrameInstance.getInstance().getTable("src//main//resources//static//Wuzzuf_Jobs.csv");
		Table cleaned = dp.cleanData(original);
		Table target = dm.getMostPopular(cleaned, "Location");
		
		model.put("dataHeads", dm.getTableHeads(target));
		model.put("data", dm.convertTable2StringList(target));
		
		return "area";
	}
	
	@RequestMapping("/trendskill")
	public String trendingSkills(Map<String, Object> model) {

		Table original = DataFrameInstance.getInstance().getTable("src//main//resources//static//Wuzzuf_Jobs.csv");
		Table cleaned = dp.cleanData(original);
		Table target = dm.getMostPopularSkills(cleaned);
		
		model.put("dataHeads", dm.getTableHeads(target));
		model.put("data", dm.convertTable2StringList(target));
		
		return "skills";
	}

}
