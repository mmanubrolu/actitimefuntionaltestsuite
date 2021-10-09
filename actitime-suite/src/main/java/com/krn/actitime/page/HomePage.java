package com.krn.actitime.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.krn.actitime.testbase.TestBase;
import com.krn.actitime.util.Util;

public class HomePage extends TestBase{
	
	// page repositories
	@FindBy(id="logo_aT")
	WebElement logo;
	
	@FindBy(id="logoutLink")
	WebElement logOut;
	
	@FindBy(xpath="//a[@class='userProfileLink username ']")
	WebElement userName;
	
	@FindBy(xpath="//div[@id='container_tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath="//div[@id='container_reports']")
	WebElement reportsLink;
	
	@FindBy(xpath="//div[@id='container_users']")
	WebElement usersLink;
	
	//constructor
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//methods
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean isLogoDisplayed() throws InterruptedException {
		return logo.isDisplayed();
	}
	
	public boolean isLogoutLinkDisplayed() throws InterruptedException {
		return logOut.isDisplayed();
	}
	
	public String getUserName() {
		return userName.getText();
	}
	
	public TaskPage clickOnTasksLink() throws InterruptedException {
		
		Thread.sleep(6000);
		Util.moveToElement(driver, tasksLink);
		Thread.sleep(6000);

		return new TaskPage();
	}
	
	
	public ReportPage clickOnReportsLink() throws InterruptedException {
		Thread.sleep(6000);
		Util.moveToElement(driver, reportsLink);
		Thread.sleep(6000);
		
		return new ReportPage();
	}
	
	public UserPage clickOnUserLink() throws InterruptedException {
		Thread.sleep(6000);
		Util.moveToElement(driver, usersLink);
		Thread.sleep(6000);
		
		return new UserPage();
	}
	
	public void clickOnLogoutLink() throws InterruptedException {
		Thread.sleep(6000);
		Util.moveToElement(driver, logOut);
		Thread.sleep(6000);
	}
	
}
