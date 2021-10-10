package com.krn.actitime.test;

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

public class UserPageTest extends TestBase{
	public LoginPage loginPage;
	public HomePage homePage;
	public TaskPage taskPage;
	public UserPage userPage;
	public ReportPage reportPage;
	public Util util;
	
	
	public UserPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initilization();
		loginPage = new LoginPage();
		util = new Util();
		try {
			homePage = loginPage.clickOnLoginButton(util.getUserName(), util.getPassword());
			userPage =homePage.clickOnUserLink();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test(priority=1)
	public void createUserTest() {
		try {
			userPage.createUser(util.getUserFirstName(), util.getUserMiddleName(), util.getUserLastName(), util.getUserEmail());
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test(priority=2)
	public void deleteUserTest() {
		try {
			userPage.deleteUser();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown() {
		try {
			homePage.clickOnLogoutLink();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
