package com.guru99.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru99.actions.ValidationActionHelpers;
import com.guru99.page.Homepage;
import com.guru99.page.LoginPage;

public class HomepageTest {
	WebDriver driver;
	LoginPage loginpage;
	Homepage homepage;
	ValidationActionHelpers validationactionhelpers;
	
	@BeforeTest
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lisaa\\Downloads\\chromedriver103\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/insurance/v1/index.php");
		loginpage=new LoginPage(driver);
		homepage=loginpage.login("","");
	}
	
	@Test(priority=0, groups="sanity")
	public void checkElementsDisplayed() throws Exception {
		homepage=new Homepage(driver);
		Assert.assertTrue(validationactionhelpers.isElementVisible(driver, homepage.title));
		Assert.assertTrue(validationactionhelpers.isElementVisible(driver, homepage.logoutbtn));
	}
	@Test(priority=1, groups="smoke")
	public void validateReqQuotBtn() throws InterruptedException {
		homepage=new Homepage(driver);
		homepage.clickReqQuotBtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@Test(priority=2, groups={"smoke","sprint1"} )
	public void validateRetQuotBtn() throws InterruptedException {
		homepage=new Homepage(driver);
		homepage.clickRetQuotbtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@Test(priority=3)
	public void validateReqProfileBtn() throws InterruptedException {
		homepage=new Homepage(driver);
		homepage.clickProfilebtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@Test(priority=4)
	public void validateEditProfileBtn() throws InterruptedException {
		homepage=new Homepage(driver);
		homepage.clickEditProfilebtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@Test(priority=5)
	public void validateLogouttBtn() {
		homepage=new Homepage(driver);
		homepage.clickLogout();
	}
	@AfterTest
	public void close() {
		driver.close();
	}
}
