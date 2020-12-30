package com.cleartrip.tests;

import org.testng.annotations.Test;

import com.cleartrip.base.BasePage;
import com.cleartrip.pages.ItenaryPage;

public class ItenaryTest extends BasePage{
	
	public ItenaryPage itenary;
	
	
	
	public ItenaryTest() {
		
		super();
		
	}
	
	@Test
	private void bookticketTest() {
		
		itenary =  new ItenaryPage();
		itenary.bookItenary();
		
		

	}
	
	

}
