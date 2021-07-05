package com.javaProject.jProject;

import java.io.IOException;

import tech.tablesaw.api.Table;

public class DataFrameInstance {

	// create an object of SingleObject
	private static DataFrameInstance instance = new DataFrameInstance();

	// make the constructor private so that this class cannot be
	// instantiated
	private DataFrameInstance() {
	}

	// Get the only object available
	public static DataFrameInstance getInstance() {
		return instance;
	}

	public Table getTable(String csvFilePath) {
		try {
//			System.out.println(csvFilePath);
			return Table.read().csv(csvFilePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
