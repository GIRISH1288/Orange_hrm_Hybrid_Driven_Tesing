package com.crm.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(xpath = "oxd-userdropdown-link")
	private List<WebElement>allLinks;

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
