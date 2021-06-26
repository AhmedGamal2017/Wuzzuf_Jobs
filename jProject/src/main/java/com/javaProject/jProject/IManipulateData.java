package com.javaProject.jProject;

import java.util.List;

import tech.tablesaw.api.Table;

public interface IManipulateData {
	public Table countCompanyJobs(Table data);
	public Table getMostPopular(Table data, String colName);
	public String[] countCompanyJobs(List<String[]> skills);
	public Table factorizeYearsExp(Table data);
}
