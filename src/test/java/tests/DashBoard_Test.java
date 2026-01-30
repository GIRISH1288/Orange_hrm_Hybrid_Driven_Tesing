package tests;

import com.crm.utility.BaseWebdriver;
import com.crm.utility.Login_Orange;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.pom.DashBoard;

public class DashBoard_Test extends BaseWebdriver {

	public DashBoard dashboard;

	// ---------- SETUP ----------

	@BeforeMethod
	public void setUp() {
		dashboard = new DashBoard(driver);
		String expectedLink = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

		String actLink = driver.getCurrentUrl();
		Assert.assertEquals(actLink, expectedLink, "Expected and actual link is not matching!");
	}

	// ---------- BASIC DASHBOARD ----------

	@Test(priority = 0)
	public void verifyDashBoardAfterLogin() {
		Assert.assertTrue(dashboard.getWidgetgrid().isDisplayed(), "Dashboard is not visible after login");
	}

	@Test(priority = 1)
	public void verifyNavbarVisibility() {
		Assert.assertTrue(dashboard.getNavbarItems().isDisplayed(), "Navbar items not visible!");
	}

	@Test(priority = 3)
	public void verifyProfileIconDisplayed() {
		Assert.assertTrue(dashboard.getProfileIcon().isDisplayed(), "Profile Icon is not displayed!");
	}

	// ---------- PROFILE DROPDOWN ----------

	@Test(priority = 4)
	public void verifyProfileDropdownVisibility() {
		Actions act = new Actions(driver);
		act.click(dashboard.getProfileIcon()).perform();

		Assert.assertTrue(dashboard.getDropdownmenu().isDisplayed(), "Dropdown menu is not visible!");

		for (WebElement wb : dashboard.getDropdownitems()) {
			Assert.assertTrue(wb.isEnabled(), "Dropdown item is not enabled!");
		}
	}

	// ---------- QUICK LAUNCH (STATE) ----------

	@Test(priority = 5)
	public void verifyQuickLaunchButtonsEnabled() {
		for (WebElement wb : dashboard.getQuickLaunch_buttons()) {
			Assert.assertTrue(wb.isEnabled(), "Quick launch button is not enabled!");
		}
	}

	// ---------- CHART ----------

	@Test(priority = 6)
	public void verifyChartsDisplayed() {
		Assert.assertTrue(dashboard.getChart().isDisplayed(), "Charts are not available!");
	}

	// ---------- WIDGET TEXT VERIFICATION (SPLIT TESTS) ----------

	@Test(priority = 7)
	public void verifyWidget_TimeAtWork() {
		verifyWidgetByIndex(1);
	}

	@Test(priority = 7)
	public void verifyWidget_MyActions() {
		verifyWidgetByIndex(2);
	}

	@Test(priority = 7)
	public void verifyWidget_QuickLaunch() {
		verifyWidgetByIndex(3);
	}

	@Test(priority = 7)
	public void verifyWidget_EmployeesOnLeave() {
		verifyWidgetByIndex(4);
	}

	@Test(priority = 7)
	public void verifyWidget_DistributionBySubUnit() {
		verifyWidgetByIndex(5);
	}

	@Test(priority = 7)
	public void verifyWidget_DistributionByLocation() {
		verifyWidgetByIndex(6);
	}

	private void verifyWidgetByIndex(int index) {

		List<WebElement> widgetList = dashboard.getWidgetItems();
		WebElement wb = widgetList.get(index - 1);

		String actualText = wb.findElement(By.xpath(".//div[@class='orangehrm-dashboard-widget-header']/div/p"))
				.getText().strip();

		String expectedText = prop.getVal(String.valueOf(index)).strip();

		Assert.assertEquals(actualText, expectedText, "Widget item text not matching!");
	}

	// ---------- QUICK LAUNCH NAVIGATION (SPLIT TESTS) ----------

	@Test(priority = 9)
	public void verifyQuickLaunch_FirstButton() {
		verifyQuickLaunchByIndex(0);
	}

	@Test(priority = 9)
	public void verifyQuickLaunch_SecondButton() {
		verifyQuickLaunchByIndex(1);
	}

	@Test(priority = 9)
	public void verifyQuickLaunch_ThirdButton() {
		verifyQuickLaunchByIndex(2);
	}

	private void verifyQuickLaunchByIndex(int index) {

		List<WebElement> buttons = dashboard.getQuickLaunch_buttons();
		WebElement btn = buttons.get(index);

		String titleKey = btn.getAttribute("title").replaceAll("\\s", "").strip();

		btn.click();

		if (driver.getCurrentUrl().contains("login")) {
			Login_Orange.login(driver, prop);
		}

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = prop.getVal(titleKey);

		Assert.assertEquals(actualUrl, expectedUrl, "Quick launch URL mismatch!");

		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	}

	// ---------- HELP BUTTON ----------

	@Test(priority = 10)
	public void verifyHelpButtonDisplayed() {
		WebElement ele = dashboard.getQuestionmark();
		Assert.assertTrue(ele.isDisplayed());
	}

	@Test()
	public void verifyHelpButtonEnabaled() {
		WebElement ele = dashboard.getQuestionmark();
		Assert.assertTrue(ele.isEnabled());
	}

	@Test(priority = 10)
	public void verifyHelpButtonNavigation() throws InterruptedException {
		String parent = driver.getWindowHandle();
		WebElement btn = dashboard.getQuestionmark();

		btn.click();
		Thread.sleep(3000);

		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {
			if (!handle.equals(parent)) {
				driver.switchTo().window(handle);

				Assert.assertEquals(driver.getCurrentUrl(), prop.getVal("help"), "Help page URL mismatch");

				driver.close();

				break;
			}
		}

		driver.switchTo().window(parent);
		System.out.println("Back to parent: " + driver.getCurrentUrl());
		Reporter.log("back", true);
	}

	// ---------- UPGRADE BUTTON ----------

	@Test(priority = 11)
	public void verifyUpgradeButtonDisplayed() {
		Assert.assertTrue(dashboard.getUpgrade().isDisplayed(), "Upgrade button is not visible");
	}

	@Test(priority = 12)
	public void verifyUpgradeButtonEnabled() {
		Assert.assertTrue(dashboard.getUpgrade().isEnabled(), "Upgrade button is not enabled");
	}

	@Test(priority = 13)
	public void verifyUpgradeButtonNavigation() throws InterruptedException {

		dashboard.getUpgrade().click();
		Thread.sleep(3000);

		String parent = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {
			if (!handle.equals(parent)) {
				driver.switchTo().window(handle);
				Assert.assertEquals(driver.getCurrentUrl(), prop.getVal("upgrade"));
				driver.close();
			}
		}
		driver.switchTo().window(parent);
	}
}