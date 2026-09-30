package qa.framework.tests;

import qa.framework.base.BaseTest;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void loginValidTest() {

        // Step to reproduce
        loginPage.navigateToLoginPage();
        loginPage.filloutLogin("standard_user", "bank_sauce");
        loginPage.clickLogin();
        // Expected
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void loginInvalidTest() {

        // Step to reproduce
        loginPage.navigateToLoginPage();
        loginPage.filloutLogin("invalid_user", "invalid_password");
        loginPage.clickLogin();
        // Expected
        loginPage.verifyLoginFailure();
    }
}