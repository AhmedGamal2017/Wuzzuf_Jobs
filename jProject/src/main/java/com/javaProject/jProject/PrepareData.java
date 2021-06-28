package com.javaProject.jProject;

import tech.tablesaw.api.Table;

public class PrepareData implements IPrepareData {

	@Override
	public Table structureOfData(Table data) {
		  
		return data.structure();
	}

	@Override
	public String viewData(Table data) {
		
		return data.print();		
		
	}
	
	@Override
	public Table summaryOfData(Table data) {
		
		return data.summary();		
		
	}

	@Override
	public Table cleanData(Table data) {
		 
		return data.dropRowsWithMissingValues().dropDuplicateRows();
	}


}
