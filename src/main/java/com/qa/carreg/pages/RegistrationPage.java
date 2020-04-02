package com.qa.carreg.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.carreg.base.TestBase;

public class RegistrationPage  extends TestBase{
	
	
//	
//	@FindBy(xpath="//input[@name='firstname']")
//	WebElement sellername;
//	
//
//	@FindBy(xpath="//textarea[@name='address']")
//	WebElement address ;
//	
//	@FindBy(xpath="//input[@name='city']")
//	WebElement  city;
//	
//
//	@FindBy(xpath="//input[@name='number']")
//	WebElement number ;
//
//	@FindBy(xpath="//input[@name='email']")
//	WebElement email;
//
//	@FindBy(xpath="//input[@name='Vehiclemake']")
//	WebElement vehiclemake ;
//
//	@FindBy(xpath="//input[@name='Model']")
//	WebElement model;
//
//	@FindBy(xpath="//input[@name='Year']")
//	WebElement year ;
//	
//	@FindBy(xpath="//div[@class='main2']//descendant::input[@type=\"submit\"]")
//	WebElement submitBtn ;
	
	List<WebElement> data = driver.findElements(By.cssSelector("#table1 tr td :last-child"));
			

	
	
	
	@FindBy(xpath="//div[@class='main2']//descendant::p[@id=\"message\"]")
	WebElement message ;
	
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	//actions
	

    public String validatePageTitle() {
    String title = driver.getTitle();
    return title;
     }
    
    
    public DisplayPage newRegistration(List<String> all) {
//    	sellername.sendKeys(name);
//    	address.sendKeys(adrs);
//    	city.sendKeys(cit);
//    	number.sendKeys(num);
//    	email.sendKeys(mail);
//    	vehiclemake.sendKeys(vhlmake);
//    	model.sendKeys(mod);
//    	System.out.println(mod);
//    	year.sendKeys(yr);
////    	Integer.toString(Math.round(Float.valueOf(yr)))
//    	System.out.println(yr);
//    	submitBtn.click();
    	for(int i=0;i<8;i++) {
    		data.get(i).sendKeys(all.get(i));
    	}
    	data.get(8).click();
    	
    	    	return  new DisplayPage();
    
    
    
    }
    
    public String messageDisplayed() {
      return message.getText();
    	
    }
     
	
	
	
	
	
	
}
	