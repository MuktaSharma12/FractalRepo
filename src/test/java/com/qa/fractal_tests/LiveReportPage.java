package com.qa.fractal_tests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LiveReportPage {
	
		static WebDriver driver;
		
		@BeforeMethod
		public void setUp() {
			System.setProperty("webdriver.chrome.driver","C:\\Selenium Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://my.askfractal.com/login");
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(("muktaqa12@gmail.com"));
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(("Desktop12"));
		//the below line should be commented when checking mousehover action
			driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
			
		}


		@Test(priority=2)
		public void VerifyLiveReports() throws Exception{
		driver.findElement((By.xpath("//div[contains(text(),'LIVE REPORTS')]"))).click();
		Thread.sleep(5000);
		System.out.println("Live Reports page is displayed");
		String actualtitle=	driver.getTitle();
		String expectedtitle="Live Reports";
		Assert.assertEquals("Condition true", actualtitle, expectedtitle);
		
		driver.findElement(By.xpath("//button[@class='js-new-collection btn btn-default metrics-bt s3 button-icon-plus']")).click();
		System.out.println("creating a new live report window pop-up is displayed");
		}
		
		@Test(priority=1)
		public void VerifyAllWindowsExceptMainWindow() {
			driver.navigate().to("https://my.askfractal.com/shared-collections");
			
			// To get the main window handle
			String windowTitle= getCurrentWindowTitle();
			String mainWindow = getMainWindowHandle(driver);
			Assert.assertTrue(windowTitle.contains("Shared - collections"), "Main window title is not matching");
		}
			
		public String getMainWindowHandle(WebDriver driver) {
			return driver.getWindowHandle();
		}

		public String getCurrentWindowTitle() {
			String windowTitle = driver.getTitle();
			return windowTitle;
			
		}
		
				

	@AfterMethod
	public void tearDown(){
	driver.quit();
	
}
}
