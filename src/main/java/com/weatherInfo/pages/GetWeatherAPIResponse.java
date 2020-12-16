/**
 * 
 */
package com.weatherInfo.pages;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

/**
 * @author PRAAMBI
 *
 */
public class GetWeatherAPIResponse {
	
	
	public void getWeatherAPI() {
		
		
		/*
		 * System.setProperty("javax.net.ssl.trustStore", "C:/.keystore");
		 * System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
		 */
		
		
		
		RestAssured.baseURI= "https://api.openweathermap.org";
		String response = 	given().log().all().header("Content-Type","application/json").
				queryParam("q", "bengaluru").
				queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea").
				queryParam("units", "metric")
				.when().get("data/2.5/weather")
				.then().log().all().assertThat().statusCode(200).header("charset", "UTF-8").extract().response().asString();




		System.out.println(response);

		JsonPath json = new JsonPath(response);  // parsing the String response to Json
		String job = json.getString("job");

		System.out.println(job);
		
	}
	
	
	
	
	
	
	
	

}
