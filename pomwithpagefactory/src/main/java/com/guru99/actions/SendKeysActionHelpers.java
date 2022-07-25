package com.guru99.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendKeysActionHelpers {
	/**
	 * Method to Enter Value using sendkeys.
	 * @param driver
	 * @param location
	 * @param InputValue
	 */
	public void sendkeys(WebDriver driver,WebElement location,String InputValue) {
		try {
			location.sendKeys(InputValue);
		}
		catch(Exception e) {
			System.out.println("Excetion Occured" + e);
		}
	}
	/**
	 * Method to Enter Value using clear and sendkeys.
	 * @param driver
	 * @param location
	 * @param InputValue
	 */
	public void clearandsendkeys(WebDriver driver,WebElement location,String InputValue) {
		try {
			location.clear();
			location.sendKeys(InputValue);
		}
		catch(Exception e) {
			System.out.println("Excetion Occured" + e);
		}
	}
	/**
	 * Method to Enter Value using sendkeys in JS by ElementID.
	 * @param driver
	 * @param elementId
	 * @param text
	 * @throws Exception
	 */
	public void sendKeysJsById(WebDriver driver, String elementId, String text) throws Exception {
		try { 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('"+elementId+"').value='"+text+"';");
		}catch(Exception e) {
			throw new Exception("sendKeysByJs (SendKeysActionHelper) "+e.getMessage());
		}
	}
}
