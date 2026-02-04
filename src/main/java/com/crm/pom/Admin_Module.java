package com.crm.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_Module {

	public Admin_Module(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//----------Main Page ----------------------
	
	@FindBy(xpath = "(//a[@class='oxd-main-menu-item'])[1]")
	private WebElement adminBtn;
	
	public WebElement getAdminBtn() {
		return adminBtn;
	}
	
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement mainPageUsernameField;
	
	

	@FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[1]")
	private WebElement selectrole;
	
	@FindBy(xpath = "(//input)[3]")
	private WebElement empName;
	
	
	@FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
	private WebElement selectStatusdropdown;
	
	@FindBy(xpath = "(//div[@class='oxd-select-text-input'])[2]")
	private WebElement selectText;
   
	

	public WebElement getSelectText() {
		return selectText;
	}

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	private WebElement addAdminBtn;
	
	
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
    private WebElement reset;
    
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchBtn;
    
    @FindBy(xpath = "//div[@class='oxd-table-card']")
    private WebElement seacrhresults;
    
    @FindBy(xpath = "//div[@clASS='oxd-layout-footer']/P[2]")
    private WebElement footer;
   
    
    //-----------Add admin page----------------
    
    @FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active']")
    private WebElement userRoledd;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement empNameFeild;
    
    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[2]")
    private WebElement statusSelect;
    
    @FindBy(xpath = "(//input)[3]")
    private WebElement userNameAddAdminPage;
    
    @FindBy(xpath = "//div[@class='oxd-select-dropdown --positon-bottom']/div")
    private List<WebElement> selectStatusDropdown_addAdmin;
    
    public List<WebElement> getSelectStatusDropdown_addAdmin() {
		return selectStatusDropdown_addAdmin;
	}

	@FindBy(xpath = "//input[@type='password']")
    private WebElement password;
    
    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement confmPass;
    
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-form-hint']")
    private WebElement requiredMsg;
    
    @FindBy(xpath = "(//button[@type='button'])[4]")
    private WebElement cancelbtn;
    
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement savebtn;
    
 
    
    @FindBy(xpath = "//div[@class='oxd-select-dropdown --positon-bottom']")
    private WebElement userddOptions;
    
    @FindBy(xpath = "//div[@class='oxd-select-option']/span")
    private List<WebElement>userddOptionsList;
    
    public List<WebElement> getUserddOptionsList() {
		return userddOptionsList;
	}

	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    private WebElement username;
	
	@FindBy(xpath = "//div[@class='oxd-autocomplete-dropdown --positon-bottom']")
	private WebElement empnamehints;
	
	@FindBy(xpath = "//div[@role='option']")
	private List<WebElement> hintoptions;
    //----------------Geters----------------

	


	public List<WebElement> getHintoptions() {
		return hintoptions;
	}


	public WebElement getCancelbtn() {
		return cancelbtn;
	}


	public WebElement getEmpnamehints() {
		return empnamehints;
	}


	public WebElement getUserddOptions() {
		return userddOptions;
	}


	public WebElement getMainPageUsernameField() {
		return mainPageUsernameField;
	}
	

	public WebElement getSelectrole() {
		return selectrole;
	}

	public WebElement getEmpName() {
		return empName;
	}
	
	

	public WebElement getSelectStatusdropdown() {
		return selectStatusdropdown;
	}

	public WebElement getAddAdminBtn() {
		return addAdminBtn;
	}

	public WebElement getReset() {
		return reset;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSeacrhresults() {
		return seacrhresults;
	}

	public WebElement getFooter() {
		return footer;
	}

	public WebElement getUserRoledd() {
		return userRoledd;
	}
	

	public WebElement getEmpNameFeild() {
		return empNameFeild;
	}
	

	public WebElement getStatusSelect() {
		return statusSelect;
	}

	public WebElement getUserNameAddAdminPage() {
		return userNameAddAdminPage;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getConfmPass() {
		return confmPass;
	}

	public WebElement getRequiredMsg() {
		return requiredMsg;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getcancelbtn() {
		return cancelbtn;
	}


	public WebElement getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
    
    //______________Quick navigation items Admin Page________________________
	
	@FindBy(xpath = "(//span[@class='oxd-topbar-body-nav-tab-item'])[2]")
	private WebElement jobSpan;
	
	
	
	@FindBy(xpath = "//ul[@class='oxd-dropdown-menu']")
	private WebElement commonDropDown;
	
	
	@FindBy(xpath = "//a[@role='menuitem']")
	private List<WebElement>common_dropdownOptions;

	@FindBy(xpath = "(//span[@class='oxd-topbar-body-nav-tab-item'])[3]")
	private WebElement orgSpan;
	
	
	@FindBy(xpath = "(//span[@class='oxd-topbar-body-nav-tab-item'])[4]")
	private WebElement qualificationSpan;
	
	@FindBy(xpath = "(//a[@class='oxd-topbar-body-nav-tab-item'])[1]")
	
	private WebElement nationality;
	
	@FindBy(xpath = "(//a[@class='oxd-topbar-body-nav-tab-item'])[2]")
	private WebElement corporate;
	
	@FindBy(xpath = "(//span[@class='oxd-topbar-body-nav-tab-item'])[5]")
	private WebElement config;

	public WebElement getJobSpan() {
		return jobSpan;
	}


	public WebElement getCommonDropDown() {
		return commonDropDown;
	}


	public List<WebElement> getCommon_dropdownOptions() {
		return common_dropdownOptions;
	}


	public WebElement getOrgSpan() {
		return orgSpan;
	}


	public WebElement getQualificationSpan() {
		return qualificationSpan;
	}


	public WebElement getNationality() {
		return nationality;
	}


	public WebElement getCorporate() {
		return corporate;
	}


	public WebElement getConfig() {
		return config;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
	
	

