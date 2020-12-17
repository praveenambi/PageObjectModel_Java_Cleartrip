/**
 * 
 */
package com.weatherInfo.pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.weatherInfo.base.BasePage;

/**
 * @author PRAAMBI
 *
 */
public class WethaerHomepage {

	int timeout = 10;
	double temperature;

	public static WebDriver driver;
	public Properties props;
	public BasePage basepage= new BasePage();


	@FindBy(xpath = "//input[@id='searchBox']")
	private WebElement homeSearchCityElement;


	@FindBy(xpath = "//label[@for='Bengaluru']")
	private WebElement CityElement;

	@FindBy(xpath = "//div[@class='cityText' and text()='Bengaluru']")
	private WebElement MapCityElement;

	//div[@class='leaflet-popup-content']/div/span


	@FindBy(xpath = "//div[@class='leaflet-popup-content']")
	private WebElement WeatheerDetailsElements;



	public double getWeatherDetails() {
		basepage.init_properties();
		waitForElement(driver , homeSearchCityElement);
		homeSearchCityElement.sendKeys(props.getProperty("city"));
		waitForElement(driver , CityElement);
		CityElement.click();
		waitForElement(driver , MapCityElement);
		MapCityElement.click();
		waitForElement(driver , WeatheerDetailsElements);
		List<WebElement> weatherDetails = WeatheerDetailsElements.findElements(By.tagName("b"));

		for (WebElement webElement : weatherDetails) {
			if (webElement.getText().contains("Degrees")) {
				String	tempdegree =	webElement.getText();
				String degrrearr[] = 	tempdegree.split(":");
				System.out.println(degrrearr[1]);
				temperature = 	Double.parseDouble(degrrearr[1]);

			}
		}
		return temperature;

	}

	public void waitForElement(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
	}

}


//api.openweathermap.org/data/2.5/weather?q=bengaluru&appid=7fe67bf08c80ded756e598d6f8fedaea