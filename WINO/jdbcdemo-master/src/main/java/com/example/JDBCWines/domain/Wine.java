package com.example.JDBCWines.domain;

public class Wine {
	
	private long id;
	
	private String winename;
	private String tastename;
	private double cost;
	private String year;
	
	public Wine() {
	}
	
	public Wine(String winename, String tastename, double cost, String year) {
		super();
		this.winename = winename;
		this.tastename = tastename;
		this.cost = cost;
		this.year = year;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getWinename() {
		return winename;
	}
	public void setWinename(String winename) {
		this.winename = winename;
	}
	public String getTastename() {
		return tastename;
	}
	public void setTastename(String tastename) {
		this.tastename = tastename;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
}
