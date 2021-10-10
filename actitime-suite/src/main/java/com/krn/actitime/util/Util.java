package com.krn.actitime.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.krn.actitime.testbase.TestBase;

public class Util extends TestBase{
	public static int PAGE_LOAD_TIMEOUT=30;
	public static int IMPLICIT_LOAD_TIMEOUT=30;
	
	
	public static void moveToElement(WebDriver driver, WebElement element) {
		Actions actions= new Actions(driver);
		actions.moveToElement(element).build().perform();
		element.click();
	}
	
	public  String getUserName() {
		return prop.getProperty("userName");
	}
	
	public  String getPassword() {
		return prop.getProperty("password");
	}

	
	public  String getCustomerName() {
		return "Mallikarjuna";
	}
	
	public  String getCustomerDescription() {
		return "Mallikarjuna as customer during creation";
	}
	
	
	public String getUserFirstName() {
		return "Mallikarjuna";
	}

	public String getUserMiddleName() {
		return "Rao";
	}
	
	public String getUserLastName() {
		return "Manubrolu";
	}
	
	public String getUserEmail() {
		return "mmanubrolu@gmail.com";
	}
}
