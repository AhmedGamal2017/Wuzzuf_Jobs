package com.javaProject.jProject;


import tech.tablesaw.api.NumberColumn;
import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.Row;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.PiePlot;

import static tech.tablesaw.aggregate.AggregateFunctions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


  

public class Trial_class_dont_commit {

	public static void main(String[] args)  throws IOException, Exception{
		
		String path= "src//main//resources//static//Wuzzuf_Jobs.csv";
		Smile s= new Smile();
		s.cluster(path);
		
		
		DataFrameInstance df_i = DataFrameInstance.getInstance();
		Table df = df_i.getTable("src//main//resources//static//Wuzzuf_Jobs.csv");
		
		PrepareData d1 = new PrepareData();
//		System.out.println(d1.viewData(df1));
//		System.out.println(d1.summaryOfData(df1));
//		System.out.println(d1.structureOfData(df1));

		
		Table df2 = d1.cleanData(df);
//		System.out.println(d1.summaryOfData(df2));
		
		/*
		
		System.out.println(df2.write().toString().getClass());
		System.out.println(df2.toString());
		
		
		try {
		      FileWriter myWriter = new FileWriter("D:\\1-ITI-AI PRO\\Java\\LEC\\project\\filename.txt");
		      myWriter.write(df2.write().;
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }    
		 
		 
		 
		 
		 */

		ManipulateData d2 = new ManipulateData();
//		System.out.println(d2.countCompanyJobs(df2));
//		System.out.println(d2.getMostPopular(df2, "Title"));
//		System.out.println(d2.getMostPopular(df2, "Location"));
		
//		System.out.println(df2.column("Skills").asList());
		
//		try {
//		      FileWriter myWriter = new FileWriter("D:\\1-ITI-AI PRO\\Java\\LEC\\project\\filename.txt");
//		      myWriter.write(df2.column("Skills").asList().toString());
//		      myWriter.close();
//		      System.out.println("Successfully wrote to the file.");
//		    } catch (IOException e) {
//		      System.out.println("An error occurred.");
//		      e.printStackTrace();
//		    }
		
		
//		ArrayList<String> s1 = new ArrayList<String>();
//		s1.add("ssas");
//		s1 = (ArrayList<String>) df2.column("Skills").asList();
//		System.out.println(s1);
//		ArrayList<String> s2 = df2.column("Skills").asList();
//		System.out.println(s1.get(1));
		
		
//		System.out.println(df2.column("Skills").asList().getClass());
//		String[] a = new String[] {"sa", "la"};
//		StringColumn skillscolumn = StringColumn.create("newskills", s1);
//		System.out.println(skillscolumn.print());
		
//		String s1 = df2.column("Skills").asList().toString();
//		String s2 = s1.substring(1, s1.length()-1);
				
//		System.out.println(s1.charAt(1));
//		System.out.println(s1.charAt(s1.length() -2));
//		
//		System.out.println(s2.charAt(0));
//		System.out.println(s2.charAt(s2.length() -1));
		
//		String[] list_of_skills = s2.split(",");
//		StringColumn skillscolumn = StringColumn.create("kol el skills", list_of_skills);
//		Table Skills = Table.create("Skills mogam3a", skillscolumn);
//		System.out.println(Skills.first(10));
		
		
//		System.out.println(d2.getMostPopularSkills(df2));
		
		
		VisualizeData d3 = new VisualizeData();
//		d3.displayBarChart(df2, "Location");
//		d3.displayBarChart(df2, "Title");
//		d3.displayPieChart(df2);
//		System.out.println(d3.displayTable(df2));
		
		
//		Table t = df2.summarize("Title", count).by("Company").sortDescendingOn("Count [Title]");
		
//		NumberColumn Count = (NumberColumn) t.numberColumn("Count [Title]");
//		StringColumn Counts = (StringColumn) t.stringColumn("Company");
		
//		Table t2 = t.dropWhere(Count.isLessThan(11)) ;
//		Table t3 = t.dropWhere(Count.isGreaterThan(10)) ;
//		Table t4 = t.dropWhere(Counts.isEqualTo("Confidential")) ;
		
//		System.out.println(t);
//		System.out.println(t2.rowCount());
//		System.out.println(t.summarize("Count [Title]", sum).apply());
//		System.out.println(t2.summarize("Count [Title]", sum).apply());
//		System.out.println(t3.summarize("Count [Title]", sum).apply());
//		System.out.println(t3.summarize("Count [Title]", sum).apply().get(0, 0));
		
		
//		t2.appendRow();
//		System.out.println(t2.print());		
//		t2.stringColumn(0).set(22, "Other");		
//		t2.doubleColumn(1).set(22, 3405);
//		System.out.println(t2.print());
		
		
		
//		Table t5 = t4.dropWhere(Count.isLessThan(11)) ;
//		Table t6 = t4.dropWhere(Count.isGreaterThan(10)) ;
//		System.out.println(t6.rowCount());
//		t5.appendRow();
//		System.out.println(t5.print());	
//		System.out.println(t5.rowCount());
//		t5.stringColumn(0).set(22, "Other");
//		t5.doubleColumn(1).set(22, 3405);
//		System.out.println(t5.print());
		
//		Table t7 = t.dropWhere(Counts.isNotEqualTo("Confidential")) ;
//		System.out.println(t5.summarize("Count [Title]", sum).apply().get(0, 0));
//		System.out.println(t6.summarize("Count [Title]", sum).apply().get(0, 0));
//		t7.appendRow();
//		t7.appendRow();
//		t7.stringColumn(0).set(1, "Greater than 10 titles");
//		t7.stringColumn(0).set(2, "Less than 10 titles");
//		t7.doubleColumn(1).set(1, 392);
//		t7.doubleColumn(1).set(2, 3395);
//		System.out.println(t7);
		
//		Plot.show(PiePlot.create("All Companies", t7, "Company", "Count [Title]"));
//		Plot.show(PiePlot.create("Companies with Greater than 10 titles", t5, "Company", "Count [Title]"));
//		Plot.show(PiePlot.create("Companies with Less than 10 titles", t6, "Company", "Count [Title]"));
		
//		Methods2 t = new Methods2();
//		int[] factorize = new int[4380];
//		ArrayList<Integer> factorize = new ArrayList<>();		
//		
//		for (Row row : df2) { 
//		    String s = row.getString("YearsExp");	   		    
//		    factorize.add(t.extractMaximum(s)) ;
//		}
//		
//		Integer[] factorize_Array = new Integer[factorize.size()];
//		factorize.toArray(factorize_Array); 
//		
//		IntColumn  factorized_exp = IntColumn.create("Factorized Experience", factorize_Array);
//		df2.addColumns(factorized_exp);
//		System.out.println(df2);
		
	}

}









