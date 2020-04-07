package testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;
import com.qa.carreg.base.PagesCall;
import com.qa.carreg.base.TestBase;
import com.qa.carreg.pages.HomePage;
import com.qa.carreg.pages.RegistrationPage;
import com.qa.carreg.util.TestUtil;
import com.qa.carreg.pages.DisplayPage;

public class RegistrationPageTests extends TestBase {

  RegistrationPage RegistrationPage;
	

	public RegistrationPageTests() {
		// super();
	}
    
	@BeforeMethod
	public void setup() {
		initialization();
		
		HomePage=new HomePage();
		RegistrationPage = HomePage.validateNewBtnLink();
		
		

	}

	@DataProvider
	public Object[][] getNTestData() {
		Object data[][] = TestUtil.getTestData("NegativeCases");
		return data;
	}

	@DataProvider
	public Object[][] getPTestData() {
		Object data[][] = TestUtil.getTestData("PositiveCases");

		return data;
	}

//	@Test(dataProvider = "getNTestData", groups="Negative Cases")
//	public void validateNewregistrationNegativeCases(Object data[]) {
//		List<String> all = new LinkedList<String>();
//		for (int i = 0; i < 8; i++) {
//			all.add(i, data[i].toString());
//			
//		}
//
//		DisplayPage = RegistrationPage.newRegistration(all);
//		Assert.assertEquals(RegistrationPage.messageDisplayed(),data[8].toString());
//
//	}

	@Test(dataProvider = "getPTestData", groups = "Positive Cases")
	public void validateNewregistrationPositiveCases(Object data[]) throws MalformedURLException, IOException {
List<String> all = new LinkedList<String>();
for (int i = 0; i < 8; i++) {
	all.add(i, data[i].toString());
	
}
		DisplayPage = RegistrationPage.newRegistration(all);
		String actionURL = driver.getCurrentUrl();

		List<String> datatext = DisplayPage.validinputdata();

		boolean flag1 = true;
		for (int i = 0; i < 8; i++) {
			if (all.get(i).equals(datatext.get(i)))
				flag1 = true;
			else
				flag1 = false;

		}
		String message =DisplayPage.validcarLink();
     System.out.println(message); 
		Assert.assertTrue(actionURL.equals(prop.getProperty("DisplayPageurl")) && flag1 == true && message.equals("OK"));

	}

	@AfterMethod

	public void teardown() {

		driver.quit();
	}
}
