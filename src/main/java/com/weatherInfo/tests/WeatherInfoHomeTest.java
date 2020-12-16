package com.weatherInfo.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.weatherInfo.base.BasePage;
import com.weatherInfo.pages.WeatherAPIResponse;
import com.weatherInfo.pages.WethaerHomepage;

public class WeatherInfoHomeTest extends BasePage {

	public WethaerHomepage weatherpage ;
	public WeatherAPIResponse apiresponse;





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
		int webTemp = 	weatherpage.getWeatherDetails();
		int apiTemp =  apiresponse.getWeatherAPI();

		Assert.assertEquals(webTemp, apiTemp);


	}


	@AfterClass
	private void teardown() {

		closeAllbrowser();

	}


}
