package com.javaProject.jProject;

import static tech.tablesaw.aggregate.AggregateFunctions.count;

import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

public class ManipulateData implements IManipulateData {

	@Override
	public Table countCompanyJobs(Table data) {
		
		return data.summarize("Title", count).by("Company").sortDescendingOn("Count [Title]");
	}

	@Override
	public Table getMostPopular(Table data, String colName) {
		
		return data.summarize(colName, count).by(colName).sortDescendingOn("Count ["+colName+"]");
	}

	@Override
	public Table getMostPopularSkills(Table data) {
		
		String string_allskills = data.column("Skills").asList().toString();
		String string_allskills_cleaned = string_allskills.substring(1, string_allskills.length()-1);	
		String[] array_of_skills = string_allskills_cleaned.split(",");
		StringColumn skills_column = StringColumn.create("Skills", array_of_skills);
		Table skills_table = Table.create("Skills mogam3a", skills_column);
		
		return skills_table.summarize("Skills", count).by("Skills").sortDescendingOn("Count [Skills]");
	}

	@Override
	public Table factorizeYearsExp(Table data) {
		// TODO 
		return null;
	}

}
