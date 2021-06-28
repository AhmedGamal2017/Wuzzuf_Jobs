package com.javaProject.jProject;

import tech.tablesaw.api.Table;

public interface IPrepareData {	
	public Table structureOfData(Table data);
	public Table summaryOfData(Table data);
	public Table cleanData(Table data);
	
	public String viewData(Table data);

}

