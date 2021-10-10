package com.krn.actitime.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.krn.actitime.testbase.TestBase;

public class UserPage extends TestBase {
	
	//page repository
	@FindBy(xpath="//div[text()='New User']")
	WebElement newUserButton;
	
	@FindBy(xpath="//input[@id='createUserPanel_firstNameField']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='createUserPanel_middleNameField']")
	WebElement middleName;
	
	@FindBy(xpath="//input[@id='createUserPanel_lastNameField']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='createUserPanel_emailField']")
	WebElement email;
	
	@FindBy(xpath="//div[@class='simpleListMenuButton components_userGroupSelectorMenu emptyList notEmpty']//div[text()='-- department not assigned --']")
	WebElement selectProductDropDown;
	
	@FindBy(xpath="//div[text()='Production' and @class='item']")
	WebElement selectProduct;
	
	@FindBy(xpath="(//td[@class='x-btn-right'])[4]")
	WebElement calander;
	
	@FindBy(xpath="//a[@title='Next Month (Control+Right)']")
	WebElement nextMonthButton;
	
	@FindBy(xpath="//span[text()='21']")
	WebElement selectDate;
	
	@FindBy(xpath="//div[text()='Save & Send Invitation']")
	WebElement sendInvitation;
	
	@FindBy(xpath="//div[@class='invitationDialog ui-dialog-content ui-widget-content']/..//span[text()='OK']")
	WebElement okButton;
	
	@FindBy(xpath="//div[@class='panelContent']//span[text()='Close']")
	WebElement closeButton;
	
	
	@FindBy(xpath="//table[@class='userNameContainer']//span[text()='Manubrolu, Mallikarjuna Rao.']")
	WebElement deleteUser;
	
	@FindBy(xpath="//div[text()='DELETE']")
	WebElement deleteButton;
	
	public UserPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createUser(String firstName, String middleName, String lastName, String email) throws InterruptedException {
		
		newUserButton.click();
		Thread.sleep(8000);
		
		this.firstName.sendKeys(firstName);
		this.middleName.sendKeys(middleName);
		this.lastName.sendKeys(lastName);
		this.email.sendKeys(email);
		
		selectProductDropDown.click();
		selectProduct.click();
		
		calander.click();
		nextMonthButton.click();
		selectDate.click();
		
		sendInvitation.click();
		Thread.sleep(8000);
		
		okButton.click();
		Thread.sleep(8000);
		
		closeButton.click();
		Thread.sleep(8000);
	}
	
	public void deleteUser() throws InterruptedException {
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", deleteUser);
		deleteUser.click();
		Thread.sleep(10000);
		
		deleteButton.click();
		Thread.sleep(10000);
		
		driver.switchTo().alert().accept();
		
	}
}
