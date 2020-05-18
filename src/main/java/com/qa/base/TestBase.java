package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		// to load config.property file and load values from it
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\User\\Desktop\\eclipse"
					+ "\\TFTonlineStore\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(ip);
		}
		
		// to catch FileNotFoundException
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browser_name = prop.getProperty("browser");
		
		if (browser_name.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		// for cross browser testing
		else if (browser_name.equals("FF")) {
			System.setProperty("", "");
			driver = new FirefoxDriver();
		}
		else if (browser_name.equals("IE")) {
			System.setProperty("", "");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("url"));
		
	}	
}



