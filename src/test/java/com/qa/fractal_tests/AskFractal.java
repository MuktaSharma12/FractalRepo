package com.qa.fractal_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AskFractal {
	
	static WebDriver driver;
	
	@Test
	public void VerifyAskFractal() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://my.askfractal.com/login");
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(("muktaqa12@gmail.com"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(("Desktop12"));
		
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'Ask Fractal')]"));
		ele.click();
		String actualtitle = driver.getTitle();
		String expectedtitle= "Chat - overview";
			if(actualtitle.equalsIgnoreCase(expectedtitle))
			 System.out.println("The title matches hence the Testcase is passed");
			 else
					 System.out.println("The title does not match hence the Testcase is failed");
					 driver.close();
		
		
		System.out.println("chat overview screen is displayed");
		
	}

}
