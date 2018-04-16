package com.qa.fractal_tests;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InsightsPage {
	
	public WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://my.askfractal.com/login");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(("muktaqa12@gmail.com"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(("Desktop12"));
	//the below line should be commented when checking mousehover action
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

	}
	
	@Test(priority=1)
	public void VerifyInsights(){
	driver.findElement((By.xpath("//*[contains(@class,'sideMenu-element main active')]"))).click();
	System.out.println("Insights overview page is displayed");
	driver.findElement(By.xpath("//button[@class='btn btn-clearbox js-link'][contains(text(),'Explore Insights')]")).click();
	System.out.println("Revenue page is displayed");
	System.out.println("The current url of the page is" +driver.getCurrentUrl());
	driver.navigate().back();
	driver.navigate().forward();
	//driver.getCurrentUrl();
	
	}
	
	@Test
	public void VerifyMetricSearch() throws Exception{
		Actions action= new Actions(driver);
		WebElement ele=	driver.findElement(By.xpath("//span[@class='select2-selection__placeholder']"));
		action.moveToElement(ele).click().build().perform();
		Thread.sleep(4000);
	    System.out.println("metrics values are displayed");
	   WebElement ele1 = driver.findElement(By.name("dropdown"));
	    ele.isSelected();
	   // Select dropdown= new Select(ele1);
	    //dropdown.selectByIndex(2);
	}
	
	@Test(priority=2)
	public void VerifyRadiobuttons() throws Exception{
		Actions action = new Actions(driver);
		WebElement ele=  driver.findElement(By.xpath("//html//div[@id='content-container']//li[1]"));
		action.moveToElement(ele).click().build().perform();
		ele.isSelected();
		Thread.sleep(4000);
		System.out.println("Explore Insights button is displayed");
	}
	
	
	
	@AfterMethod
	public void teardown() {
	driver.quit();
	}
	
	

	}
	

