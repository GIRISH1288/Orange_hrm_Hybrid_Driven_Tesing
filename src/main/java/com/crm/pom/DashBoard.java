package com.crm.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoard {
	

	public DashBoard(WebDriver driver ) {
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(xpath ="//div[@class='oxd-grid-3 orangehrm-dashboard-grid']")
	private WebElement widgetgrid;
	
	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	private WebElement username;
	
	@FindBy(xpath ="//li[@class='oxd-userdropdown']")
	private WebElement profileIcon;
	
	@FindBy(xpath = "//nav[@class='oxd-navbar-nav']")
	private WebElement navbarItems;
	
	@FindBy(xpath = "//div[@class='oxd-grid-3 orangehrm-quick-launch']")
	private WebElement quickLaunchparent;
	
	@FindBy(xpath ="//div[@class='emp-attendance-chart']")
	private WebElement chart;
	
	@FindBy(xpath = "//img[@class='oxd-userdropdown-img']")
	private WebElement profilepicture;
	
	@FindBy(xpath = "//ul[@class='oxd-dropdown-menu']")
	private WebElement dropdownmenu;
	
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p --text']")
	private List<WebElement>quicklaunchItemsText;
	
	@FindBy(xpath = "//button[@class='oxd-icon-button orangehrm-quick-launch-icon']")
	private List<WebElement>quickLaunch_buttons;
	
	@FindBy(xpath = "//button[@class='oxd-icon-button']")
	private  WebElement questionmark;
	
	@FindBy(xpath = "//button[@class='oxd-glass-button orangehrm-upgrade-button']")
	private WebElement upgrade;
	
	@FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-buzz-widget-card']")
	private WebElement buzzpost;
	
	@FindBy(xpath = "//textarea[@class='oxd-buzz-post-input']")
	private WebElement postTextarea;
	
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--main']")
	private WebElement postbutton;
	
	@FindBy(xpath = "(//p[@class=\"oxd-text oxd-text--p orangehrm-buzz-post-body-text\"])[1]")
	private WebElement recentpostTesxt;
	
	@FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']")
	private WebElement posts;
	//contains img , text evevrything uska parent hai 
	
	@FindBy(xpath = "//button[@class='oxd-glass-button']")
	private WebElement postphotosbtn;
	
	
	@FindBy(xpath = "//input[@class='oxd-file-input']")
	private WebElement uploadimg;

	@FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget']")
	private  List<WebElement> widgetItems;

	@FindBy(xpath = "//a[@class='oxd-userdropdown-link']")
	private List<WebElement> dropdownitems;
	
	public List<WebElement> getDropdownitems() {
		return dropdownitems;
	}


	public List<WebElement> getWidgetItems() {
		return widgetItems;
	}


	public WebElement getWidgetgrid() {
		return widgetgrid;
	}


	public WebElement getUsername() {
		return username;
	}


	public WebElement getProfileIcon() {
		return profileIcon;
	}


	public WebElement getNavbarItems() {
		return navbarItems;
	}


	public WebElement getQuickLaunchparent() {
		return quickLaunchparent;
	}


	public WebElement getChart() {
		return chart;
	}


	public WebElement getProfilepicture() {
		return profilepicture;
	}


	public WebElement getDropdownmenu() {
		return dropdownmenu;
	}


	public List<WebElement> getQuicklaunchItemsText() {
		return quicklaunchItemsText;
	}


	public List<WebElement> getQuickLaunch_buttons() {
		return quickLaunch_buttons;
	}


	public WebElement getQuestionmark() {
		return questionmark;
	}


	public WebElement getUpgrade() {
		return upgrade;
	}


	public WebElement getBuzzpost() {
		return buzzpost;
	}


	public WebElement getPostTextarea() {
		return postTextarea;
	}


	public WebElement getPostbutton() {
		return postbutton;
	}


	public WebElement getRecentpostTesxt() {
		return recentpostTesxt;
	}


	public WebElement getPosts() {
		return posts;
	}


	public WebElement getPostphotosbtn() {
		return postphotosbtn;
	}


	public WebElement getUploadimg() {
		return uploadimg;
	}
	
	
	
	
	
	
	
	
	
	

	
}
