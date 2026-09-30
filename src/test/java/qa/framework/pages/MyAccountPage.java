package qa.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.ArrayList;
// import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;

public class MyAccountPage {

    WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // LOCATOR (UI ELEMENT)
    By AccountsDrawer = By.xpath("//span[normalize-space()='Accounts']");
    By accountTypeBadges = By.cssSelector("[data-testid='account-row-type-badge']");
    By buttonAddAccount = By.cssSelector("[data-testid='add-account-btn']");
    By addAccountDialog = By.id("[data-testid='add-account-dialog']");
    By accountNameInput = By.id("account-form-name");
    By accountTypeSelect = By.id("account-form-type-trigger");
    By accountTypeOptions = By.cssSelector("[role='option']");
    By startingBalanceInput = By.name("account_balance_field");
    By termsCheckbox = By.id("account-form-accept-terms-label");

    // input starting balance
    public void fillOutStartingBalance(int balance) {
        driver.findElement(startingBalanceInput).sendKeys(String.valueOf(balance));
    }   

    public void clickTermsCheckbox() {
        driver.findElement(termsCheckbox).click();
    }

    // buka dropdown
    public void openAccountTypeDropdown() {
        driver.findElement(accountTypeSelect).click();
    }

    // pilih SATU opsi spesifik
    public void selectAccountType(String type) {
        openAccountTypeDropdown();
        By option = By.cssSelector(
        "[data-testid='account-form-type-option'][data-account-type='" + type.toLowerCase() + "']"
    );
        driver.findElement(option).click();
    }
    

    public void fillOutAddAccountForm(String accountName, String accountType) {
        driver.findElement(accountNameInput).sendKeys(accountName);
        selectAccountType(accountType);

    }

    public void clickAccountsDrawer() {
        driver.findElement(AccountsDrawer).click();
    }

    public void clickAddAccountButton() {
        driver.findElement(buttonAddAccount).click();
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(accountNameInput));

    }

    // Assert checking and savings accounts are listed

    public List<String> getAllAccountTypes() {
        List<WebElement> badges = driver.findElements(accountTypeBadges);
        List<String> accountTypes = new ArrayList<>();
        for (WebElement badge : badges) {
            accountTypes.add(badge.getText());
        }
        return accountTypes;
    }

    public void verifyAccountsListLoad() {
        List<String> accountTypes = getAllAccountTypes();
        Assert.assertFalse(accountTypes.isEmpty(), "Accounts list kosong");
        Assert.assertTrue(accountTypes.contains("Savings"), "Tidak ada Savings");
        Assert.assertTrue(accountTypes.contains("Checking"), "Tidak ada Checking");
    }

}
