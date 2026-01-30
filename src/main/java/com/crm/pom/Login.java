package com.crm.pom;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.utility.BaseClass;


public class Login {

	
	
	public Login(WebDriver driver ) {
	PageFactory.initElements(driver, this);
		
	}
	
	  
	@FindBy(xpath="//input[@name='username']")
	private WebElement  username;
	
	@FindBy(name="password")
	private WebElement passs;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loggin_button;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
	private WebElement required_field;
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	private WebElement invalid_credentials;
	

	@FindBy(xpath="(//img)[2]")
	private WebElement logo;
	
	@FindBy(xpath="//div[@class='oxd-layout-context']")
	private WebElement dashboard;
	
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	private WebElement forgotpass;
	
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--large oxd-button--secondary orangehrm-forgot-password-button orangehrm-forgot-password-button--reset']")
	private WebElement resetPass;
	
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--large oxd-button--ghost orangehrm-forgot-password-button orangehrm-forgot-password-button--cancel']")
	private WebElement cancel;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernameResetPassPage;
	
	
	
	public WebElement getResetPass() {
		return resetPass;
	}







	public WebElement getCancel() {
		return cancel;
	}







	public WebElement getUsernameResetPassPage() {
		return usernameResetPassPage;
	}







	public WebElement getForgotpass() {
		return forgotpass;
	}


	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	private WebElement usernameDrop;
	
	
	public WebElement getUsernameDrop() {
		return usernameDrop;
	}
	
	


	


	public WebElement getLogo() {
		return logo;
	}


	public WebElement getDashboard() {
		return dashboard;
	}


	public WebElement getUsername() {
		return username;
	}


	public WebElement getPasss() {
		return passs;
	}

	

	public WebElement getLoggin_button() {
		return loggin_button;
	}
	
	public void login(String user, String pass) {
		username.clear();
		passs.clear();
		username.sendKeys(user);
		passs.sendKeys(pass);
		loggin_button.click();
		}
	
	public void logout() {
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(10));


		// Click username dropdown
		wait.until(ExpectedConditions.elementToBeClickable(usernameDrop)).click();


		// Click logout
		WebElement logout =
		wait.until(ExpectedConditions.elementToBeClickable(
		By.xpath("(//a[@class='oxd-userdropdown-link'])[4]")
		));
		logout.click();
		}

	

	public WebElement getRequired_field() {
		return required_field;
	}


	public WebElement getInvalid_credentials() {
		return invalid_credentials;
	}


}
