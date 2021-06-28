package com.javaProject.jProject;

import tech.tablesaw.api.Table;

public class DEMO {

	public static void main(String[] args) {		
		
		Table df1 = DataFrameInstance.getInstance().getTable("src//main//resources//static//Wuzzuf_Jobs.csv");
		
		PrepareData d1 = new PrepareData();
		
//		System.out.println(d1.viewData(df1));
//		System.out.println(d1.summaryOfData(df1));
//		System.out.println(d1.structureOfData(df1));		
		Table df2 = d1.cleanData(df1);
		
		
		ManipulateData d2 = new ManipulateData();
		
//		System.out.println(d2.countCompanyJobs(df2));
//		System.out.println(d2.getMostPopular(df2, "Title"));
//		System.out.println(d2.getMostPopular(df2, "Location"));
//		System.out.println(d2.getMostPopularSkills(df2));
		
		
		VisualizeData d3 = new VisualizeData();
		
//		d3.displayBarChart(df2, "Title");
//		d3.displayBarChart(df2, "Location");
//		d3.displayPieChart(df2);

	}

}
