package com.crm.utility;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.annotations.ITest;

public class Literners implements ITestListener {
	
	
	@Override
	public void onStart(ITestContext resu) {
		
		
	}
	@Override
	public void onTestStart(ITestResult result) {
		

		System.out.println("Test started: " + result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test passed: "+ result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result){
		String dynamicName= result.getMethod().getMethodName()+LocalDateTime.now().toString().replace(":", "-");
		TakesScreenshot ss= (TakesScreenshot)BaseClass.driver;
		File screnshot = ss.getScreenshotAs(OutputType.FILE);
		
		
		
		try {
			File fis = new File("C:\\girish\\javaProjects\\Girish_Automation\\Hybrid_Driven_Tesing\\src\\test\\resources\\ScreenShots\\"+dynamicName+".png");
			FileHandler.copy(screnshot, fis);
			
		} catch (FileNotFoundException e) {
			
			System.err.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Test failed: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test skipped: "+ result.getMethod().getMethodName());
	}
	
}
