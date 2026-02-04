package com.crm.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class Profile {

	
	public Profile(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	private WebElement username;
	
	@FindBy(xpath = "(//a[@class='oxd-userdropdown-link'])[1]")
	private WebElement aboutLink;
	
	@FindBy(xpath = "(//a[@class='oxd-userdropdown-link'])[2]")
	private WebElement supportlink;
	
	@FindBy(xpath = "(//a[@class='oxd-userdropdown-link'])[3]")
	private WebElement chngepass;
	
	@FindBy(xpath = "(//a[@class='oxd-userdropdown-link'])[4]")
	private WebElement Logout;
	
	@FindBy(xpath = "(//a[@class='oxd-userdropdown-link'])")
	private List<WebElement>allLinks;
	
	@FindBy(xpath = "//ul[@class='oxd-dropdown-menu']")
	private  WebElement dropDownmenu;
	
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement ctPass;
	
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
	private WebElement newPass;
	
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[4]")
	private WebElement confPass;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement save;
	
	@FindBy(xpath = "(//button[@type='button'])[4]")
	private WebElement cancel;
	//_______________________________________________________________
	
	

	public WebElement getCtPass() {
		return ctPass;
	}

	public WebElement getNewPass() {
		return newPass;
	}

	public WebElement getConfPass() {
		return confPass;
	}

	public WebElement getSave() {
		return save;
	}

	public WebElement getCancel() {
		return cancel;
	}

	public WebElement getDropDownmenu() {
		return dropDownmenu;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getAboutLink() {
		return aboutLink;
	}

	public WebElement getSupportlink() {
		return supportlink;
	}

	public WebElement getChngepass() {
		return chngepass;
	}

	public WebElement getLogout() {
		return Logout;
	}

	public List<WebElement> getAllLinks() {
		return allLinks;
	}
	
	
}
