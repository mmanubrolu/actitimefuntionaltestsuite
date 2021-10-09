package com.krn.actitime.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.krn.actitime.page.HomePage;
import com.krn.actitime.page.LoginPage;
import com.krn.actitime.page.TaskPage;
import com.krn.actitime.page.UserPage;
import com.krn.actitime.testbase.TestBase;

public class HomePageTest extends TestBase {
	public LoginPage loginPage;
	public HomePage homePage;
	public TaskPage taskPage;
	public UserPage userPage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initilization();
		loginPage = new LoginPage();
		try {
			homePage = loginPage.clickOnLoginButton(prop.getProperty("userName"), prop.getProperty("password"));
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	@Test(priority=1)
	public void validiateTitleTest() {
		String title = homePage.getTitle();
		Assert.assertEquals(title, "actiTIME - Enter Time-Track", "Home page title was not matched");
	}
	
	@Test(priority=2)
	public void validateUrlTest() {
		String url= homePage.getUrl();
		Assert.assertEquals(url, "https://demo.actitime.com/user/submit_tt.do", "Home page url was not matched");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
