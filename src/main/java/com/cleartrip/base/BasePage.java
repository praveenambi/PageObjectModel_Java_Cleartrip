/**
 * 
 */
package com.cleartrip.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cleartrip.util.TestUtils;

import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author PRAAMBI
 * This is the Base class where ,
 * the driver initialize and configuration properties are defined
 *
 */
public class BasePage {



	public static WebDriver driver;
	public static Properties props;
	private static ThreadLocal<WebDriver> wbDriver = new ThreadLocal<WebDriver>();


	public BasePage() {

		props = new Properties();
		System.out.println("the current location of the project is " + System.getProperty("user.dir"));
		FileInputStream file;
		try {
			file = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/cleartrip/config/config.properties");
			try {
				props.load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


	}



	public static WebDriver getDriver() {
		return wbDriver.get();
	}



	public static void  init_driver() {
		String browsername = props.getProperty("browserName");

		if (browsername.equals("chrome")) {
			WebDriverManager.chromedriver().version("86").setup();
			if (props.getProperty("headless").equals("yes")) {
				ChromeOptions options  = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--disable-notifications");
				driver = new ChromeDriver(options);
			}
			else {
				driver= new ChromeDriver();
			}
		}

		if (browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(props.getProperty("URL"));
		
		
	}


	public void launchURL(String URL) throws InterruptedException {

		driver.get(URL);
		driver.manage().window().maximize();

		Thread.sleep(8000);
	}

	public void closeAllbrowser() {

		driver.quit();

	}








	



	public static void main(String[] args) {


	}






}
