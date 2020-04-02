package com.qa.carreg.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.yaml.snakeyaml.Yaml;

import com.qa.carreg.pages.HomePage;
import com.qa.carreg.util.WebEventListener;



public class TestBase {
	public static Yaml yaml = new Yaml();
	public static Properties prop;	
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;
	
	
	
	
	

	public TestBase(){
		
		
	
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"F:\\java tutorials\\Xampp.Carreg\\src\\main\\java\\com\\qa\\carreg\\config\\configuration.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
		
	


	public static void initialization() {
		if(prop.getProperty("browser").equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\chrodriver.exe");
			driver = new ChromeDriver();
		}	else if(prop.getProperty("browser").equals("chrome")){
			
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		

			driver = new FirefoxDriver();
			System.out.println("Browser is FireFox");
		} else {
			System.out.println("No Browser");
		}
		
		e_driver = new EventFiringWebDriver(driver);
	
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
		
		

	}

			

}
