package com.guru99.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru99.actions.ValidationActionHelpers;
import com.guru99.page.LoginPage;

public class LoginTest {
	WebDriver driver;
	LoginPage loginpg;
	ValidationActionHelpers validationactionhelpers;
	
	@BeforeTest
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lisaa\\Downloads\\chromedriver103\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/insurance/v1/index.php");
	}
	//0. Verify whether Elements are displayed.
	@Test(priority=0)
	public void checkElementsDisplayed() throws Exception {
		loginpg=new LoginPage(driver);
		Assert.assertTrue(validationactionhelpers.isElementVisible(driver, loginpg.logo));
		Assert.assertTrue(validationactionhelpers.isElementVisible(driver, loginpg.regbtn));
		Assert.assertTrue(validationactionhelpers.isElementVisible(driver, loginpg.loginicn));
	}
	
	//1. Verify whether Error Message is displayed when entered invalid credentials.
	@Test(priority=1)
	public void validateInvalidEmailErrorMessage() throws Exception {
		loginpg=new LoginPage(driver);
		loginpg.typeEmail("test");
		loginpg.typePassword("test");
		loginpg.clickLogin();
		Assert.assertTrue(validationactionhelpers.isElementVisible(driver, loginpg.error));
	}
	
	//2. Verify whether Home page is displayed when clicked login button without entering credentials.
	@Test(priority=2)
	public void validateLogin() throws InterruptedException {
		loginpg=new LoginPage(driver);
		loginpg.typeEmail("");
		loginpg.typePassword("");
		loginpg.clickLogin();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
}
