package com.guru99.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickActionHelpers {

	public void rightClick(WebDriver driver, WebElement element) throws Exception
	{
		try {
			Actions act=new Actions(driver);
			act.moveToElement(element).contextClick().build().perform();
		}
		catch(Exception e) {
			throw new Exception("rightClick (ClickActionHelper) : "+e.getMessage());
		}
	}
	public void doubleClick(WebDriver driver, WebElement element) throws Exception{
		try {
			Actions act =new Actions(driver);
			act.moveToElement(element).contextClick().build().perform();
		}
		catch(Exception e) {
			throw new Exception("doubleClick (ClickActionHelper) : "+e.getMessage());
		}
	}
	public void clickOnXandY(WebDriver driver,WebElement element) throws Exception {
		try {
			Actions act=new Actions(driver);
			act.moveToElement(element).contextClick().build().perform();
		}
		catch(Exception e){
			throw new Exception("clickOnXandY (ClickActionHelper) : "+e.getMessage());			
		}
	}
	public void clickUsingJS(WebDriver driver, WebElement element) throws Exception {
		try {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}
		catch(Exception e) {
			throw new Exception("clickUsingJs (ClickActionHeper) : "+e.getMessage());
		}
	}
}
//Actions act; 
//public void mouseClick(WebDriver driver , WebElement element)
//{
//	act = new Actions(driver);
//	try {
//		act.moveToElement(element).click().build().perform();
//	}
//	catch (Exception e) {
//
//		System.out.println("Exception occured" +e.getMessage());
//		System.out.println("Exception occured - Cause" +e.getCause());
//		
//	}
//}

