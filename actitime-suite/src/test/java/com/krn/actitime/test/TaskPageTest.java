package com.krn.actitime.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import com.krn.actitime.page.HomePage;
import com.krn.actitime.page.LoginPage;
import com.krn.actitime.page.ReportPage;
import com.krn.actitime.page.TaskPage;
import com.krn.actitime.page.UserPage;
import com.krn.actitime.testbase.TestBase;
import com.krn.actitime.util.Util;

public class TaskPageTest extends TestBase {
	public LoginPage loginPage;
	public HomePage homePage;
	public TaskPage taskPage;
	public UserPage userPage;
	public ReportPage reportPage;
	public Util util;
	
	
	public TaskPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initilization();
		loginPage = new LoginPage();
		util = new Util();
		try {
			homePage = loginPage.clickOnLoginButton(util.getUserName(), util.getPassword());
			taskPage =homePage.clickOnTasksLink();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test(priority=1)
	public void creatCustomerTest() {
		
		taskPage.clickOnAddNewLink();
		taskPage.clickOnAddCustomerLink();
		taskPage.setCustomerName(util.getCustomerName());
		taskPage.setDescription(util.getCustomerDescription());
		
		//taskPage.selectProject();
		
		taskPage.clickOnCreateCustomerButton();	  
	}
	
	@Test(priority=2)
	public void deleteCustomerTest() throws InterruptedException {
		//taskPage.searchCustomerNameForDelete(driver,util.getCustomerName());
		String customerName = util.getCustomerName();
		WebElement deleteElement = driver.findElement(By.xpath("//div[@class='itemsContainer']//div[text()='"+customerName+"']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", deleteElement);
		boolean isDelementDisplayed = deleteElement.isDisplayed();
		if (isDelementDisplayed) {
			System.out.println("inside isDelementDisplayed");
			deleteElement.click();
			Thread.sleep(10000);
			
			WebElement deleteItem = driver.findElement(By.xpath("//div[text()='Mallikarjuna' and @title='Mallikarjuna']/..//div[@class='editButton']"));
			//Util.moveToElement(driver, deleteItem);
			Thread.sleep(10000);
			Actions actions = new Actions(driver);
			actions.moveToElement(deleteItem).build().perform();
			
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[text()='Mallikarjuna' and @title='Mallikarjuna']/..//div[@class='editButton']")).click();
			Thread.sleep(6000);
			
			Thread.sleep(10000);
			driver.findElement(By.xpath("//div[@class='editCustomerPanelHeader']//div[text()='ACTIONS']")).click();
			Thread.sleep(10000);
			
			Thread.sleep(6000);
			driver.findElement(By.xpath("//div[@class='taskManagement_customerPanel']//div[text()='Delete']")).click();
			Thread.sleep(6000);
			
			Thread.sleep(6000);
			driver.findElement(By.xpath("//span[text()='Delete permanently']")).click();
			Thread.sleep(6000);
			
			
		}else {
			System.out.println("inside isDelementDisplayed else block");
			Assert.assertFalse(!isDelementDisplayed, "Proposed delete element is not displayed");
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
