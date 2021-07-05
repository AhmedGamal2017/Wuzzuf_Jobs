package com.javaProject.jProject;

import static tech.tablesaw.aggregate.AggregateFunctions.count;

import java.util.ArrayList;
import java.util.List;

import tech.tablesaw.api.ColumnType;
import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.Row;

import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

public class ManipulateData implements IManipulateData {

	@Override
	public Table countCompanyJobs(Table data) {

		return data.summarize("Title", count).by("Company").sortDescendingOn("Count [Title]");
	}

	@Override
	public Table getMostPopular(Table data, String colName) {

		return data.summarize(colName, count).by(colName).sortDescendingOn("Count [" + colName + "]");
	}

	@Override
	public Table getMostPopularSkills(Table data) {

		String string_allskills = data.column("Skills").asList().toString();
		String string_allskills_cleaned = string_allskills.substring(1, string_allskills.length() - 1);
		String[] array_of_skills = string_allskills_cleaned.split(",");
		StringColumn skills_column = StringColumn.create("Skills", array_of_skills);
		Table skills_table = Table.create("Skills mogam3a", skills_column);

		return skills_table.summarize("Skills", count).by("Skills").sortDescendingOn("Count [Skills]");
	}

	private int extractMaximum(String str) {

		int num = 0, res = 0;

		// Start traversing the given string
		for (int i = 0; i < str.length(); i++) {
			// If a numeric value comes, start converting
			// it into an integer till there are consecutive
			// numeric digits
			if (Character.isDigit(str.charAt(i)))
				num = num * 10 + (str.charAt(i) - '0');

			// Update maximum value
			else if (str.charAt(i) == '+') {
				num++;
			}

			else {
				res = Math.max(res, num);

				// Reset the number
				num = 0;
			}
		}

		// Return maximum value
		int max = Math.max(res, num);

		if (max <= 2) {
			return 0;
		} else if (max <= 5) {
			return 1;
		} else if (max <= 10) {
			return 2;
		} else {
			return 3;
		}

	}

	@Override
	public Table factorizeYearsExp(Table data) {

		ArrayList<Integer> factorize = new ArrayList<>();

		for (Row row : data) {
			String s = row.getString("YearsExp");
			factorize.add(extractMaximum(s));
		}

		Integer[] factorize_Array = new Integer[factorize.size()];
		factorize.toArray(factorize_Array);

		IntColumn factorized_exp = IntColumn.create("Factorized Experience", factorize_Array);

		return data.addColumns(factorized_exp);

	}

	@Override
	public List<WuzzufJob> convertTable2List(Table data) {
		// TODO
		List<WuzzufJob> jobs = new ArrayList<WuzzufJob>();
		for (Row row : data) {
			jobs.add(new WuzzufJob(row.getString(0), row.getString(1), row.getString(2), row.getString(3),
					row.getString(4), row.getString(5), row.getString(6), row.getString(7)));
		}
		return jobs;
	}

	@Override
	public List<List<String>> convertTable2StringList(Table data) {
		// TODO
		List<List<String>> list = new ArrayList<List<String>>();
		for (Row row : data) {
			List<String> line = new ArrayList<String>();
			for (int i = 0; i < row.columnCount(); i++) {
				if (row.getColumnType(row.columnNames().get(i)) == ColumnType.INTEGER) {
					line.add(Integer.toString(row.getInt(i)));
				} else if (row.getColumnType(row.columnNames().get(i)) == ColumnType.DOUBLE) {
					line.add(Double.toString(row.getDouble(i)));
				} else {
					line.add(row.getString(i));
				}
			}
			list.add(line);
		}
		return list;
	}

	@Override
	public List<String> getTableHeads(Table data) {
		// TODO
		List<String> heads = new ArrayList<String>();
		for (Row row : data) {
			heads = row.columnNames();
			break;
		}
		return heads;
	}

}
