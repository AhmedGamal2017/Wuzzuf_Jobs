package com.javaProject.jProject;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;
import smile.math.matrix.DMatrix;
import tech.tablesaw.api.Table;

@RestController
@RequestMapping("")
public class RESTrouter {

	PrepareData dp = new PrepareData();
	ManipulateData dm = new ManipulateData();
	VisualizeData dv = new VisualizeData();
	
	@GetMapping(value = "/getallcomp")
	public Response getAllComp() {

		Table original = DataFrameInstance.getInstance().getTable("src//main//resources//static//Wuzzuf_Jobs.csv");
		Table cleaned = dp.cleanData(original);
		Table target = dv.displayPieChartWithoutConf(cleaned);
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("labels", target.stringColumn(0).asList());
		data.put("values", target.numberColumn(1).asList());

		Response response = new Response("Done", new JSONObject(data));
		
		return response;
	}
	
	@GetMapping(value = "/confcompchart")
	public Response getTrendCompChart() {

		Table original = DataFrameInstance.getInstance().getTable("src//main//resources//static//Wuzzuf_Jobs.csv");
		Table cleaned = dp.cleanData(original);
		Table target = dv.displayPieChartWithConf(cleaned);
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("labels", target.stringColumn(0).asList());
		data.put("values", target.numberColumn(1).asList());

		Response response = new Response("Done", new JSONObject(data));
		
		return response;
	}
	
	@GetMapping(value = "/trendjobchart")
	public Response getTrendJobChart() {
		
		Table original = DataFrameInstance.getInstance().getTable("src//main//resources//static//Wuzzuf_Jobs.csv");
		Table cleaned = dp.cleanData(original);
		Table target = dm.getMostPopular(cleaned, "Title");
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("labels", target.stringColumn(0).asList());
		data.put("values", target.numberColumn(1).asList());

		Response response = new Response("Done", new JSONObject(data));
		
		return response;
	}
	
	@GetMapping(value = "/trendareachart")
	public Response getTrendAreaChart() {
		
		Table original = DataFrameInstance.getInstance().getTable("src//main//resources//static//Wuzzuf_Jobs.csv");
		Table cleaned = dp.cleanData(original);
		Table target = dm.getMostPopular(cleaned, "Location");
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("labels", target.stringColumn(0).asList());
		data.put("values", target.numberColumn(1).asList());

		Response response = new Response("Done", new JSONObject(data));
		
		return response;
	}
	
	@GetMapping(value = "/trendskillchart")
	public Response getTrendSkillsChart() {
		
		Table original = DataFrameInstance.getInstance().getTable("src//main//resources//static//Wuzzuf_Jobs.csv");
		Table cleaned = dp.cleanData(original);
		Table target = dm.factorizeYearsExp(cleaned);
		
		Response response = new Response("Done", target);
		
		return response;
	}
	
}
