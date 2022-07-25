package com.guru99.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetQuotationPage {

	WebDriver driver;
	
	public RetQuotationPage(WebDriver  driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public @FindBy(xpath="//input[@id='getquote']")
	WebElement retBtn;
	
	public @FindBy(xpath="//input[@name='id']")
	WebElement idenNo;
}
