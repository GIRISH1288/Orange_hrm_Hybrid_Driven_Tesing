package com.crm.utility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseWebdriver extends BaseClass {
	
	
	
	@BeforeMethod
	public void loggin() {
		Reporter.log("@BeforeMethod - Login");
		
		String userId=prop.getVal("userId");
		String pass=prop.getVal("pass");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userId);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
				
	}
	
	@AfterMethod
	
	public void loggout() {
		Reporter.log("@AfterMethod - Login");
		
       Actions act  = new Actions(driver);
		
		WebElement username= driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
		act.click(username).perform();
		
	     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	     
	    WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class=\"oxd-userdropdown-link\"])[4]")));
	    ele.click();
		
	}
	
	
	
	
}
