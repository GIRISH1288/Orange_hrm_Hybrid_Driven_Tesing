package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.awt.AWTException;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.pom.Admin_Module;
import com.crm.utility.BaseClass;
import com.crm.utility.BaseWebdriver;

public class Admin_Module_Test extends BaseClass {

	
	public Admin_Module ad;
	WebDriverWait wait;
	String username;
	
	
	int nom;
	{
		 nom=(int)(1000*Math.random());
	}
	
	@BeforeClass
	public void setUp() {
        String userId=prop.getVal("userId");
		String pass=prop.getVal("pass");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userId);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		ad=new Admin_Module(driver);
		ad.getAdminBtn().click();
		wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers"));
		
	}
	
	@Test(priority = -1 , enabled = false)
	public void verifyPageLink() {
	
		String expectedUrl=prop.getVal("Admin");
		String actualUrl=driver.getCurrentUrl();
		System.out.println(actualUrl);
		Assert.assertEquals(expectedUrl, actualUrl , "Expected Url and Actaul do not match !");
		
		
		
	}
	//--------- Add Admin Module Test case-------------
	
	@Test(priority = 0 ) 
	public  void addAdminLinkVerify() {
		navigateToAddAdmin();
		
		String expectedurl=prop.getVal("addadmin");
		
		assertEquals(expectedurl, driver.getCurrentUrl() , "Exepected and actualUrl doesnt match !");
		//System.out.println(driver.getCurrentUrl());
	
		
	}
	//helper method
	public  void navigateToAddAdmin() {
		WebElement btn = ad.getAddAdminBtn();
		btn.click();
		String expectedurl=prop.getVal("addadmin");
		wait.until(ExpectedConditions.urlToBe(expectedurl));
	
		
	}
	
	//visisblity of userolemenu
	@Test(priority = 1)

	public void verifyUserRole_Admin() {
		
		WebElement  userrole=ad.getUserRoledd();
		assertTrue(userrole.isDisplayed() , "User role is not displayed !");
		assertTrue(userrole.isEnabled() , "User role is not enabaled !");
		
	}
	
	//visiblity and enablity of userrole options
	@Test(priority = 2)
	
	public void verifyUserroleOptions() {
     Actions act= new Actions(driver);
     WebElement  userrole=ad.getUserRoledd();
		act.click(userrole);
		act.perform();
		
    	WebElement options=ad.getUserddOptions();
    	wait.until(ExpectedConditions.visibilityOf(options));
    	assertTrue(options.isDisplayed() , "dropdown options are not visible !");
		assertTrue(options.isEnabled() , "dropdown options are not enabaled  !");
		
	
		
	}
	@Test(priority = 3)
	public void selectAdminRole() {
		Actions act= new Actions(driver);
		WebElement adminOption = driver.findElement(By.xpath("(//div[@class='oxd-select-option'])[2]"));
		act.click(adminOption).perform();
	}
	
	@Test(priority = 4)
	public void verifyEmpNameFeild() throws InterruptedException {
     String username=ad.getUsername().getText();
		
		WebElement name=ad.getEmpNameFeild();
		name.clear();
		
		name.sendKeys(username);
		WebElement hintparent=driver.findElement(By.xpath("//div[@class='oxd-autocomplete-dropdown --positon-bottom']"));
		
		assertTrue(hintparent.isDisplayed() , "hints are not displyed !");
		assertTrue(hintparent.isEnabled() , "Hint is not enabled !");
		
		WebElement hints=driver.findElement(By.xpath("//div[@class='oxd-autocomplete-dropdown --positon-bottom']/div/span"));
		hints.click();
		
	}
	
	@Test(priority = 5)
	public void verifyStatusfeild() {
		
		WebElement ele=ad.getStatusSelect();
		assertTrue(ele.isDisplayed() , "Status feild is not displayed !");
		assertTrue(ele.isEnabled() , "Status feild is not Enabaled  !");
		
	}
	
	@Test(priority = 6)
	public void verifyStatusfeildOptions() {
	 WebElement statusBtn=ad.getStatusSelect();
	 Actions act =new Actions(driver);
	 act.click(statusBtn).perform();
	 
	   List<WebElement> dropdownoptions = ad.getSelectStatusDropdown_addAdmin();
	   for (WebElement ele : dropdownoptions) {
		      assertTrue(ele.isDisplayed() , "Status feild Options are not displayed !");
			  assertTrue(ele.isEnabled() , "Status feild Options are not Enabaled !");
		
	   }
	}
	
	@Test(priority = 7)
	public void selectStatusEnable() {
		WebElement enable = driver.findElement(By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']/div[2]/span"));
		enable.click();
			
	}
	
	@Test(priority = 8)
	public void verifyUsernameFieldVisiblity() {
	 WebElement usrnameFeild = ad.getUserNameAddAdminPage();
	 assertTrue(usrnameFeild.isDisplayed() , "Username feild is visible ");
	 
 
	}
	
	@Test(priority = 9)
	public void verifyUsernameFieldEnablity() {
		WebElement usrnameFeild = ad.getUserNameAddAdminPage();
		assertTrue(usrnameFeild.isDisplayed() , "Username feild is enabaled ! ");
	}
	
	
	@Test(priority = 10)
	public void addUsername() {
		String user=prop.getVal("userId")+String.valueOf(nom);
		this.username=user;
		System.out.println("user : " +user);
	   WebElement usrnameFeild = ad.getUserNameAddAdminPage();
	   usrnameFeild.sendKeys(user);
	   String actualvalue=usrnameFeild.getAttribute("value");
	   assertEquals(user, actualvalue , "Entered value and actual value difff ");

		
	}
	
	@Test(priority = 11)
	public void verifyPasswordFieldVisiblity() {
		WebElement pass = ad.getPassword();
		assertTrue(pass.isDisplayed() , "Password field is not displayed !");
		
	}
	
	@Test(priority = 12)
	public void verifyPasswordFieldEnablity() {
		WebElement pass = ad.getPassword();
		assertTrue(pass.isDisplayed() , "Password field is not displayed !");
	}
	
	@Test(priority = 13)
	public void sendPassword() {
		WebElement pass = ad.getPassword();
		String password=prop.getVal("pass");
		pass.clear();
		pass.sendKeys(password);

	}
	
	@Test(priority = 14)
	public void verifyPassMasked() {
		SoftAssert sa = new SoftAssert();
		
		WebElement pass = ad.getPassword();
       String attri= pass.getAttribute("type").toLowerCase();
       sa.assertEquals(attri, "password" , "PassWord is not masked ");
       sa.assertAll();
       
	}
	
	@Test(priority = 15)
	public void verifyConfmPassFeildVisiblity() {
		 WebElement comfPass=ad.getConfmPass();
		 assertTrue(comfPass.isDisplayed(),"Comfirm Passwrod field is not vsiisble !");
	}
	
	
	@Test(priority = 15)
	public void verifyConfmPassFeildEnablity() {
		 WebElement comfPass=ad.getConfmPass();
		 assertTrue(comfPass.isEnabled(),"Comfirm Passwrod field is not enabaled !");
	}
	
	@Test(priority = 16)
	public void sendComfPass() {
		 WebElement comfPass=ad.getConfmPass();
		 comfPass.clear();
		 String password=prop.getVal("pass");
		 comfPass.sendKeys(password);
		 
	}
	
	@Test(priority =17)
	public void verifyComfPassMasked() {
		SoftAssert sa = new SoftAssert();
		
		WebElement comf= ad.getConfmPass();
		String attri= comf.getAttribute("type").toLowerCase();
		sa.assertEquals(attri, "password" , "Comfirm password field is not massed !");
		
		sa.assertAll();
		
		
	}

	@Test(priority = 18)
	public void cancelBtnVisilbity() {
		SoftAssert sa = new SoftAssert();
		WebElement cancelBtn= ad.getcancelbtn();
		sa.assertTrue(cancelBtn.isDisplayed() , "Cancel button is not Displayed  !");
		sa.assertAll();
		
		
	}
	
	@Test(priority = 18)
	public void cancelBtnEnabaled() {
		SoftAssert sa = new SoftAssert();
		WebElement cancelBtn= ad.getcancelbtn();
		sa.assertTrue(cancelBtn.isEnabled() , "Cancel button is not Enabaled !");
		sa.assertAll();
		
		
	}
	
	@Test(priority = 19)
    
	public void saveBtnVisiblity() {
		 WebElement save=ad.getSavebtn();
		 assertTrue(save.isDisplayed() , "Save button is not displayed !");
	}
	
    @Test(priority = 19)
    
	public void saveBtnEnablity() {
		 WebElement save=ad.getSavebtn();
		 assertTrue(save.isEnabled() , "Save button is not enablaed  !");
	}
    
    @Test(priority = 20)
    public void saveBtnClickVerify() throws InterruptedException{
    	 WebElement save=ad.getSavebtn();
    	 save.click();
    	 String parentpageUrl=prop.getVal("Admin");
    	 wait.until(ExpectedConditions.urlToBe(parentpageUrl));
    	 assertEquals(parentpageUrl, driver.getCurrentUrl() , "save button is not navigating to corret page !");
    	
    }

    
    
    //-----------Testing parent page of Admin Module
    
    @Test(priority = 21 , enabled = false)
    public void verifyUsernameFieldVisiblityMainPage() {
    	
    	WebElement field=ad.getMainPageUsernameField();
    	System.out.println(field.isDisplayed() + " field " + field.getLocation());
    	
    	assertTrue(field.isDisplayed() , "User Name page field is displayed !");
    	
    }
    
    @Test(priority = 21)
    public void verifyUsernameFieldEnablityMainPage() {
    	WebElement field=ad.getMainPageUsernameField();
    	
    	assertTrue(field.isEnabled() , "User Name page field is Enabaled  !");
    	field.sendKeys(username);
    	
    }
    
    
    
    @Test(priority = 23)
    public void verifyUserRoleFieldVisiblityMainPage() {
    	WebElement role=ad.getSelectrole();
    	assertTrue(role.isDisplayed() , "Role Selection is not visible !");
    }
   
    @Test(priority = 23)
    public void verifyUserRoleEnablityMainPage() {
    	WebElement role=ad.getSelectrole();
    	assertTrue(role.isEnabled() , "Role Selection is not Enabled !");
    }
    
    @Test(priority = 24)
    public void verifyUserRoleoptionsVisiblity() {
    	WebElement role=ad.getSelectrole();
    	Actions act = new Actions(driver);
    	act.click(role).perform();
    	WebElement options=ad.getUserddOptions();
    	assertTrue(options.isDisplayed() , "options are are displayed !");
    }
    @Test(priority = 25)
    public void verifyUserRoleoptionsEnablity() {
    	
       List<WebElement> options= ad.getUserddOptionsList();
       
       for (WebElement opt : options) {
    	   assertTrue(opt.isEnabled() , "options are not enabled !  "+opt.getText());
	   }
       
    	
    }
    
    @Test(priority = 26)
    public void verifyUserRoleoptionsSelection() {
    	
       List<WebElement> options= ad.getUserddOptionsList();
       
       WebElement adminopt= options.get(0);
       Actions act = new Actions(driver);
   	   act.click(adminopt).perform();
   	   
       
    	
    }
    
    
    @Test(priority = 27)
    public void verifyEmpNameFieldVisiblity() {
    	 WebElement empname = ad.getEmpName();
    	 assertTrue(empname.isDisplayed() , "Empname field is not visible");
    }
    
    @Test(priority = 28)
    public void verifyEmpNameFieldEnablity() {
    	 WebElement empname = ad.getEmpName();
    	 assertTrue(empname.isEnabled() , "Empname field is not enabled !");
    }
    
    @Test(priority = 29)
    public void verifyEmpNameFieldWorking() {
    	 WebElement empname = ad.getEmpName();
    	 
    	 String username=ad.getUsername().getText();
    	 
    	 empname.clear();
    	 empname.sendKeys(username);
         driver.findElement(By.xpath("//div[@role='option']/span")).click();
         
    	 
    	 
  
    }
    
    @Test(priority = 30)
    public void verifyStatusFieldvisiblity() {
           WebElement sel=	ad.getSelectText();
           assertTrue(sel.isDisplayed() , "Select field is not displayed !");
           assertTrue(sel.isEnabled() , "Select field is not enabaled  !");
           Actions act =new Actions(driver);
           act.click(sel).perform();;
           
    }
    
    @Test(priority = 31)

    public void verifyStatusOptions() {
      List<WebElement> list = ad.getSelectStatusDropdown_addAdmin();
      for (WebElement opt : list) {
		   assertTrue(opt.isDisplayed() , "option is not displayed !");;
		   assertTrue(opt.isEnabled() , "option is not enabaled !");;
	 }
      driver.findElement(By.xpath("//div[@class='oxd-select-dropdown --positon-bottom'] /div[2]/span")).click();
     // list.get(0).click();
      
    }
    
    @Test(priority = 32)
    public void verifySearchBtnVisiblity() {
    	WebElement searchbtn=ad.getSearchBtn();
    	assertTrue(searchbtn.isDisplayed( ) , "Seacrh Button is not displaed !" );
    }
   
    @Test(priority = 33)
    public void verifySearchBtnEnablaed() {
    	WebElement searchbtn=ad.getSearchBtn();
    	assertTrue(searchbtn.isEnabled( ) , "Seacrh Button is not Enabaled  !" );
    }
    
    @Test(priority = 34)
    public void verifyResetBtnVisiblity() {
    	WebElement resetbtn = ad.getReset();
    	assertTrue(resetbtn.isDisplayed()  , "Reset button is not displayed !");
    }
    

    @Test(priority = 35)
    public void verifyResetBtnEnabaled() {
    	WebElement resetbtn = ad.getReset();
    	assertTrue(resetbtn.isEnabled()  , "Reset button is not Enabaled  !");
    }
    
    @Test(priority = 36)
    public void searchUser() {
    	WebElement search = ad.getSearchBtn();
    	search.click();
    	
    }
    
    
    @Test(priority = 37)
    public void verifyAddedUser() {
       WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='oxd-table-card'])[1]")));
       assertTrue(result.isDisplayed() , "Search functionality not working !");
    }
    
    
    @Test(priority = 38)
    public void verifyJobSpan()throws InterruptedException {
      WebElement jobspan = wait.until(ExpectedConditions.visibilityOf(ad.getJobSpan()));
      assertTrue(jobspan.isDisplayed() , "job link is not visible");
      assertTrue(jobspan.isEnabled() , "job link is not enabaled");
      //driver.navigate().refresh();
     
     
    }
    @Test(priority = 39)
    public void verifyJobSpanDropDown() throws InterruptedException {
    	 WebElement jobspan = wait.until(ExpectedConditions.visibilityOf(ad.getJobSpan()));
         jobspan.click();
     
        	  WebElement dropdown = wait.until(ExpectedConditions.visibilityOf(ad.getCommonDropDown()));
        	  assertTrue(dropdown.isDisplayed() , "DropDown is not visible ");
        	  assertTrue(dropdown.isEnabled() , "DropDown is not visible ");
        	 
        	
    }
    @Test(priority = 40)
   public void verifyJobSpanAllDropDownLinks() {
    	 WebElement jobspan = wait.until(ExpectedConditions.visibilityOf(ad.getJobSpan()));
         jobspan.click();
         
        List<WebElement> list = ad.getCommon_dropdownOptions();
         System.out.println("_______________________");
         int elements=list.size();
         
         for (int i = 0; i < elements; i++) {
			WebElement wb = list.get(i);
			String aText=wb.getText().replaceAll(" ", "_");
			
		    String expectedLink=prop.getVal(aText);
		
			wb.click();
			
			wait.until(ExpectedConditions.elementToBeClickable(ad.getJobSpan()));
			
			assertEquals(expectedLink, driver.getCurrentUrl() , aText+" expected and  actual link is not working ");;
 		    jobspan = wait.until(ExpectedConditions.visibilityOf(ad.getJobSpan()));
 	        jobspan.click();
 	        wait.until(ExpectedConditions.visibilityOf(ad.getCommonDropDown()));
 	         
	        list=ad.getCommon_dropdownOptions();
	         
	         
	         
		 }
         
       
         
    } 
    
    @Test(priority = 41)
    public void verifyOrgSpan() {
    WebElement org = wait.until(ExpectedConditions.visibilityOf(ad.getOrgSpan()));
    assertTrue(org.isDisplayed() , "The organization link is not displayed ");
    assertTrue(org.isEnabled() , "The organization link is not enabaled ");
    
    }
    
    @Test(priority =42)
    public void verifyOrgSpanDropDown() {
    WebElement org = wait.until(ExpectedConditions.visibilityOf(ad.getOrgSpan()));
    org.click();
    
    WebElement dropdown = wait.until(ExpectedConditions.visibilityOf(ad.getCommonDropDown()));
    assertTrue(dropdown.isDisplayed() , "drop is not displayed ");
    assertTrue(dropdown.isEnabled() , "drop is not enabaled  ");
    
    }
    
    
    @Test(priority = 43)
    public void verifyOrgSpanDropDownLinks() {
    WebElement org = wait.until(ExpectedConditions.visibilityOf(ad.getOrgSpan()));
    org.click();
    WebElement dropdown = wait.until(ExpectedConditions.visibilityOf(ad.getCommonDropDown()));
    List<WebElement> list = ad.getCommon_dropdownOptions();
    
    int count=list.size();
   
    for (int i = 0; i <count; i++) {
       WebElement wb = list.get(i);
	   String atext=wb.getText().replaceAll(" ", "_");;
	   String expectedUrl=prop.getVal(atext);
	   
	   wb.click();
	   
	   wait.until(ExpectedConditions.elementToBeClickable(ad.getOrgSpan()));
	   System.out.println(atext);
	   System.out.println(expectedUrl);
	   System.out.println(driver.getCurrentUrl());
	   assertEquals(expectedUrl, driver.getCurrentUrl() , atext+" expected and  actual link is not working ");
	    
	   org = wait.until(ExpectedConditions.visibilityOf(ad.getJobSpan()));
        org.click();
        wait.until(ExpectedConditions.visibilityOf(ad.getCommonDropDown()));
         
       list=ad.getCommon_dropdownOptions();
	   
	
    	
	}
    
    
    
    }
    
    @Test(priority = 44)
    public void verifyQualificationSpan() {
    WebElement qualification = wait.until(ExpectedConditions.visibilityOf(ad.getQualificationSpan()));
    assertTrue(qualification.isDisplayed() , "The organization link is not displayed ");
    assertTrue(qualification.isEnabled() , "The organization link is not enabaled ");
    
    }
    
    @Test(priority =45)
    public void verifyQualificationSpanDropDown() {
    WebElement qualification = wait.until(ExpectedConditions.visibilityOf(ad.getQualificationSpan()));
    qualification.click();
    
    WebElement dropdown = wait.until(ExpectedConditions.visibilityOf(ad.getCommonDropDown()));
    assertTrue(dropdown.isDisplayed() , "drop is not displayed ");
    assertTrue(dropdown.isEnabled() , "drop is not enabaled  ");
    
    }
    
    
    @Test(priority = 46)
    public void verifyQualificationSpanDropDownLinks() {
    WebElement qualification = wait.until(ExpectedConditions.visibilityOf(ad.getQualificationSpan()));
    qualification.click();
    WebElement dropdown = wait.until(ExpectedConditions.visibilityOf(ad.getCommonDropDown()));
    List<WebElement> list = ad.getCommon_dropdownOptions();
    
    int count=list.size();
   
    for (int i = 0; i <count; i++) {
       WebElement wb = list.get(i);
	   String atext=wb.getText().replaceAll(" ", "_");;
	   String expectedUrl=prop.getVal(atext);
	   
	   wb.click();
	   
	   wait.until(ExpectedConditions.elementToBeClickable(ad.getOrgSpan()));
	   System.out.println("_____________________");
	   System.out.println(atext);
	   System.out.println(expectedUrl);
	   System.out.println(driver.getCurrentUrl());
	   System.out.println("_____________________");
	   assertEquals(expectedUrl, driver.getCurrentUrl() , atext+" expected and  actual link is not working ");
	    
	   qualification = wait.until(ExpectedConditions.visibilityOf(ad.getQualificationSpan()));
        qualification.click();
        wait.until(ExpectedConditions.visibilityOf(ad.getCommonDropDown()));
         
       list=ad.getCommon_dropdownOptions();
	   
	
    	
	}
    
    
    
    
    }
    @Test(priority = 47)
    public void verifyNationalitySpan() {
    WebElement natinality = wait.until(ExpectedConditions.visibilityOf(ad.getNationality()));
    assertTrue(natinality.isDisplayed() , "The organization link is not displayed ");
    assertTrue(natinality.isEnabled() , "The organization link is not enabaled ");
    
    }
    
    @Test(priority =48)
    public void verifyNationalitySpanLink() {
    WebElement natinality = wait.until(ExpectedConditions.visibilityOf(ad.getNationality()));
    natinality.click();
    
    WebElement dropdown = wait.until(ExpectedConditions.visibilityOf(ad.getNationality()));
    
    String expectedurl=prop.getVal("Nationalities");
    String actaulUrl=driver.getCurrentUrl();
    assertEquals(expectedurl, actaulUrl);
    
    }
    @Test(priority = 49)
    public void verifyCorporate_BrandingSpan() {
    WebElement corpBranding = wait.until(ExpectedConditions.visibilityOf(ad.getNationality()));
    assertTrue(corpBranding.isDisplayed() , "The organization link is not displayed ");
    assertTrue(corpBranding.isEnabled() , "The organization link is not enabaled ");
    
    }
    
    @Test(priority =50)
    public void verifyCorporate_BrandingSpanLink() {
    WebElement corpBranding = wait.until(ExpectedConditions.visibilityOf(ad.getCorporate()));
    corpBranding.click();
    
    WebElement dropdown = wait.until(ExpectedConditions.visibilityOf(ad.getCorporate()));
    
    String expectedurl=prop.getVal("Corporate_Branding");
    String actaulUrl=driver.getCurrentUrl();
    assertEquals(expectedurl, actaulUrl);
    
    }
       
    
   
   
  
    @Test(priority = 51)
    public void verifyConfiSpan() {
    WebElement config = wait.until(ExpectedConditions.visibilityOf(ad.getConfig()));
    assertTrue(config.isDisplayed() , "The config link is not displayed ");
    assertTrue(config.isEnabled() , "The config link is not enabaled ");
    
    }
    
    @Test(priority =52)
    public void verifyConfiSpanDropDown() {
    WebElement config = wait.until(ExpectedConditions.visibilityOf(ad.getConfig()));
    config.click();
    
    WebElement dropdown = wait.until(ExpectedConditions.visibilityOf(ad.getCommonDropDown()));
    assertTrue(dropdown.isDisplayed() , "drop is not displayed ");
    assertTrue(dropdown.isEnabled() , "drop is not enabaled  ");
    
    }
    
    
    @Test(priority = 53)
    public void verifyConfiSpanDropDownLinks() {
    WebElement config = wait.until(ExpectedConditions.visibilityOf(ad.getConfig()));
    config.click();
    WebElement dropdown = wait.until(ExpectedConditions.visibilityOf(ad.getCommonDropDown()));
    List<WebElement> list = ad.getCommon_dropdownOptions();
    
    int count=list.size();
   
    for (int i = 0; i <count; i++) {
       WebElement wb = list.get(i);
	   String atext=wb.getText().replaceAll(" ", "_");;
	   String expectedUrl=prop.getVal(atext);
	   
	   wb.click();
	   
	   wait.until(ExpectedConditions.elementToBeClickable(ad.getConfig()));
	   System.out.println("_____________________");
	   System.out.println(atext);
	   System.out.println(expectedUrl);
	   System.out.println(driver.getCurrentUrl());
	   System.out.println("_____________________");
	   assertEquals(expectedUrl, driver.getCurrentUrl() , atext+" expected and  actual link is not working ");
	    
	   config = wait.until(ExpectedConditions.visibilityOf(ad.getConfig()));
        config.click();
        wait.until(ExpectedConditions.visibilityOf(ad.getCommonDropDown()));
         
       list=ad.getCommon_dropdownOptions();
	   
	
    	
	}
    
    
    
    
    }
	
    @Test(priority = 54)
    public void verifyFooter() {
    	SoftAssert sa = new SoftAssert();
    	
    	WebElement footer = ad.getFooter();
    	sa.assertTrue(footer.isDisplayed() , "Footer is not displayed !");
    	
    }
	
	
	
	@AfterClass
	public void loggout() {
		
		
	       Actions act  = new Actions(driver);
			
			WebElement username= driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
			act.click(username).perform();
			
		     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		     
		    WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class=\"oxd-userdropdown-link\"])[4]")));
		    ele.click();
	}
}
