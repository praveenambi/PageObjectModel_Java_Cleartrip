/**
 * 
 */
package com.cleartrip.pages;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cleartrip.base.BasePage;

import groovyjarjarantlr4.v4.parse.ANTLRParser.throwsSpec_return;

/**
 * @author PRAAMBI
 *
 */
public class ClearTripHomepage extends BasePage{

	int timeout = 10;
	double temperature;

	public Properties props;
	public BasePage basepage= new BasePage();


	public  ClearTripHomepage() {

		PageFactory.initElements(driver, this);


	}

	/*******************************************************************************/

	@FindBy(xpath = "//a[@href='/flights' and contains(@title,'Find flights from and to international')]")
	private WebElement flightsElement;

	@FindBy(xpath = "//input[@id='RoundTrip']")
	private WebElement roundtripElement;

	@FindBy(xpath = "//input[@etitle='From']")
	private WebElement sourceplaceElement;

	@FindBy(xpath = "//input[@name='destination']")
	private WebElement destinationElement;

	@FindBy(xpath = "//input[@title='Return date']")
	private WebElement returnDateElement;

	@FindBy(xpath = "//input[@title='Depart date']")
	private WebElement startDateElement;

	@FindBy(xpath = "//input[@id='SearchBtn']")
	private WebElement searchElement;

	@FindBy(xpath = "//a[contains(text(),'New Delhi, IN - Indira Gandhi Airport (DEL)')]")
	private WebElement destElement;

	@FindBy(xpath = "//a[contains(text(),'Bangalore, IN - Kempegowda International Airport (BLR)')]")
	private WebElement sourceElement;

	@FindBy(xpath = "//input[@title='Depart date']")
	private WebElement depDateElement;

	@FindBy(xpath = "//input[@id='ReturnDate']")
	private WebElement retDateElement;

	@FindBy(xpath = "//div[@class='ctDatePicker']//span[@class='ui-datepicker-month']")  // //span[@class='ui-datepicker-month']
	private static WebElement seldepdaymonthElement;

	@FindBy(xpath = "//div[@class='monthBlock first']//td[@data-handler='selectDay']")  // //td[@data-handler='selectDay']
	private static WebElement seldepdayElement;
	
	@FindBy(xpath = "//input[@id='SearchBtn']")
	private WebElement searchButtonElement;
	
	

	// Actions


	public String validateHomePageTitle() {

		return driver.getTitle();

	}

	public ItenaryPage serachItenary() throws InterruptedException {
		flightsElement.click();
		roundtripElement.click();
		sourceplaceElement.sendKeys("bengaluru");
		waitForElement(driver , sourceElement);
		sourceElement.click();
		waitForElement(driver , destinationElement);
		destinationElement.sendKeys("Delhi");
		waitForElement(driver , destElement);
		destElement.click();
		waitForElement(driver , depDateElement);
		depDateElement.click();
		selectDesireddate(2,"//div[@class='monthBlock last']//td[@data-handler='selectDay']");
		retDateElement.click();
		selectDesireddate(7,"//div[@class='monthBlock first']//td[@data-handler='selectDay']");
		searchButtonElement.click();
		return new ItenaryPage();

		//return temperature;

	}
	////div[@class='monthBlock last']//td[@data-handler='selectDay']


	public  static void selectDesireddate(int travelday,String dayLocator) throws InterruptedException {
		List<WebElement> calMonths = driver.findElements(By.xpath("//div[@class='ctDatePicker']//span[@class='ui-datepicker-month']"));
		String[] mydepdate = getCalendarInstance(travelday);
		System.out.println("mydepdate[1]     " + mydepdate[1]);
		System.out.println("mydepdate[0] " + mydepdate[0]);
		for (WebElement webEle : calMonths) {
			System.out.println("webEle.getText()" + webEle.getText());
			if (webEle.getText().equalsIgnoreCase(mydepdate[1])) {
				System.out.println("8955484856215454*//////****************5545454");
				List<WebElement> activedaysfirst = driver.findElements(By.xpath(dayLocator));
				for (WebElement day : activedaysfirst) {
					System.out.println("datyooooo" + day.getText() );
					if (day.getText().equalsIgnoreCase(mydepdate[0])) {
						System.out.println("calendar day " + day.getText() + "mydepdate[0] " + mydepdate[0]);
						day.click();
						break;

					}
				}

			}

		}

	}



	public static  String[] getCalendarInstance(int days) {

		SimpleDateFormat formatter = new SimpleDateFormat("d/MMMMM/yyyy");  
		Calendar calobject = 	Calendar.getInstance();
		calobject.setTime(new Date());
		calobject.add(Calendar.DATE, days);
		String mydepDate = formatter.format(calobject.getTime());
		String[] depdatearr = mydepDate.split("/");
		System.out.println("Desired departure date is " + mydepDate);
		System.out.println("Desired departure date in string is " + depdatearr[0] );
		System.out.println("Desired departure date in string is " + depdatearr[1] );

		return depdatearr;

	}

	public void waitForElement(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
	}

}////div[@data-test-attrib='onward-view']//img[@alt='IndiGo']


//api.openweathermap.org/data/2.5/weather?q=bengaluru&appid=7fe67bf08c80ded756e598d6f8fedaea