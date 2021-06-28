package com.javaProject.jProject;

import tech.tablesaw.api.Table;

public interface IManipulateData {
	public Table countCompanyJobs(Table data);
	public Table getMostPopular(Table data, String colName);
	public Table getMostPopularSkills(Table data);
	public Table factorizeYearsExp(Table data);
}
