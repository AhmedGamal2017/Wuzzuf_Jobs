package com.javaProject.jProject;

public class ChartData {
	private Object[] labels;
	private Object[] values;

	public ChartData(Object[] labels, Object[] values) {
		super();
		this.labels = labels;
		this.values = values;
	}

	public Object[] getLabels() {
		return labels;
	}

	public void setLabels(Object[] labels) {
		this.labels = labels;
	}

	public Object[] getValues() {
		return values;
	}

	public void setValues(Object[] values) {
		this.values = values;
	}
}
