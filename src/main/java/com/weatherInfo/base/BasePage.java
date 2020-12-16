/**
 * 
 */
package com.weatherInfo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author PRAAMBI
 * This is the Base class where ,
 * the driver initialize and configuration properties are defined
 *
 */
public class BasePage {



	public WebDriver driver;
	public Properties props;


	public WebDriver init_driver(String  browserName) {

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().version("86").setup();
			if (props.getProperty("headless").equals("yes")) {
				ChromeOptions options  = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			}
			else {
				driver= new ChromeDriver();
			}
		}

		if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		return driver;
	}


	public void launchURL(String URL) throws InterruptedException {

		driver.get(URL);
		driver.manage().window().maximize();

		Thread.sleep(8000);
	}

	public void closeAllbrowser() {

		driver.quit();

	}

	public Properties init_properties() {
		props = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream("C:\\Users\\PRAAMBI\\eclipse-workspace\\WeatherInfo_Test\\src\\main\\java\\com\\weatherInfo\\config\\config.properties");
			try {
				props.load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return props;


	}












}
