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

	/**
	 * setType
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * getLevel
	 * @return level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * setLevel
	 * @param level
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * getYearsExp
	 * @return yearsExp
	 */
	public String getYearsExp() {
		return yearsExp;
	}

	/**
	 * setYearsExp
	 * @param yearsExp
	 */
	public void setYearsExp(String yearsExp) {
		this.yearsExp = yearsExp;
	}

	/**
	 * getCountry
	 * @return country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * setCountry
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * getSkills
	 * @return String[] skills
	 */
	public String[] getSkills() {
		return skills;
	}

	/**
	 * setSkills
	 * @param skills
	 */
	public void setSkills(String skills) {
		this.skills = extractSkills(skills);
	}

	/**
	 * extractSkills
	 * this private method convert skills string to 
	 * array of strings(skills)
	 * separated by ","
	 * @param skills
	 * @return String[] skills
	 */
	private String[] extractSkills(String skills) {
		return skills.split(",");
	}
	
	public String getSkillsS() {
		return String.join(", ", skills);
	}

}
