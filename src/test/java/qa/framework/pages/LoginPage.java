package qa.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // LOCATOR (UI ELEMENT)
    By username = By.name("username");
    By password = By.name("password");
    By loginBtn = By.xpath("//button[@type='submit']");
    By forgotPassword = By.xpath("//a[normalize-space()='Forgot password?']");
    By emailForgot  = By.xpath("//input[@id='forgot-email']"); 
    By sendResetLink = By.xpath("//button[normalize-space()='Send Reset Link']"); 
    By dashboardDrawer = By.xpath("//span[normalize-space()='Dashboard']");
    By successSubmit = By.xpath("//div[@class='mx-auto mb-4 flex h-12 w-12 items-center justify-center rounded-full bg-green-100 text-green-600']"); 
    By errorMessage = By.xpath("//span[normalize-space()='The username or password you entered is incorrect.']");

    // Url Login

    public void navigateToLoginPage() {
        driver.get("https://qaplayground.com/bank/login");
    }

    // ACTION (behavior user)
    public void filloutLogin(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        
    }
    // ACTION (Login)

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    // ACTION (forgot password)

    public void fillOutForgotPassword(String email) {
        driver.findElement(forgotPassword).click();
        driver.findElement(emailForgot).sendKeys(email);

    }

    // Action send reset link

    public void clickSendResetLink() {
        driver.findElement(sendResetLink).click();
    }

    // ASSERTION (verify)

    public boolean isDashboardDrawerDisplayed() {
        return driver.findElement(dashboardDrawer).isDisplayed();
    }


    public boolean isSuccessSubmitDisplayed() {
        return driver.findElement(successSubmit).isDisplayed();
    }

    public void verifyForgotPasswordSuccess() {
        Assert.assertTrue(isSuccessSubmitDisplayed(), "Forgot password submission was not successful.");
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(isDashboardDrawerDisplayed(), "Login was not successful.");
    }

    public boolean getErrorMessage() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public void verifyLoginFailure() {
        Assert.assertTrue(getErrorMessage(), "Expected error message not displayed.");
        
    }


}