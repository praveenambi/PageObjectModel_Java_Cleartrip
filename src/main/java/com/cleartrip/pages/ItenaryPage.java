package com.cleartrip.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cleartrip.base.BasePage;

public class ItenaryPage extends BasePage {

	@FindBy(xpath = "(//div[@data-test-attrib='onward-view']//img[@alt='Air India'])[1]")
	private WebElement airIndiaElement;

	@FindBy(xpath = "(//div[@data-test-attrib='onward-view']//img[@alt='IndiGo'])[1]")
	private WebElement indiGoElement;


	@FindBy(xpath = "//button[text()='Book']")
	private WebElement bookButtonElement;

	public ItenaryPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyTitle() {
		
		System.out.println(driver.getTitle());
		
		return driver.getTitle();
		
		
	}
	
	
	public ReviewIneraryPage bookItenary() {
		
		indiGoElement.click();
		airIndiaElement.click();
		bookButtonElement.click();
		
		return new ReviewIneraryPage();
		
		
		
		
	}



}
