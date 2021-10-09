package com.krn.actitime.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.krn.actitime.testbase.TestBase;

public class LoginPage extends TestBase {
	
	// page repository or object
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(name="pwd")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login ']")
	WebElement loginButton;
	
	@FindBy(xpath="//div[@class='atLogoImg']")
	WebElement logo;
	
	@FindBy(id="keepLoggedInCheckBox")
	WebElement keepLoginCheckBox;
	
	@FindBy(id="toPasswordRecoveryPageLink")
	WebElement forgotPasswordLink;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean isLogoDisplayed() throws InterruptedException {
		return logo.isDisplayed();
	}
	
	public boolean isRememberCheckBoxEnabled() {
		return keepLoginCheckBox.isEnabled();
	}
	
	public boolean isforgotPasswordLinkDisplayed() {
		return forgotPasswordLink.isDisplayed();
	}
	
	public HomePage clickOnLoginButton(String userName, String password) throws InterruptedException {
		this.userName.sendKeys(userName);
		this.password.sendKeys(password);
		loginButton.click();
		Thread.sleep(20000);
		
		return new HomePage();
	}
}
