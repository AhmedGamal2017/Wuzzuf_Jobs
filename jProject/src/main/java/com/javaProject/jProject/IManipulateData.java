package com.javaProject.jProject;

import java.util.List;

import tech.tablesaw.api.Table;

public interface IManipulateData {
	public Table countCompanyJobs(Table data);
	public Table getMostPopular(Table data, String colName);
	public Table getMostPopularSkills(Table data);
	public Table factorizeYearsExp(Table data);
	
	public List<WuzzufJob> convertTable2List(Table data);
}
