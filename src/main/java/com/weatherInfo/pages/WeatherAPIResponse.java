/**
 * 
 */
package com.weatherInfo.pages;

import static io.restassured.RestAssured.given;

import java.util.Properties;

import com.weatherInfo.base.BasePage;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

/**
 * @author PRAAMBI
 *
 */
public class WeatherAPIResponse {
	
	public Properties props;
	public BasePage basepage;
	
	
	public int getWeatherAPI() {
		
		
		/*
		 * System.setProperty("javax.net.ssl.trustStore", "C:/.keystore");
		 * System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
		 */
		basepage.init_properties();
		RestAssured.baseURI= props.getProperty("BaseURI");
		String response = 	given().log().all().header("Content-Type","application/json").
				queryParam("q", props.getProperty("city")).
				queryParam("appid", props.getProperty("key")).
				queryParam("units", props.getProperty("unit"))
				.when().get("data/2.5/weather")
				.then().log().all().assertThat().statusCode(200).header("charset", "UTF-8").extract().response().asString();


		System.out.println(response);

		JsonPath json = new JsonPath(response);  // parsing the String response to Json
		String temp = json.getString(".main.temp");
		System.out.println(temp);
		
		int tempurature = Integer.parseInt(temp);
		
		return tempurature;
		
		
		
	}
	
	
	
	
	
	
	
	

}
