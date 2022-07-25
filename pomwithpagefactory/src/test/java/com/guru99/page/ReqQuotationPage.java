package com.guru99.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ReqQuotationPage {
WebDriver driver;
	
	public ReqQuotationPage(WebDriver  driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public @FindBy(xpath="//h2[contains(.,'Request a quotation')]")
	WebElement title;

	public @FindBy(xpath="//label[contains(.,'Breakdowncover')]")
	WebElement brkdwncvr;
	
	public @FindBy(xpath="//label[contains(.,'Windscreenrepair')]")
	WebElement windscrn;
	
	public @FindBy(xpath="//strong[text()='Vehicle:']")
	WebElement vehicle;
	
	public @FindBy(xpath="//input[@value='Calculate Premium']")
	WebElement calprem;
	
	public @FindBy(xpath="//input[@value='Reset form']")
	WebElement reset;
	
	public @FindBy(xpath="//input[@value='Save Quotation']")
	WebElement save;
	
	public @FindBy(xpath="//select[@id='quotation_breakdowncover']")
	WebElement brkdwndd;
	
	public @FindBy(xpath="//select[@name='parkinglocation']")
	WebElement prklocatdd;
	
	public @FindBy(xpath="//input[@type='radio' and @value='No']")
	WebElement windradiobtn;
	
	public @FindBy(xpath="//input[@name='incidents']")
	WebElement incident;
	
	public @FindBy(xpath="//input[@name='registration']")
	WebElement registration;
	
	public @FindBy(xpath="//input[@name='mileage']")
	WebElement mileage;
	
	public @FindBy(xpath="//input[@name='value']")
	WebElement value;
	
	public @FindBy(xpath="//select[@name='year']")
	WebElement yeardd;
	
	public @FindBy(xpath="//select[@name='month']")
	WebElement monthdd;
	
	public @FindBy(xpath="//select[@name='date']")
	WebElement datedd;
		
	public void selectBreakdownCover() {
		Select selectbrkdwm = new Select(brkdwndd);
		selectbrkdwm.selectByIndex(3);
	}
	public void selectWindScreenRepair() {
		windradiobtn.click();
	}
	public void typeIncident(String incidents) {
		incident.sendKeys(incidents);
	}
	public void typeRegistration(String vehicleRegistration) {
		registration.sendKeys(vehicleRegistration);
	}
	public void typeMileage(String annualmileage) {
		mileage.sendKeys(annualmileage);
	}
	public void typeValue(String price) {
		value.sendKeys(price);
	}
	public void selectParkingLocation() {
		Select selectprkdwm = new Select(prklocatdd);
		selectprkdwm.selectByValue("Public place");
	}
	public void selectVehicleYear() {
		Select selectyear = new Select(yeardd);
		selectyear.selectByValue("2018");
	}
	public void selectVehicleMonth() {
		Select selectmonth = new Select(monthdd);
		selectmonth.selectByVisibleText("June");
	}
	public void selectVehicleDate() {
		Select selectdate = new Select(datedd);
		selectdate.selectByIndex(19);
	}
	public void calculatePremium() {
		calprem.click();
	}
	public void resetForm() {
		reset.click();
	}
	public void saveQuotation() {
		save.click();
	}
}

