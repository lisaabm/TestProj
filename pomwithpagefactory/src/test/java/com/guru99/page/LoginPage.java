package com.guru99.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver  driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement pwd;
	
	public @FindBy(name="submit")
	WebElement login;
	
	public @FindBy(xpath="//b[contains(.,'Enter your Email address and password correct')]")
	WebElement error;
	
	public @FindBy(xpath="//a[contains(.,'Register')]")
	WebElement regbtn;
	
	public @FindBy(xpath="//h3[contains(.,'Login')]")
	WebElement loginicn;
	
	public @FindBy(xpath="//div[@class='logo']")
    WebElement logo;
	
	public void typeEmail(String emailAddress) {
		email.sendKeys(emailAddress);
	}
	public void typePassword(String password) {
		pwd.sendKeys(password);
	}
	public void clickLogin() {
		login.click();
	}
	public Homepage login(String emailAddress, String password) {
		email.sendKeys(emailAddress);
		pwd.sendKeys(password);
		login.click();
		return new Homepage(driver);
	}	
}
	
    