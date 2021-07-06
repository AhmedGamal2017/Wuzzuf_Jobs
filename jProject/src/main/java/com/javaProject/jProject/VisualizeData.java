package com.javaProject.jProject;

import static tech.tablesaw.aggregate.AggregateFunctions.count;

import tech.tablesaw.api.NumberColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

import tech.tablesaw.plotly.Plot;

import tech.tablesaw.plotly.api.PiePlot;
import tech.tablesaw.plotly.api.VerticalBarPlot;




public class VisualizeData implements IVisualizeData {

	@Override
	public String displayTable(Table data) {
		
		return data.printAll();
		
	}

	@Override
	public void displayPieChart(Table data) {		
		
		Table t = data.summarize("Title", count).by("Company").sortDescendingOn("Count [Title]");		
		NumberColumn Count = (NumberColumn) t.numberColumn("Count [Title]");
		StringColumn Counts = (StringColumn) t.stringColumn("Company");
		
		Table t4 = t.dropWhere(Counts.isEqualTo("Confidential")) ;
		Table t5 = t4.dropWhere(Count.isLessThan(11)) ;
		Table t6 = t4.dropWhere(Count.isGreaterThan(10)) ;
		
		Table t7 = t.dropWhere(Counts.isNotEqualTo("Confidential")) ;
		t7.appendRow();
		t7.appendRow();
		t7.stringColumn(0).set(1, "Greater than 10 titles");
		t7.stringColumn(0).set(2, "Less than 10 titles");
		t7.doubleColumn(1).set(1, 392);
		t7.doubleColumn(1).set(2, 3395);
		
		Plot.show(PiePlot.create("All Companies", t7, "Company", "Count [Title]"));
		Plot.show(PiePlot.create("Companies with Greater than 10 titles", t5, "Company", "Count [Title]"));

	}

	@Override
	public void displayBarChart(Table data, String colName) {
		
		Table t = data.summarize(colName, count).by(colName).sortDescendingOn("Count ["+colName+"]");
				
		Plot.show(
		        VerticalBarPlot.create(
		            "Most Popular "+colName+"s", // plot title
		            t, // table
		            colName, // grouping column name
		            "Count ["+colName+"]")); // numeric column name
		

	}

	@Override
	public Table displayPieChartWithConf(Table data) {
		
		Table t = data.summarize("Title", count).by("Company").sortDescendingOn("Count [Title]");		
		NumberColumn Count = (NumberColumn) t.numberColumn("Count [Title]");
		StringColumn Counts = (StringColumn) t.stringColumn("Company");
		
		Table t4 = t.dropWhere(Counts.isEqualTo("Confidential")) ;
		Table t5 = t4.dropWhere(Count.isLessThan(11)) ;
		Table t6 = t4.dropWhere(Count.isGreaterThan(10)) ;
		
		return t5;
	}

	@Override
	public Table displayPieChartWithoutConf(Table data) {

		Table t = data.summarize("Title", count).by("Company").sortDescendingOn("Count [Title]");		
		NumberColumn Count = (NumberColumn) t.numberColumn("Count [Title]");
		StringColumn Counts = (StringColumn) t.stringColumn("Company");
		
		Table t7 = t.dropWhere(Counts.isNotEqualTo("Confidential")) ;
		t7.appendRow();
		t7.appendRow();
		t7.stringColumn(0).set(1, "Greater than 10 titles");
		t7.stringColumn(0).set(2, "Less than 10 titles");
		t7.doubleColumn(1).set(1, 392);
		t7.doubleColumn(1).set(2, 3395);
		
		return t7;
	}
	
	

}
