package com.ibm.apitesting;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import  io.restassured.RestAssured;

public class TestApi {
	
	@Test
	public void getWeatherDetails() {
		RestAssured.given().baseUri("https://demoqa.com/utilities/weather/city").
		header("Content-Type","application/json").log().all().
		pathParam("cityName","Kolkata").
		when().get("/{cityName}").
		then().log().all().statusCode(200).body("City",equalTo("Kolkata"));
		
	}

	
}
