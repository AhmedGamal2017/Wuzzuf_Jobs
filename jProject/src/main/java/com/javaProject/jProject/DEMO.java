package com.javaProject.jProject;

import static tech.tablesaw.aggregate.AggregateFunctions.count;

import org.apache.jasper.tagplugins.jstl.core.If;

import tech.tablesaw.api.Row;
import tech.tablesaw.api.Table;

public class DEMO {

	public static void main(String[] args) {

		Table df1 = DataFrameInstance.getInstance().getTable("src//main//resources//static//Wuzzuf_Jobs.csv");

		PrepareData d1 = new PrepareData();

//		System.out.println(d1.viewData(df1));
//		System.out.println(d1.summaryOfData(df1));
//		System.out.println(d1.structureOfData(df1));		
		Table df2 = d1.cleanData(df1);

//		for (Row row : d1.structureOfData(df1)) {
//			System.out.println(row.columnCount());
//			System.out.println(row.columnNames());
//			System.out.println(row.columnNames().get(0));
//			for (int i = 0; i < row.columnCount(); i++) {
//				System.out.print(row.columnNames().get(i));
//				System.out.print(row.getString(i));
//				System.out.print(row.getColumnType(row.columnNames().get(i)));
//			}
//			System.out.println();
//		}

		ManipulateData d2 = new ManipulateData();

//		System.out.println(d2.countCompanyJobs(df2));
//		System.out.println(d2.getMostPopular(df2, "Title"));
//		System.out.println(d2.getMostPopular(df2, "Location"));
//		System.out.println(d2.getMostPopularSkills(df2));
//		System.out.println(d2.factorizeYearsExp(df2));

		VisualizeData d3 = new VisualizeData();

//		d3.displayBarChart(df2, "Title");
//		d3.displayBarChart(df2, "Location");
//		d3.displayPieChart(df2);
//		System.out.println(d3.displayTable(df2));
		d3.displaySkillsBarChart(d2.getMostPopularSkills(df2));

	}

}
