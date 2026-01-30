package com.crm.utility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseClass  {

	
	public static WebDriver driver;
	public static GetProperties prop= new GetProperties("C:\\\\girish\\\\javaProjects\\\\Girish_Automation\\\\Hybrid_Driven_Tesing\\\\src\\\\test\\\\resources\\\\config.properties");
    public  final String  BaseUrl=prop.getVal("baseUrl");
	
	@BeforeTest
	public void preCondition() throws IOException {
		
		
	String ans=prop.getVal( "browser");
	System.out.println(ans);
	if(ans.equalsIgnoreCase("chrome"))
	driver= new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get(BaseUrl);
	Reporter.log("@BeforeTest - Browser launch");
	
	
	}
	
	
	@AfterTest
	public void postCondition() {
		//System.out.println("quiting");
		driver.quit();
		driver=null;
		Reporter.log("@AfterTest - Browser close");
		
	}
	

}
