package com.employee.model;

public class EmployeeAddress {
	private String villageName;
	private String city;
	private String state;
	private String country;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	@Override
	public String toString() {
		return "EmployeeAddress [villageName=" + villageName + ", city=" + city + ", state=" + state + ", country="
				+ country + "]";
	}

}
