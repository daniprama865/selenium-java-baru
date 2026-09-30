package qa.framework.tests;

import qa.framework.base.BaseTest;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseTest {

    @Test
    public void forgotPasswordTest() {

        // Step to reproduce: Navigate to the login page and click on the "Forgot Password" link

        loginPage.navigateToLoginPage();

        loginPage.fillOutForgotPassword("test@example.com");

        loginPage.clickSendResetLink();

        // Expected: Verify that the password reset link was sent successfully

        loginPage.verifyForgotPasswordSuccess();

    }

}
