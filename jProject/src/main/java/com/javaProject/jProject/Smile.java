package com.javaProject.jProject;

import static tech.tablesaw.aggregate.AggregateFunctions.count;

import java.io.IOException;

import org.apache.commons.csv.CSVFormat;

import smile.data.DataFrame;
import smile.data.measure.NominalScale;
import smile.data.vector.DoubleVector;
import smile.data.vector.StringVector;
import smile.io.Read;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.*;
import tech.tablesaw.plotly.api.ScatterPlot;


public class Smile {
	
	
	public void cluster(String path)  throws IOException, Exception{		
		
		
		CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader();
		
		   
		DataFrame data = Read.csv(path,format) ;
		
		//System.out.println(data);
		
		 DataFrame titleColumn= data.select("Title");
         DataFrame companyColumn = data.select("Company");
         
         DataFrame titleNotNull = titleColumn.omitNullRows();
        DataFrame companyNotNull = companyColumn.omitNullRows();
         
         StringVector title = titleNotNull.stringVector("Title");
        StringVector company =  companyNotNull.stringVector("Company");
         
       String[] titles = title.distinct().toArray(new String[]{});
       
       String[] companies = company.distinct().toArray(new String[]{});

         
       double[] titleLabels = title.factorize(new NominalScale(titles)).toDoubleArray(); 
       
      double[] companyLabels = company.factorize(new NominalScale(companies)).toDoubleArray();
       
       
      
      
      
       data=data.merge(DoubleVector.of("Title_labels", titleLabels));
       data=data.merge(DoubleVector.of("company_labels", companyLabels));
       

       DoubleColumn column1 = DoubleColumn.create("Titles",titleLabels);
       DoubleColumn column2 = DoubleColumn.create("Companies",companyLabels);
       StringColumn column3 = StringColumn.create("Company",company.toStringArray());
        String[] C= company.toStringArray();
       
       
       Table df = Table.read().csv(path);
       
       Table dfCleaned   = df.dropRowsWithMissingValues().dropDuplicateRows();
       Table companyJobs = dfCleaned.summarize("Title", count).by("Company").sortDescendingOn("Count [Title]");

		//System.out.println(companyJobs.inRange(10));
		
		        Table t = Table.create();
				t.addColumns(column1);
				t.addColumns(column2);
				t.addColumns(column3);
				
				int[] s= new int[t.rowCount()];
				
				for(int i = 0; i < t.rowCount(); i++) {
					
					if(C[i]=="Confidential") {
						
					s[i]= 11000;
					}
					else if(C[i]=="Mishkat Nour")	{
						
						s[i]= 10000;
						
				}    
					else if(C[i]=="Expand Cart")	{
						
						s[i]= 9000;
						
				}    
					else if(C[i]=="EGIC")	{
	
						s[i]= 8000;
	
					}    
					else if(C[i]=="Aqarmap.com")	{
	
						s[i]= 7000;
	
}    
					else if(C[i]=="Majorel Egypt")	{
	
						s[i]= 6000;
	
}    
					else if(C[i]=="Ghassan Ahmed Alsulaiman for Electronic Services")	{
	
						s[i]= 5000;
	
}    
					else if(C[i]=="Flairstech")	{
	
						s[i]= 4000;
	
}    
					else if(C[i]=="Profolio Consulting")	{
	
						s[i]= 3000;
	
}    
					else if(C[i]=="OPPO Egypt")	{
	
						s[i]= 2000;
	
}    
				
			
	 
					else {
					
						s[i]= 10;
				}
					
}


				IntColumn column4 = IntColumn.create("size", s);
				t.addColumns(column4);
				
	//	System.out.println(t);
				
				/*Plot.show(
						ScatterPlot.create("Titles and companies", 
					                       t, "Titles", "Companies"));*/
		
	//	Plot.show(
		//		BubblePlot.create("The company vs title", "Titles", titleLabels, "Companies", companyLabels));
				
				
				
				Table W= t.inRange(100);
				
				
	Plot.show(
	BubblePlot.create("Bubble", W, "Titles", "Companies", "size", "Company"));	
				
				
						
				
				
				
				
}
}