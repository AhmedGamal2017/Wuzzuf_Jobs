package com.javaProject.jProject;

import java.io.FileOutputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;
import org.apache.commons.csv.CSVFormat;

import smile.data.vector.StringVector;
import tech.tablesaw.api.Table;

//import org.apache.commons.csv.CSVFormat;

import smile.data.DataFrame;
import smile.data.measure.NominalScale;
import smile.data.vector.DoubleVector;
import smile.data.vector.IntVector;
import smile.data.vector.StringVector;
import smile.io.Read;

import tech.tablesaw.table.Relation;
import tech.tablesaw.table.TableSliceGroup;

import static tech.tablesaw.aggregate.AggregateFunctions.*;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.HorizontalBarPlot;
import tech.tablesaw.plotly.api.PiePlot;
import tech.tablesaw.plotly.api.ParetoPlot;
import tech.tablesaw.plotly.api.VerticalBarPlot;
import tech.tablesaw.plotly.components.Figure;
import tech.tablesaw.plotly.components.Layout;
import tech.tablesaw.plotly.traces.BarTrace;
import tech.tablesaw.api.DateColumn;
import tech.tablesaw.api.Row;
import tech.tablesaw.api.StringColumn;

public class WorkShop {

	public static void main(String[] args) throws IOException, Exception {

		Table df = Table.read().csv("src//main//resources//static//Wuzzuf_Jobs.csv");

		System.out.println(df.summary().print());

		// System.out.println(df.structure().printAll());

		// Table dfNoNull= df.dropRowsWithMissingValues();

		Table dfCleaned = df.dropRowsWithMissingValues().dropDuplicateRows();

		// System.out.println(dfCleaned.summary());

		////////////////////////////////////////////////////////

		List<List<String>> arr = new ArrayList<>();
		Table skills = dfCleaned.select("Skills");

		for (Row row : skills) {

			String[] str = row.toString().split(",");

			for (String j : str) {

				String[] str2 = j.toString().split(",");

				arr.add(Arrays.asList(str2));
			}
		}

		String str[] = new String[arr.size()];

		for (int j = 0; j < arr.size(); j++) {

			str[j] = arr.get(j).toString();
		}

		StringColumn column = StringColumn.create("Skills", str);

		Table t = Table.create("Skills", column);

		Table jobSkills = t.summarize("Skills", count).by("Skills").sortDescendingOn("Count [Skills]");

		// System.out.println(jobSkills);

		/*
		 * Plot.show( VerticalBarPlot.create( "Most required skills", // plot title
		 * jobSkills, // table "Skills", // grouping column name "Count [Skills]")); //
		 * numeric column name
		 */

		////////////////////////////////////////////////////////////

		Table companyJobs = dfCleaned.summarize("Title", count).by("Company").sortDescendingOn("Count [Title]");

		// System.out.println(companyJobs);

		// Plot.show(
		// PiePlot.create("Most demanding companies", companyJobs, "Company", "Count
		// [Title]"));

		/////////////////////////////////////////////

		Table jobTitles = dfCleaned.summarize("Title", count).by("Title").sortDescendingOn("Count [Title]");

		// System.out.println(jobTitles);

		/*
		 * Plot.show( VerticalBarPlot.create( "Most popular job titles", // plot title
		 * jobTitles, // table "Title", // grouping column name "Count [Title]")); //
		 * numeric column name
		 */

		///////////////////////////////////////////////////////

		Table areas = dfCleaned.summarize("Location", count).by("Location").sortDescendingOn("Count [Location]");

		// System.out.println(areas);

		/*
		 * Plot.show( VerticalBarPlot.create( "Most popular areas", // plot title areas,
		 * // table "Location", // grouping column name "Count [Location]")); // numeric
		 * column name
		 */

		///////////////////////////////////////////////////////

		CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader();

		DataFrame data = Read.csv("src/main/resources/static/Wuzzuf_Jobs.csv", format);

		DataFrame yearsOfExp = data.select("Level");

		DataFrame yearsOfExpNotNull = yearsOfExp.omitNullRows();

		StringVector exp = yearsOfExpNotNull.stringVector("Level");

		String[] values = exp.distinct().toArray(new String[] {});

		int[] labels = exp.factorize(new NominalScale(values)).toIntArray();

		data = data.merge(IntVector.of("Experience years", labels));

		System.out.println(data);

		////////////////////////////////////////////////////////////

	}

}
