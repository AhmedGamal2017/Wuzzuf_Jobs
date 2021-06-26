package com.javaProject.jProject;

import tech.tablesaw.api.Table;

public interface IPrepareData {	
	public String structureOfData(Table data);
	public String summaryOfData(Table data);
	public Table cleanTableFromNull(Table data);
	public Table cleanTableFromDublication(Table data);
}
