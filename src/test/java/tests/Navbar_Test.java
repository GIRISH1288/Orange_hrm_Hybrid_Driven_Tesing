package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.pom.DashBoard;
import com.crm.pom.Navbar;
import com.crm.utility.BaseWebdriver;
import com.crm.utility.Login_Orange;

public class Navbar_Test extends BaseWebdriver {

	public Navbar nb;
	public List<String> menuItemstext;

	@BeforeMethod
	public void setUp() {
		nb = new Navbar(driver);

	}

	@Test(priority = 0)
	public void searchFieldVisiblity() {
		WebElement ele = nb.getSearchfeild();
		Assert.assertTrue(ele.isDisplayed(), "The Search Field is not visible !");
	}

	@Test(priority = 1)
	public void searchFieldEnabaled() {
		WebElement ele = nb.getSearchfeild();
		Assert.assertTrue(ele.isEnabled(), "The Search Field is not displayed  !");
	}

	@Test(priority = 2)
	public void searchFieldInputVerify() {
		WebElement ele = nb.getSearchfeild();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(ele));

		String key = "Admin";
		ele.clear();
		ele.sendKeys(key);
		String val = ele.getAttribute("value");

		Assert.assertEquals(val, key, "Entered text and displayed text are not matching ! ");
	}

	@Test(priority = 3)
	public void searchFieldWorking() {
		WebElement ele = nb.getSearchfeild();
		List<WebElement> list = nb.getMainmenuoptionsTexts();
		String[] menuItems = new String[list.size()];
		
		int i = 0;
		for (WebElement wb : list) {

			String res = wb.getText();
			menuItems[i++] = res;

		}
		System.out.println(Arrays.toString(menuItems));
		menuItemstext = Arrays.asList(menuItems);

		for (int j = 0; j < menuItems.length; j++) {
			ele = nb.getSearchfeild();
			ele.clear();
			ele.sendKeys(Keys.CONTROL + "a");
			ele.sendKeys(Keys.DELETE);
			// System.out.println(menuItems[j]);
			String seacrhItem = menuItems[j];
			ele.sendKeys(seacrhItem);
			assertTrue(nb.getMainmenuoptionsTexts().size() > 0, " Search Failed !");
		}

	}

	@Test(priority = 4)
	public void verifyNavbarItemsLink() throws InterruptedException {
		List<WebElement> links = new ArrayList<WebElement>(nb.getMainmenuoptionsLinks());
		//links.add(7,  nb.getDashboard());
	
		int ct = links.size();
        System.out.println(ct);
        int j=0;
        for (int i = 0; i < ct; i++) {
         
        	if (i==7) {
        		j+=1;
        		
			}
		  String key = menuItemstext.get(j).replace(" ", "_");
		 
		 
		 
        	links.get(i).click();
        	Thread.sleep(3000);
        	System.out.println(key+" -> "+driver.getCurrentUrl());
        	System.out.println(prop.getVal(key));
        	
        	//assertEquals(driver.getCurrentUrl(), prop.getVal(key) , "The navbar link is not wokring for "+key+ " link");
        	
        	
        	driver.navigate().back();
        	links=nb.getMainmenuoptionsLinks();
        	j++;        
		}
        nb.getDashboard().click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), prop.getVal("Dashboard"));
        System.out.println("all components tested and verifed !");
        
               
        
		

	}
	
       
               
        
		

	

}

/*
 * int ct=links.size();
 * 
 * 
 * 
 * }
 */