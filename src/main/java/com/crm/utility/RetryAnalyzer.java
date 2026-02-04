package com.crm.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	private int retrycount=0;
	
	private final int max_retry=3;
	
	@Override
	public boolean retry(ITestResult result) {
		if (retrycount<max_retry) {
			retrycount++;
			return true;
		}
		
		return false;
		
		
		// TODO Auto-generated method stub
		
	}

}
