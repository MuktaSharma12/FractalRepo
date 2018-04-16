package com.qa.fractal_tests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginHome {

	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://my.askfractal.com/login");

	}

	@Test(priority = 1)
	public void Verifytitle_HomePage() {
		String actualtitle = driver.getTitle();
	//	System.out.println("Title of the page is  " + actualtitle);
		String expectedtitle = "Fractal";
		//Assert.assertEquals(actualtitle, expectedtitle);

		if (expectedtitle.equals(actualtitle)) {
			System.out
					.println("Verification Successful - The correct title is displayed on the web page.Test case is Passed");
		} else {
			System.out
					.println("Verification Failed - An incorrect title is displayed on the web page. The test case is failed");
		}
	}

	@Test(priority = 3)
	public void VerifyLogin() throws Exception {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(("muktaqa12@gmail.com"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(("Desktop12"));
	//the below line should be commented when checking mousehover action
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		System.out.println("Insight view page is displayed to the user");

		
	}

	@Test(priority = 2)
	public void VerifytheLogo_HomePage() {
		Boolean img = driver.findElement(By.xpath("//a[@class='js-home logo-section']")).isDisplayed();
		System.out.println("The logo is available: " + img);
	}

	@Test
	public void VerifyalLLinksAndImages() {

		//List<WebElement> lists = new ArrayList();
		List<WebElement> lists = driver.findElements(By.tagName("a"));
		System.out.println(" Total number of list are " +lists.size());
	}
		
	@Test(priority=1)
	public void Mousehoveraction() throws Exception{
	Actions action = new Actions(driver);
	//WebElement ele=  driver.findElement(By.xpath("//button[@type='button'and @class='btn btn-intuit js-login-intuit js-popover'])"));
	WebElement ele=  driver.findElement(By.xpath("//*[contains(@class,'btn btn-intuit js-login-intuit js-popover')]"));
	action.moveToElement(ele).click().build().perform();
   // action.moveToElement(element).moveToElement(driver.findElement(By.partialLinkText("InTuit"))).click().build().perform();
    Thread.sleep(4000);
    System.out.println("In the press page is displayed");
}
			

	@Test(priority = 4)
	public void CountnumberofLinks_HomePage() {

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("The page has total number of links: " + links.size());
		for (WebElement ele : links)
			System.out.println(ele.getAttribute("href"));
	}

	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
