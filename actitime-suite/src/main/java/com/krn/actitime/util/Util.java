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

}
