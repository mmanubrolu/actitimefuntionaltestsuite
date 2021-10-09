package com.krn.actitime.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.krn.actitime.testbase.TestBase;
import com.krn.actitime.util.Util;

public class TaskPage extends TestBase {

	@FindBy(xpath = "//div[text()='Add New']")
	WebElement addNewLink;

	@FindBy(xpath = "//div[text()='+ New Customer']")
	WebElement addCustomer;

	@FindBy(xpath = "//input[@placeholder='Enter Customer Name' and @autocomplete='off']")
	WebElement customerName;

	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	WebElement description;

	@FindBy(xpath = "//div[text()='- Select Customer -' and @class='emptySelection']")
	WebElement selectProject;

	@FindBy(xpath = "//div[text()='Create Customer']")
	WebElement createCustomerButton;
	
	@FindBy(xpath="(//div[text()='Big Bang Company'])[2]")
	WebElement bigBangProject;

	@FindBy(xpath = "//div[@class='customersProjectsPanel']//input[@placeholder='Start typing name ...']")
	WebElement searchBar;
	
	public TaskPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddNewLink() {
		try {
			Thread.sleep(6000);
			Util.moveToElement(driver, addNewLink);
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void clickOnAddCustomerLink() {
		try {
			Thread.sleep(6000);
			Util.moveToElement(driver, addCustomer);
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void setCustomerName(String customerName) {
		this.customerName.sendKeys(customerName);
	}

	public void setDescription(String description) {
		this.description.sendKeys(description);
	}

	public void selectProject() {
		selectProject.click();
		bigBangProject.click();
		
		/*Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).build();
		actions.sendKeys(Keys.ENTER).build().perform();*/
	}
	
	public void clickOnCreateCustomerButton() {
		try {
			Thread.sleep(6000);
			Util.moveToElement(driver, createCustomerButton);
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void searchCustomerNameForDelete(WebDriver driver1, String custName) {
		searchBar.sendKeys(custName);
		driver.findElement(By.xpath("//div[@class='itemsContainer']//div[text()='"+customerName+"']")).click();
		WebElement result = driver.findElement(By.xpath("//div[text()='Mallikarjuna']"));
		Actions actions = new Actions(driver1);
		actions.moveToElement(result).build().perform();
		WebElement editElement = driver1.findElement(By.xpath("//div[text()='Mallikarjuna']/../..//div[@class='editButton']"));
		Util.moveToElement(driver1, editElement);
	}
}
