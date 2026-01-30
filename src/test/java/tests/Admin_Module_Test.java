package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import com.crm.pom.Admin_Module;
import com.crm.utility.BaseWebdriver;

public class Admin_Module_Test extends BaseWebdriver {

	
	public Admin_Module ad;
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	@BeforeMethod
	public void setUp() {
		ad=new Admin_Module(driver);
		ad.getAdminBtn().click();
		//wait.until(ExpectedConditions.urlToBe(""))
		
		
	}
}
