package com.javaProject.jProject;

import tech.tablesaw.api.Table;

public interface IVisualizeData {
	public String displayTable(Table data);
	public void displayPieChart(Table data);	
	public void displayBarChart(Table data, String colName);
	
	public Table displayPieChartWithConf(Table data);
	public Table displayPieChartWithoutConf(Table data);
}
