package tests;

import com.crm.utility.BaseWebdriver;
import com.crm.utility.Login_Orange;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.pom.DashBoard;

public class DashBoard_Test extends BaseWebdriver {

	public DashBoard dashboard;
	public WebDriverWait wait;
	
	// ---------- SETUP ----------

	@BeforeClass
	public void initialize() {
		// ✅ Initialize wait once for the entire class
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@BeforeMethod
	public void setUp() {
		dashboard = new DashBoard(driver);
		
		
		if (!driver.getCurrentUrl().contains("/dashboard/index")) {
			driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
			wait.until(ExpectedConditions.urlContains("/dashboard/index"));
		}
		
		
		wait.until(ExpectedConditions.visibilityOf(dashboard.getWidgetgrid()));
	}

	// ========== BASIC DASHBOARD ==========
	
	@Test(priority = -1)
	public void verifyDashBoardLink() {
		String expectedLink = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		
		// ✅ Wait for URL to stabilize
		wait.until(ExpectedConditions.urlToBe(expectedLink));
		
		String actLink = driver.getCurrentUrl();
		Assert.assertEquals(actLink, expectedLink, "Expected and actual link is not matching!");
	}

	@Test(priority = 0)
	public void verifyDashBoardAfterLogin() {
		
		WebElement widgetGrid = wait.until(ExpectedConditions.visibilityOf(dashboard.getWidgetgrid()));
		Assert.assertTrue(widgetGrid.isDisplayed(), "Dashboard is not visible after login");
	}

	@Test(priority = 1)
	public void verifyNavbarVisibility() {
		
		WebElement navbar = wait.until(ExpectedConditions.visibilityOf(dashboard.getNavbarItems()));
		Assert.assertTrue(navbar.isDisplayed(), "Navbar items not visible!");
	}

	@Test(priority = 3)
	public void verifyProfileIconDisplayed() {
		
		WebElement profileIcon = wait.until(ExpectedConditions.visibilityOf(dashboard.getProfileIcon()));
		Assert.assertTrue(profileIcon.isDisplayed(), "Profile Icon is not displayed!");
	}

	// ========== PROFILE DROPDOWN ==========

	@Test(priority = 4)
	public void verifyProfileDropdownVisibility() {
	
		WebElement profileIcon = wait.until(ExpectedConditions.elementToBeClickable(dashboard.getProfileIcon()));
		
		Actions act = new Actions(driver);
		act.click(profileIcon).perform();

		
		WebElement dropdownMenu = wait.until(ExpectedConditions.visibilityOf(dashboard.getDropdownmenu()));
		Assert.assertTrue(dropdownMenu.isDisplayed(), "Dropdown menu is not visible!");

		
		List<WebElement> dropdownItems = dashboard.getDropdownitems();
		for (WebElement item : dropdownItems) {
			wait.until(ExpectedConditions.visibilityOf(item));
			Assert.assertTrue(item.isEnabled(), "Dropdown item is not enabled: " + item.getText());
		}
	}

	// ========== QUICK LAUNCH ==========

	@Test(priority = 5)
	public void verifyQuickLaunchButtonsEnabled() {
	
		List<WebElement> buttons = dashboard.getQuickLaunch_buttons();
		
		for (WebElement button : buttons) {
			// ✅ Wait for each button to be visible
			wait.until(ExpectedConditions.visibilityOf(button));
			Assert.assertTrue(button.isEnabled(), "Quick launch button is not enabled: " + button.getAttribute("title"));
		}
	}

	// ========== CHART ==========

	@Test(priority = 6)
	public void verifyChartsDisplayed() {
		
		WebElement chart = wait.until(ExpectedConditions.visibilityOf(dashboard.getChart()));
		Assert.assertTrue(chart.isDisplayed(), "Charts are not available!");
	}

	// ========== WIDGET TEXT VERIFICATION ==========

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
		
		wait.until(ExpectedConditions.visibilityOf(dashboard.getWidgetgrid()));
		
		List<WebElement> widgetList = dashboard.getWidgetItems();
		
		
		
		
		WebElement widget = widgetList.get(index - 1);
		
		
		wait.until(ExpectedConditions.visibilityOf(widget));
		
		
		WebElement headerElement = wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(
			widget, 
			By.xpath(".//div[@class='orangehrm-dashboard-widget-header']/div/p")
		));
		
		String actualText = headerElement.getText().strip();
		String expectedText = prop.getVal(String.valueOf(index)).strip();
		
		Assert.assertEquals(actualText, expectedText, 
			"Widget item text not matching! Expected: " + expectedText + ", Actual: " + actualText);
	}

	// ========== QUICK LAUNCH NAVIGATION ==========

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
		
		Assert.assertTrue(buttons.size() > index, 
			"Quick launch button index " + index + " is out of bounds!");
		
		WebElement btn = buttons.get(index);
		
		
		wait.until(ExpectedConditions.elementToBeClickable(btn));
		
		String titleKey = btn.getAttribute("title").replaceAll("\\s", "").strip();
		
		btn.click();

		
		if (driver.getCurrentUrl().contains("login")) {
			Login_Orange.login(driver, prop);
			
			
			wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("login")));
		}

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = prop.getVal(titleKey);

		Assert.assertEquals(actualUrl, expectedUrl, 
			"Quick launch URL mismatch! Button: " + titleKey + ", Expected: " + expectedUrl + ", Actual: " + actualUrl);

		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		wait.until(ExpectedConditions.urlContains("/dashboard/index"));
		wait.until(ExpectedConditions.visibilityOf(dashboard.getWidgetgrid()));
	}

	// ========== HELP BUTTON ==========

	@Test(priority = 10)
	public void verifyHelpButtonDisplayed() {
		
		WebElement helpBtn = wait.until(ExpectedConditions.visibilityOf(dashboard.getQuestionmark()));
		Assert.assertTrue(helpBtn.isDisplayed(), "Help button is not displayed!");
	}

	@Test(priority = 11)
	public void verifyHelpButtonEnabaled() {
		
		WebElement helpBtn = wait.until(ExpectedConditions.visibilityOf(dashboard.getQuestionmark()));
		Assert.assertTrue(helpBtn.isEnabled(), "Help button is not enabled!");
	}

	@Test(priority = 12)
	public void verifyHelpButtonNavigation() {
		String parentWindow = driver.getWindowHandle();
		
		
		WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(dashboard.getQuestionmark()));
		btn.click();

		
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {
			if (!handle.equals(parentWindow)) {
				driver.switchTo().window(handle);

				
				wait.until(ExpectedConditions.urlToBe(prop.getVal("help")));
				
				Assert.assertEquals(driver.getCurrentUrl(), prop.getVal("help"), 
					"Help page URL mismatch!");

				driver.close();
				break;
			}
		}

		
		driver.switchTo().window(parentWindow);
		
		
		wait.until(ExpectedConditions.urlContains("/dashboard/index"));
		
		System.out.println("Back to parent: " + driver.getCurrentUrl());
		Reporter.log("back", true);
	}

	// ========== UPGRADE BUTTON ==========

	@Test(priority = 13)
	public void verifyUpgradeButtonDisplayed() {
		
		WebElement upgradeBtn = wait.until(ExpectedConditions.visibilityOf(dashboard.getUpgrade()));
		Assert.assertTrue(upgradeBtn.isDisplayed(), "Upgrade button is not visible");
	}

	@Test(priority = 14)
	public void verifyUpgradeButtonEnabled() {
		
		WebElement upgradeBtn = wait.until(ExpectedConditions.elementToBeClickable(dashboard.getUpgrade()));
		Assert.assertTrue(upgradeBtn.isEnabled(), "Upgrade button is not enabled");
	}

	@Test(priority = 15)
	public void verifyUpgradeButtonNavigation() {
		String parentWindow = driver.getWindowHandle();
		
		
		WebElement upgradeBtn = wait.until(ExpectedConditions.elementToBeClickable(dashboard.getUpgrade()));
		upgradeBtn.click();

	
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {
			if (!handle.equals(parentWindow)) {
				driver.switchTo().window(handle);
				
				
				String expectedUrl = prop.getVal("upgrade");
				wait.until(ExpectedConditions.urlToBe(expectedUrl));
				
				Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, 
					"Upgrade page URL mismatch!");
				
				driver.close();
				break;
			}
		}
		
	
		driver.switchTo().window(parentWindow);
		
		
		wait.until(ExpectedConditions.urlContains("/dashboard/index"));
	}
	
	// ========== UNCRITICAL COMPONENTS ==========
	
	@Test(priority = 16)
	public void logoVerify() {
		SoftAssert sa = new SoftAssert();
		
		
		WebElement logo = wait.until(ExpectedConditions.visibilityOf(dashboard.getLogo()));
		sa.assertTrue(logo.isDisplayed(), "Logo is not displayed");
		
		sa.assertAll();
	}
	
	@Test(priority = 17)
	public void navbarVerify() {
		SoftAssert sa = new SoftAssert();
		
		
		WebElement navbar = wait.until(ExpectedConditions.visibilityOf(dashboard.getNavbar()));
		sa.assertTrue(navbar.isDisplayed(), "Navbar is not displayed!");
		
		sa.assertAll();
	}
	
	@Test(priority = 18)
	public void footerVerify() {
		SoftAssert sa = new SoftAssert();
		
		
		WebElement footer = wait.until(ExpectedConditions.visibilityOf(dashboard.getFooter()));
		sa.assertTrue(footer.isDisplayed(), "Footer is not displayed");
		
		sa.assertAll();
	}
}