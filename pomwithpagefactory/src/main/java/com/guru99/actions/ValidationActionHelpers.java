package com.guru99.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ValidationActionHelpers {
	/**
	 * Method to check whether Element is Visible.
	 * @param driver
	 * @param element
	 * @return
	 * @throws Exception
	 */
	public boolean isElementVisible(WebDriver driver, WebElement element) throws Exception {
		boolean elementVisible = false;
		try {
			if(element.isDisplayed())
				elementVisible = true;
			return elementVisible;
		}catch(Exception e) {
			throw new Exception("checkElementsDisplayed(ValidationActionHelper) : "+e.getMessage());
		}
	}
	/**
	 * Method to check whether Element is Enabled.
	 * @param driver
	 * @param element
	 * @return
	 * @throws Exception
	 */
	public boolean isElementEnabled(WebDriver driver, WebElement element) throws Exception {
		boolean elementEnabled = false;
		try {
			if(element.isEnabled())
				elementEnabled = true;
			return elementEnabled;
		} catch(Exception e) {
			throw new Exception("isElementEnabled (ValidationActionHelper) :"+e.getMessage());
		}
	}
	/**
	 * Method to check whether Element is Selected.
	 * @param driver
	 * @param element
	 * @return
	 * @throws Exception
	 */
	public boolean isElementSelected(WebDriver driver, WebElement element) throws Exception {
		boolean elementSelected = false;
		try {
			if(element.isSelected())
				elementSelected = true;
			return elementSelected;
		} catch(Exception e) {
			throw new Exception("isElementSelected (ValidationActionHelper) :"+e.getMessage());
		}
	}
}
