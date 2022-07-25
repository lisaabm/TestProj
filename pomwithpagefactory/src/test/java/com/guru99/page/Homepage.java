package com.guru99.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
WebDriver driver;
	
	public Homepage(WebDriver  driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h2[contains(.,'Broker Insurance WebPage')]")
	public	WebElement title;
	
	public @FindBy(xpath="//a[@class='ui-tabs-anchor' and @id='ui-id-2']")
	WebElement reqQuotbtn;
	
	public @FindBy(xpath="//a[@class='ui-tabs-anchor' and @id='ui-id-3']")
	WebElement retQuotbtn;
	
	public @FindBy(xpath="//a[@class='ui-tabs-anchor' and @id='ui-id-4']")
	WebElement profile;
	
	public @FindBy(xpath="//a[@class='ui-tabs-anchor' and @id='ui-id-5']")
	WebElement editprofile;
	
	public @FindBy(xpath="//input[@type='submit' and @value='Log out']")
	WebElement logoutbtn;
	public void clickReqQuotBtn() {
		reqQuotbtn.click();
	}
	public void clickRetQuotbtn() {
		retQuotbtn.click();
	}
	public void clickProfilebtn() {
		profile.click();
	}
	public void clickEditProfilebtn() {
		editprofile.click();
	}
	public void clickLogout() {
		logoutbtn.click();
	}
	public ReqQuotationPage clickonRequestQuotation() {
		reqQuotbtn.click();
		return new ReqQuotationPage(driver);
	}
		public RetQuotationPage clickonRetrieveQuotation() {
		retQuotbtn.click();
		return new RetQuotationPage(driver);
	}
}
