package com.crm.utility;

import org.testng.annotations.Test;

public class example  {
	
@Test
public void main() {
	GetProperties prop= new GetProperties("C:\\\\girish\\\\javaProjects\\\\Girish_Automation\\\\Hybrid_Driven_Tesing\\\\src\\\\test\\\\resources\\\\config.properties");
	String url=prop.getVal("1");
	System.out.println(url);
}
}