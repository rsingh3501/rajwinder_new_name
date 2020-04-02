package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.carreg.base.TestBase;
import com.qa.carreg.pages.SearchPage;
import com.qa.carreg.pages.RegistrationPage;
import com.qa.carreg.pages.HomePage;


public class HomePageTests extends TestBase{
	
	SearchPage SearchPage;
	RegistrationPage RegistrationPage;
	HomePage HomePage;
	
	
	public HomePageTests() {
		super();
	}	
		
	@BeforeMethod
	public void setup() {
		TestBase.initialization();
		HomePage= new HomePage();
	}
	
	
	@Test
	 public void validatePageTitleTest() {
		String title= HomePage.validatePageTitle();
		Assert.assertEquals(title, "[Sell Your Car!");
	}
	
	@Test
	public void validateHomePageIconTest() {
		boolean flag = HomePage.validateHomePageIcon();
		Assert.assertTrue(flag, "Icon is not displayed");
	}
	
	@Test
	public void validateNewBtnLinkTest() {
	
		RegistrationPage= HomePage.validateNewBtnLink();
		String actionURL= driver.getCurrentUrl();
		Assert.assertEquals(actionURL,prop.getProperty("RegistrationPageurl") );
		
	
	}
	
	@Test
	public void validateSearchBtnLinkTest() {
			SearchPage = HomePage.validatenSearchBtnLink();
			String actionURL= driver.getCurrentUrl();
			Assert.assertEquals(actionURL,prop.getProperty("SearchPageurl") );
			
	}
	
	
	
	
	
	
	

	@AfterMethod
	
		public void teardown() {
		driver.quit();
		
		}
	
		
	

	
	
	
	
	

}
