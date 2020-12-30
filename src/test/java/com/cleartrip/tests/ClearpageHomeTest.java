package com.cleartrip.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cleartrip.base.BasePage;
import com.cleartrip.pages.ClearTripHomepage;
import com.cleartrip.pages.CleartripAPIResponse;
import com.cleartrip.pages.ItenaryPage;
import com.cleartrip.pages.CleartripAPIResponse;
import com.cleartrip.pages.ClearTripHomepage;;

public class ClearpageHomeTest extends BasePage {

	public ClearTripHomepage clearPage ;
	public CleartripAPIResponse apiresponse;
	public ItenaryPage itenaery; 


	
	
	public  ClearpageHomeTest() {
		super();
		
	}

	@BeforeMethod
	public void setup() {
		init_driver();
		clearPage = new ClearTripHomepage();
		
	}


	@Test
	private void searchFlightTest() {
		try {
			String pagetitle =clearPage.validateHomePageTitle();
			itenaery = clearPage.serachItenary();
			Assert.assertEquals(pagetitle, "#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	/*
	 * @AfterMethod private void teardown() {
	 * 
	 * closeAllbrowser();
	 * 
	 * }
	 */


}
