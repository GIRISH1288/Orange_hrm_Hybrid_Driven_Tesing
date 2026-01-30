package com.crm.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Orange {

	public static void login(WebDriver driver,GetProperties prop) {
		
		
		String userId=prop.getVal("userId");
		String pass=prop.getVal("pass");
		
		
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userId);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
				
	}
	
}
