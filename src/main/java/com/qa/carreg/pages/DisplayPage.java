package com.qa.carreg.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.carreg.base.TestBase;

public class DisplayPage extends TestBase {
	static List<String> datatext =new LinkedList<String>();
	
	

	
	  List<WebElement> data= driver.findElements(By.xpath("//table[@id='table2']//tr//td[2]"));
	  List<WebElement> data2 = driver.findElements(By.cssSelector("div#sec1 a"));

	  
		  
	
	
	public DisplayPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public List<String> validinputdata() {
	
		for(int i=0;i<8;i++) {
	 datatext.add(i,data.get(i).getText());
	//System.out.println(datatext.get(i));
		}return datatext;
		
	}
	
	public String validcarLink() throws MalformedURLException, IOException {
		HttpURLConnection Connection =   (HttpURLConnection) new URL(data2.get(0).getAttribute("href")).openConnection();
		Connection.connect();
		String message = 		Connection.getResponseMessage();
		Connection.disconnect();
		return message;
		
	}
	
	
	
}
