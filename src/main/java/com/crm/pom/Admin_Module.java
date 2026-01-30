package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_Module {

	public Admin_Module(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[@class='oxd-main-menu-item'])[1]")
	private WebElement adminBtn;
	
	public WebElement getAdminBtn() {
		return adminBtn;
	}

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	private WebElement addAdminBtn;
	
	@FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[1]")
	private WebElement selectrole;
	
	@FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
	private WebElement statusSelect;
	
	@FindBy(xpath = "//div[@class='oxd-autocomplete-text-input--before']/following-sibling::input")
	private WebElement emp_name;
	
	@FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[2]")
	private WebElement username_field;
	
	@FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[3]")
	private WebElement pass;
	
	@FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[4]")
	private WebElement confirmPass;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	private WebElement submitBtn;

	public WebElement getAddAdminBtn() {
		return addAdminBtn;
	}

	public WebElement getSelectrole() {
		return selectrole;
	}

	public WebElement getStatusSelect() {
		return statusSelect;
	}

	public WebElement getEmp_name() {
		return emp_name;
	}

	public WebElement getUsername_field() {
		return username_field;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getConfirmPass() {
		return confirmPass;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	
}
