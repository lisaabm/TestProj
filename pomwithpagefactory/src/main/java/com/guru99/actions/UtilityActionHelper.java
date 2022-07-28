package com.guru99.actions;

import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class UtilityActionHelper {
	/**
	 * Method to choose dropdown using Visible Text.
	 * @param driver
	 * @throws Exception
	 */
	public void selectDropDownByVisibleText(WebDriver driver, WebElement element, String visibleText) throws Exception {
		try {
			Select dropDown = new Select(element);
			dropDown.selectByVisibleText(visibleText);
		}catch(Exception e) {
			throw new Exception("selectDropDownByVisibleText (UtilityActionHelper) : "+e.getMessage());
		}
	}
	/**
	 * Method to choose dropdown using Index
	 * @param element
	 * @param index
	 * @throws Exception
	 */
	public void selectDropDownByIndex(WebDriver driver, WebElement element, int index) throws Exception {
		try{
			Select dropDown = new Select(element);
			dropDown.selectByIndex(index);
		}catch (Exception e) {
			throw new Exception("selectDropDownByIndex (UtilityActionHelper) : "+e.getMessage());
		}
	}
	/**
	 * Method to choose dropdown using Value.
	 * @param element
	 * @param value
	 * @throws Exception
	 */
	public void selectDropDownByValue(WebDriver driver, WebElement element, String value) throws Exception {
		try{
			Select dropDown = new Select(element);
			dropDown.selectByValue(value);
		}catch (Exception e) {
			throw new Exception("selectDropDownByValue (UtilityActionHelper) : "+e.getMessage());
		}
	}
    /**
     * Method to take Page ScreenShot.
     * @param driver
     * @throws Exception
     */
	public void ErrorPageScreenshot(WebDriver driver) throws Exception {
		try {
			String random = RandomStringUtils.randomAlphanumeric(10);
			String fileNm = "FailedSS "+ random;
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File(fileNm+".png"));
		}catch (Exception e) {
			throw new Exception("errorPageScreenshot (UtilityActionHelper) : "+e.getMessage());
		}
	}
	/**
	 * Method to drag and drop the selected element.
	 * @param driver
	 * @param source
	 * @param target
	 * @throws Exception
	 */
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) throws Exception {
		try {
			Actions act = new Actions(driver);
			act.moveToElement(source).clickAndHold().moveToElement(target).release().build().perform();
		}catch (Exception e) {
			throw new Exception("dragAndDrop (UtilityActionHelper) : "+e.getMessage());
		}
	}
	/**
	 * Method to Scroll to an Element using JavaScript Executor.
	 * @param driver
	 * @param element
	 * @throws Exception
	 */
	public void scrollToAnElement(WebDriver driver, WebElement element) throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		}catch (Exception e) {
			throw new Exception("scrollToAnElement (UtilityActionHelper) : "+e.getMessage());
		}
	}

}


