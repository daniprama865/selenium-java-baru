package qa.framework.tests;
import qa.framework.base.BaseTest;
import org.testng.annotations.Test;


public class AddAccounts extends BaseTest {


    @Test
    public void testAddAccount() {
         // Step to reproduce
        loginPage.navigateToLoginPage();
        loginPage.filloutLogin("standard_user", "bank_sauce");
        loginPage.clickLogin();
        // Expected
        loginPage.verifyLoginSuccess();
        myAccountPage.clickAccountsDrawer();
        myAccountPage.verifyAccountsListLoad();
        
    }

    @Test
    public void testAddAccountButton() {
        // Step to reproduce
        loginPage.navigateToLoginPage();
        loginPage.filloutLogin("standard_user", "bank_sauce");
        loginPage.clickLogin();
        loginPage.verifyLoginSuccess();
        myAccountPage.clickAccountsDrawer();
        myAccountPage.clickAddAccountButton();
        myAccountPage.fillOutAddAccountForm("Test Account", "Savings");
        myAccountPage.fillOutStartingBalance(1000);
        myAccountPage.clickTermsCheckbox();

        


    }



}
