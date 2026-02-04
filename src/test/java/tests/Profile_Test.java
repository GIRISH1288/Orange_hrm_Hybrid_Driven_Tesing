package tests;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.pom.Profile;

import com.crm.utility.BaseWebdriver;
import com.crm.utility.Login_Orange;

public class Profile_Test extends BaseWebdriver {

	Profile po;

	@BeforeMethod
	public void setUp() {
		po = new Profile(driver);
		Actions act = new Actions(driver);

		WebElement username = po.getUsername();
		act.click(username).perform();

	}

	@Test(priority = 0)
	public void usernameVisible() {
		WebElement username = po.getUsername();
		assertTrue(username.isDisplayed(), "Username is not displayed !");

	}

	@Test(priority = 1)
	public void verifyDropDownVisiblity() {

		WebElement dropdown = po.getDropDownmenu();
		assertTrue(dropdown.isDisplayed(), "Drop menu is not displayed !");

	}

	@Test(priority = 2)
	public void verifyDropDownEnablity() throws InterruptedException {

		WebElement dropdown = po.getDropDownmenu();
		assertTrue(dropdown.isEnabled(), "Drop menu is not enabaled !");

	}

	@Test(priority = 3)
	public void verifydropDownLinksvisiblity() {
		WebElement menu = po.getDropDownmenu();
		System.out.println(menu.isDisplayed() +" : "+menu.isEnabled());
		List<WebElement> links = po.getAllLinks();
		for (WebElement web : links) {
			assertTrue(web.isDisplayed(), web.getText() + "  link is not visible !");
		}
	}

	@Test(priority = 4)
	public void verifydropDownLinksEnablity() {
		List<WebElement> links = po.getAllLinks();
		for (WebElement web : links) {
			assertTrue(web.isEnabled(), web.getText() + "  link is not enabaled !");
		}
	}

	@Test(priority = 5)
	public void verifyAboutLink() throws InterruptedException {
		
		
		WebElement ele = po.getAboutLink();
		
		ele.click();
		Thread.sleep(2000);
		
		WebElement info = driver.findElement(By.xpath("//div[@role='document']"));
		
		
		assertTrue(info.isDisplayed(), "About link is not working ");
		
		driver.navigate().refresh();
		
	}
	@Test(priority = 6)
	public void verifySupportLink() throws InterruptedException {
		
		
		WebElement ele = po.getSupportlink();
		
		ele.click();
		Thread.sleep(2000);
		
		String expecetdLink=prop.getVal("support");
		
		assertEquals(expecetdLink, driver.getCurrentUrl() , "support link is not working !");
		
		driver.navigate().back();
		Thread.sleep(2000);
		
	}
	
	@Test(priority = 7)
	public void  verifyUpdatePassLink()  throws InterruptedException{

		WebElement ele = po.getChngepass();
		ele.click();
		Thread.sleep(2000);
		String expectedlink=prop.getVal("updatepass");
		
		assertEquals(expectedlink, driver.getCurrentUrl() , "Changes password link is not working ");
		verifyUpdatepassPageCtPass();
		verifyUpdatepassNewPass();
		verifyUpdatepassConfPass();
		verifyUpdatepasscancelBtn();
		verifyUpdatepassSaveBtn();
		
	}
	
	
	public void verifyUpdatepassPageCtPass()  {
		 WebElement ctpass=po.getCtPass();
		 assertTrue(ctpass.isDisplayed() , "Current Password field is not  visible");
         assertTrue(ctpass.isEnabled() , "Current Password field is not  Enabaled ");
         
		
	}
	
	
	public void verifyUpdatepassNewPass()  {
		 WebElement newPass=po.getNewPass();
		 assertTrue(newPass.isDisplayed() , "New  Password field is not  visible");
         assertTrue(newPass.isEnabled() , "New Password field is not  Enabaled ");
         
	}
	
	
	public void verifyUpdatepassConfPass()  {
		 WebElement confPass=po.getConfPass();
		 assertTrue(confPass.isDisplayed() , "Confirm Password field is not  visible");
         assertTrue(confPass.isEnabled() , "Confirm Password field is not  Enabaled ");
    
	}

	
	public void verifyUpdatepasscancelBtn()   {
		 WebElement cancelBtn=po.getCancel();
		 assertTrue(cancelBtn.isDisplayed() , "Cancel Button is not  visible");
         assertTrue(cancelBtn.isEnabled() , "Cancel Button   is not  Enabaled ");
         
		 
		
	}
	
	public void verifyUpdatepassSaveBtn() throws InterruptedException  {
		 WebElement saveBtn=po.getSave();
		 assertTrue(saveBtn.isDisplayed() , "save Button is not  visible");
         assertTrue(saveBtn.isEnabled() , "save Button   is not  Enabaled ");
         
		 
		driver.navigate().back();
		Thread.sleep(2000);
	}
	
	@Test(priority = 8)
	public void verifyLogout() throws InterruptedException {
	 WebElement logout = po.getLogout();
	 logout.click();
	 Thread.sleep(3000);
	 String actualUrl= driver.getCurrentUrl();
	 String expectedUrl=prop.getVal("postLogout");
	 assertEquals(actualUrl, expectedUrl , "Actual and Expected Url is not matching !");
	 Login_Orange.login(driver, prop);
	 
		
	}
	

	
	

	
	
}
