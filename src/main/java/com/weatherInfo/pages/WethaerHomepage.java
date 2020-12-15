/**
 * 
 */
package com.weatherInfo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author PRAAMBI
 *
 */
public class WethaerHomepage {
	
	int timeout = 10;
	
	
	@FindBy(xpath = "//input[@id='searchBox']")
	private WebElement homeSearchCityElement;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void waitForElement(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
	}

}
