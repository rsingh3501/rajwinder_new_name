package com.qa.carreg.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.carreg.base.TestBase;

public class HomePage extends TestBase{
	
	//PageFactory
	@FindBy(xpath="//h1[contains(text(),'Sell your car!')]")
	private WebElement homePageIcon;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	private WebElement newBtnLink;
	
	@FindBy(xpath="//button[contains(text(),'Search')]")
	private WebElement searchBtnLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	

	//Actions
	
    public String validatePageTitle() {
    String title = driver.getTitle();
    return title;
     }
    
    
	public boolean validateHomePageIcon() {
		
		return homePageIcon.isDisplayed();
	
	}
	
	
	public RegistrationPage validateNewBtnLink() {
		
		newBtnLink.click();
	    return new 	 RegistrationPage();
	    }
	
	  public SearchPage validatenSearchBtnLink() {
		  searchBtnLink.click();  
	    return new SearchPage();
		  
	    }
	
	
	
	
	
	
	

}
