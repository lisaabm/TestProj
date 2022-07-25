package com.guru99.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru99.actions.ValidationActionHelpers;
import com.guru99.page.Homepage;
import com.guru99.page.LoginPage;
import com.guru99.page.ReqQuotationPage;

public class ReqQuotationTest {
	WebDriver driver;
	ValidationActionHelpers validationactionhelpers;
	LoginPage loginpage;
	Homepage homepage;
	ReqQuotationPage reqquotationpage;
	
	@BeforeTest
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lisaa\\Downloads\\chromedriver103\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/insurance/v1/index.php");
		loginpage=new LoginPage(driver);
		homepage=new Homepage(driver);
		homepage=loginpage.login("","");
		reqquotationpage=homepage.clickonRequestQuotation();		
	}
	//0. Verify whether elements are displayed.
	@Test(priority=0)
	public void elementsDislayed() throws Exception {
		reqquotationpage=new ReqQuotationPage(driver);
		Assert.assertTrue(validationactionhelpers.isElementVisible(driver, reqquotationpage.title));
		Assert.assertTrue(validationactionhelpers.isElementVisible(driver, reqquotationpage.brkdwncvr));
		Assert.assertTrue(validationactionhelpers.isElementVisible(driver, reqquotationpage.windscrn));
		Assert.assertTrue(validationactionhelpers.isElementVisible(driver, reqquotationpage.vehicle));
		Assert.assertTrue(validationactionhelpers.isElementVisible(driver, reqquotationpage.calprem));
		Assert.assertTrue(validationactionhelpers.isElementVisible(driver, reqquotationpage.reset));
		Assert.assertTrue(validationactionhelpers.isElementVisible(driver, reqquotationpage.save));
	}
	
	//1. Verify whether user can calculate premium without entering details.
	@Test(priority=1)
	public void emptyDetails() {
		reqquotationpage=new ReqQuotationPage(driver);
		reqquotationpage.calculatePremium();		
	}
	
	//2. Verify whether user can reset form in between and save quotation after entering required details.
	@Test(priority=2)
	public void validDetails() {
		reqquotationpage=new ReqQuotationPage(driver);
		reqquotationpage.selectBreakdownCover();
		reqquotationpage.selectWindScreenRepair();
		reqquotationpage.typeIncident("Parked car Damage");
		reqquotationpage.typeRegistration("KL-07BH999");
		reqquotationpage.typeMileage("16");
		reqquotationpage.resetForm();
		reqquotationpage=new ReqQuotationPage(driver);
		reqquotationpage.selectBreakdownCover();
		reqquotationpage.selectWindScreenRepair();
		reqquotationpage.typeIncident("Parked car Damage");
		reqquotationpage.typeRegistration("KL-07BH999");
		reqquotationpage.typeMileage("16");
		reqquotationpage.typeValue("2,00,000");
		reqquotationpage.selectParkingLocation();
		reqquotationpage.selectVehicleYear();
		reqquotationpage.selectVehicleMonth();
		reqquotationpage.selectVehicleDate();
		reqquotationpage.saveQuotation();
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
}

		
	


