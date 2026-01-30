package com.crm.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 */
public class Navbar {
	
	public Navbar(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[contains(@class,'oxd-input')]")
	private WebElement searchfeild;
	
	
	
	@FindBy(xpath = "//a[@class='oxd-main-menu-item']")
	private List<WebElement> mainmenuoptionsLinks ;
	
	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")
	private List<WebElement> mainmenuoptionsTexts ;
	
	
	
	@FindBy(xpath = "//button[@class='oxd-icon-button oxd-main-menu-button']")
	private WebElement menusideBtn;

	@FindBy(xpath = "//a[@class='oxd-main-menu-item active']")
	private WebElement dashboard;

	public WebElement getSearchfeild() {
		return searchfeild;
	}


	public List<WebElement> getMainmenuoptionsLinks() {
		
		return mainmenuoptionsLinks;
	}


	public WebElement getMenusideBtn() {
		return menusideBtn;
	}


	public WebElement getDashboard() {
		return dashboard;
	}


	public List<WebElement> getMainmenuoptionsTexts() {
		
		return mainmenuoptionsTexts;
	}


	public WebElement getEle() {
		return menusideBtn;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	

}