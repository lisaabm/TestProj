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
import com.guru99.page.RetQuotationPage;

public class RetQuotationTest {
	WebDriver driver;
	ValidationActionHelpers validationactionhelpers;
	LoginPage loginpage;
	Homepage homepage;
	RetQuotationPage retquotationpage;
	
	@BeforeTest
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lisaa\\Downloads\\chromedriver103\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/insurance/v1/index.php");
		loginpage=new LoginPage(driver);
		homepage=new Homepage(driver);
		homepage=loginpage.login("","");
		retquotationpage=homepage.clickonRetrieveQuotation();
	}
	@Test
	public void elementsDisplayed() throws Exception {
		retquotationpage=new RetQuotationPage(driver);
		Assert.assertTrue(validationactionhelpers.isElementVisible(driver,retquotationpage.retBtn));
		Assert.assertTrue(validationactionhelpers.isElementVisible(driver,retquotationpage.idenNo));
		}
	@AfterTest
	public void close() {
		driver.close();
	}
}
