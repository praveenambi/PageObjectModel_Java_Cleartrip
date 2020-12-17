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
		try {

			init_properties();
			boolean flag = false;
			double webTemp = 	weatherpage.getWeatherDetails();
			double apiTemp =  apiresponse.getWeatherAPI();

			if (apiTemp >webTemp -2 &&apiTemp<webTemp+2  ||  apiTemp== webTemp) {
				System.out.println("The temparature is in range of WebTemperature");
				flag=true;
				Assert.assertTrue(flag);

			}
			Assert.fail();
			throw new Exception("Temperature is not in tange");  // throwing a user defined exception with a exception message


		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	@AfterClass
	private void teardown() {

		closeAllbrowser();

	}


}
