package com.krn.actitime.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.krn.actitime.page.HomePage;
import com.krn.actitime.page.LoginPage;
import com.krn.actitime.testbase.TestBase;

public class LoginPageTest extends TestBase {
	public LoginPage loginPage;
	public HomePage homePage;
	
	LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initilization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void titleValidateTest(){
		String title = loginPage.getTitle();
		Assert.assertEquals(title, "actiTIME - Login", "Title was not matched in login page");
		
	}
	@Test(priority=2)
	public void logoDisplayTest() throws InterruptedException {
		boolean logoDisplayed = loginPage.isLogoDisplayed();
		Assert.assertTrue(logoDisplayed, "Logo was not displayed");
	}
	
	@Test(priority=3) 
	public void urlValidateTest() {
		String url =loginPage.getUrl();
		Assert.assertEquals(url, "https://demo.actitime.com/login.do", "url was not matched in login page");
	}
	
	@Test(priority=4)
	public void loginTest() throws InterruptedException {
		homePage= loginPage.clickOnLoginButton(prop.getProperty("userName"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
