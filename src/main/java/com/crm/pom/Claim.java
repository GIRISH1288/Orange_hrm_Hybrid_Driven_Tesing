package com.crm.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Claim {

	public Claim(WebDriver driver ) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//span[text()='Claim']")
	private WebElement claimlink;
	
	@FindBy(xpath = "//li[contains(@class , 'oxd-topbar-body-nav-tab')]")
	private List<WebElement>claimtabs;
	
	//myclaimsrefferce 
	@FindBy(xpath = "//div[@class='oxd-autocomplete-text-input--before']/following-sibling::input")
	private WebElement reffrenceId;
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
	private WebElement Eventarrow;
	
	@FindBy(xpath = "(//i[@class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"])[2]")
	private WebElement statusArrow;
	
	@FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and  @placeholder='yyyy-dd-mm']")
	private WebElement fromdate;
	
	@FindBy(xpath ="(//input[@class='oxd-input oxd-input--active' and  @placeholder='yyyy-dd-mm'])[2]")
	private WebElement todate;
	
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	private WebElement searchbtn;
	
	
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
	private WebElement resertbtn;

	//For assign claims :
	
	@FindBy(xpath = "//a[text()='Assign Claim']")
	private WebElement assignclaimsEle;
	
	@FindBy(xpath = "//div[@class='oxd-autocomplete-text-input--before']/following-sibling::input")
	private WebElement textArea;
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
	private WebElement eventArrow;
	
	@FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")
	private WebElement currencyarrow;
	
	@FindBy(xpath = "//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")
	private WebElement remarks;
	
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	private WebElement createBtn;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
	private WebElement cancelBtn;

	public WebElement getAssignclaimsEle() {
		return assignclaimsEle;
	}


	public WebElement getTextArea() {
		return textArea;
	}


	public WebElement getEventArrow() {
		return eventArrow;
	}


	public WebElement getCurrencyarrow() {
		return currencyarrow;
	}


	public WebElement getRemarks() {
		return remarks;
	}


	public WebElement getCreateBtn() {
		return createBtn;
	}


	public WebElement getCancelBtn() {
		return cancelBtn;
	}


	public WebElement getClaimlink() {
		return claimlink;
	}


	public List<WebElement> getClaimtabs() {
		return claimtabs;
	}


	public WebElement getReffrenceId() {
		return reffrenceId;
	}


	public WebElement getEventarrow() {
		return Eventarrow;
	}


	public WebElement getStatusArrow() {
		return statusArrow;
	}


	public WebElement getFromdate() {
		return fromdate;
	}


	public WebElement getTodate() {
		return todate;
	}


	public WebElement getSearchbtn() {
		return searchbtn;
	}


	public WebElement getResertbtn() {
		return resertbtn;
	}
	
	
	
	
}
