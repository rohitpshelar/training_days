package com.javatpoint;

public class Address {
private String city;
private String state;
private String country;

public Address(String city, String state, String country) {
	super();
	this.city = city;
	this.state = state;
	this.country = country;
}

@Override
public String toString() {
	return " {\n\t \"Address\" : { \n\t\t\"city \" : \"" + city + "\",\n\t\t\"state \" : \"" + state
			+ "\",\n\t\t\"country \" : \"" + country + "\" \n}\n}";
}




}
