package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.pom.Login;
import com.crm.utility.BaseClass;
import com.crm.utility.ReadExcel;

//@Listeners(com.crm.utility.Literners.class)
public class Loggin101 extends BaseClass {

    public Login login;

    @DataProvider(name = "loginDetails")
    public Object[][] provide() {
        return ReadExcel.getCells(
            "C:\\girish\\javaProjects\\Girish_Automation\\Hybrid_Driven_Tesing\\src\\test\\resources\\Orange_Passwords.xlsx",
            "Sheet1"
        );
    }

    @BeforeMethod
    public void setUp() {
        driver.get(BaseUrl);
        login = new Login(driver);
    }

    @Test(priority = -1)
    public void verifyLink() {
        String expectedlink =
            "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        Assert.assertEquals(
            driver.getCurrentUrl(),
            expectedlink,
            "Current and Expected Does not Match"
        );
    }

    //  Page sanity 

    @Test(priority = 0)
    public void verifyLoginButtonDisplay() {
        Assert.assertTrue(
            login.getLoggin_button().isDisplayed(),
            "The Loggin Button is not displayed !"
        );
    }

    @Test(priority = 1)
    public void verifyLoginBtnEnabled() {
        Assert.assertTrue(
            login.getLoggin_button().isEnabled(),
            "The Loggin button is not enabled !"
        );
    }

    // -------- Forgot password --------

    @Test(priority = 2)
    public void verifyForgotPasswordLinkVisiblity() {
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(
            login.getForgotpass().isDisplayed(),
            "The forgot password is not visible"
        );
        sa.assertAll();
    }

    @Test(priority = 3)
    public void verifyforgotPassWordEnabled() {
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(
            login.getForgotpass().isEnabled(),
            "Forgot pass is not enabled !"
        );
    }

    @Test(priority = 4)
    public void verifyforgotPassWordLink() throws InterruptedException {
        String expectedLink =
            "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode";
        login.getForgotpass().click();
        Thread.sleep(2000);
        Assert.assertEquals(
            expectedLink,
            driver.getCurrentUrl(),
            "The forgot pass is landing to a wrong page"
        );
    }

    @Test(priority = 5)
    public void testResetPassPage() {
    	login.getForgotpass().click();
        WebElement ele = login.getUsernameResetPassPage();
        ele.sendKeys("sample");

        String username = ele.getAttribute("value");
        Assert.assertEquals(
            username,
            "sample",
            "The Entered value and Expected value is not matched !"
        );

        Assert.assertTrue(login.getResetPass().isDisplayed(),
            "Reset password button is not visible !");
        Assert.assertTrue(login.getResetPass().isEnabled(),
            "Reset Button is not enabled !");
        Assert.assertTrue(login.getCancel().isDisplayed(),
            "Cancel button is not displayed !");
        Assert.assertTrue(login.getCancel().isEnabled(),
            "Cancel button is not enabled !");
    }

    // -------- Input fields --------

    @Test(priority = 6)
    public void usernameField() {
        Assert.assertTrue(
            login.getUsername().isDisplayed(),
            "Username field is not displayed"
        );
        Assert.assertTrue(
            login.getUsername().isEnabled(),
            "Username field is not enabled !"
        );

        WebElement ele = login.getUsername();
        ele.sendKeys("sample");

        String ans = ele.getAttribute("value");
        Assert.assertEquals(
            "sample",
            ans,
            "The entered text is not matching !"
        );
    }

    @Test(priority = 7)
    public void passwordField() {
        WebElement ele = login.getPasss();

        Assert.assertTrue(
            ele.isDisplayed(),
            "The password field is not displayed !"
        );
        Assert.assertTrue(
            ele.isEnabled(),
            "The password field is not enabled"
        );

        ele.sendKeys("sample");

        String res = ele.getAttribute("value");
        Assert.assertEquals(
            res,
            "sample",
            "The entered value and expected value are not matching !"
        );
    }

    @Test(priority = 8)
    public void passmasked() {
        String attribute =
            login.getPasss().getAttribute("type").toLowerCase();

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(
            attribute,
            "password",
            "Password is not masked (type != password)"
        );
    }

    // -------- Functional login (LAST) --------

    @Test(priority = 9, dataProvider = "loginDetails")
    public void performLogin(String user, String pass, String scenario)
            throws InterruptedException {

        System.out.println("Testing: " + user + " | " + pass + " | " + scenario);

        // Handle "null" strings from Excel
        if (scenario.equalsIgnoreCase("required")) {
            if (user.equalsIgnoreCase("null") || user.isEmpty()) {
                user = "";
            }
            if (pass.equalsIgnoreCase("null") || pass.isEmpty()) {
                pass = "";
            }
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Perform login
        login.login(user, pass);

        // Handle different scenarios
        if (scenario.equalsIgnoreCase("positive")) {
            // Positive scenario - should succeed
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class='oxd-layout-context']")));

                Assert.assertTrue(
                    login.getDashboard().isDisplayed(),
                    "Login should be successful for: " + user);

                // Logout after successful login
                login.logout();
                
                // Wait for logout to complete
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@name='username']")));

            } catch (Exception e) {
                System.out.println(" Positive login failed for: " + user);
                throw e;
            }

        } else if (scenario.equalsIgnoreCase("required")) {
            // Required field scenario
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[contains(@class,'input-group__message')]")));

                Assert.assertTrue(
                    login.getRequired_field().isDisplayed(),
                    "Required message expected for empty fields");

            } catch (Exception e) {
                System.out.println(" Required field validation failed");
                throw e;
            }

        } else {
            // Negative scenario - invalid credentials
            try {
                 WebElement errormsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")));

                boolean isErrorDisplayed = errormsg.isDisplayed();
                System.out.println("Invalid credentials message displayed: " + isErrorDisplayed);

                Assert.assertTrue(isErrorDisplayed,
                    "Invalid credential message expected for: " + user + "/" + pass);

                // Check if accidentally logged in (shouldn't happen in negative scenario)
                if (driver.findElements(
                        By.xpath("//div[@class='oxd-layout-context']")).size() > 0) {
                    System.out.println(" Unexpectedly logged in with invalid credentials!");
                    login.logout();
                }

            } catch (Exception e) {
                System.out.println("Negative scenario failed for: " + user + "/" + pass);
                
                // Take screenshot for debugging
                System.out.println("Current URL: " + driver.getCurrentUrl());
                
                throw e;
            }
        }
    }
}