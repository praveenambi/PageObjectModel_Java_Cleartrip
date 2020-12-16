package com.weatherInfo.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.weatherInfo.base.BasePage;
import com.weatherInfo.pages.WethaerHomepage;

public class WeatherInfoHomeTest extends BasePage {
	
	public WethaerHomepage weatherpage ;
	
	
	
	
	@BeforeClass
	public void LaunchSetup() {

		
		weatherpage = new WethaerHomepage();
		init_properties();
		init_driver("chrome");
		try {
			launchURL(props.getProperty("URL"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	private void getCityWeatherdetails() {
		
		init_properties();
		weatherpage.getWeatherDetails();

	}
	
	
	@AfterClass
	private void teardown() {
		
		closeAllbrowser();

	}
	
	
}
