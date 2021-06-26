package com.javaProject.jProject;

import java.util.ArrayList;
import java.util.List;

public class WuzzufJob {
	private String title, company, location, type, level, yearsExp, country;
	private String[] skills;
	
	/**
	 * WuzzufJob Constructor
	 * @param title
	 * @param company
	 * @param location
	 * @param type
	 * @param level
	 * @param yearsExp
	 * @param country
	 * @param skills
	 */
	public WuzzufJob(String title, String company, String location, String type, String level, String yearsExp,
			String country, String skills) {
		super();
		this.title = title;
		this.company = company;
		this.location = location;
		this.type = type;
		this.level = level;
		this.yearsExp = yearsExp;
		this.country = country;
		this.skills = extractSkills(skills);
	}
	
	/**
	 * getTitle
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * setTitle
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * getCompany
	 * @return company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * setCompany
	 * @param company
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * getLocation
	 * @return location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * setLocation
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * getType
	 * @return type
	 */
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getYearsExp() {
		return yearsExp;
	}

	public void setYearsExp(String yearsExp) {
		this.yearsExp = yearsExp;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = extractSkills(skills);
	}

	private String[] extractSkills(String skills) {
		return skills.toString().split(",");
	}

}
