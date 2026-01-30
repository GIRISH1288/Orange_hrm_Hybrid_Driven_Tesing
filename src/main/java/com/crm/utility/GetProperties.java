package com.crm.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetProperties {

	public String path;
	
	public GetProperties(String path) {
		// TODO Auto-generated constructor stub
		this.path=path;
		
		
	}
	
	public  String getVal(String key)  {
		String res=null;
		try {
			Properties prop= new Properties();
			
			FileInputStream fis= new FileInputStream(path);
			prop.load(fis);
			
			 res=prop.getProperty(key);
			
			
		} catch (Exception e) {
			
			System.out.println("Some error occured at getproperties");
			e.printStackTrace();
			
		}
		
	
		return res;
	}
}
