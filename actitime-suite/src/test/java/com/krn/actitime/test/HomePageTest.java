package com.krn.actitime.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.krn.actitime.page.HomePage;
import com.krn.actitime.page.LoginPage;
import com.krn.actitime.page.ReportPage;
import com.krn.actitime.page.TaskPage;
import com.krn.actitime.page.UserPage;
import com.krn.actitime.testbase.TestBase;
import com.krn.actitime.util.Util;

public class HomePageTest extends TestBase {
	public LoginPage loginPage;
	public HomePage homePage;
	public TaskPage taskPage;
	public UserPage userPage;
	public ReportPage reportPage;
	public Util util;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initilization();
		loginPage = new LoginPage();
		util = new Util();
		try {
			homePage = loginPage.clickOnLoginButton(util.getUserName(), util.getPassword());
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
	@Test(priority=3)
	public void validateTaskLinkTest() throws InterruptedException {
		taskPage = homePage.clickOnTasksLink();
	}
	
	@Test(priority=4)
	public void validateReportLinkTest() throws InterruptedException {
		reportPage = homePage.clickOnReportsLink();
	}
	
	
	@Test(priority=5)
	public void validateUserLinkTest() throws InterruptedException {
		userPage = homePage.clickOnUserLink();
	}
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		homePage.clickOnLogoutLink();
		driver.quit();
	}
}
