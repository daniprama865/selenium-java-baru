package qa.framework.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.time.Duration;
// import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class GetRow {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        try {
        driver.manage().window().maximize();
        driver.get("https://qaplayground.com/bank/login");
        System.out.println("Judul halaman: " + driver.getTitle());
        System.out.println("URL saat ini: " + driver.getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-username")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-password")));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='login-submit-btn']")));



        // WebElement usernameField = driver.findElement(By.id("login-username"));
        // WebElement passwordField = driver.findElement(By.id("login-password"));
        // WebElement loginButton = driver.findElement(By.cssSelector("[data-testid='login-submit-btn']"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("bank_sauce");
        loginButton.click();

        WebElement sideBarAccount = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='sidebar-link-accounts']")));
        // WebElement sideBarAccount = driver.findElement(By.cssSelector("[data-testid='sidebar-link-accounts']"));
        sideBarAccount.click();

        List<WebElement> currentAccountRow = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[data-testid='account-row']")));
        int totalRows = currentAccountRow.size();
        System.out.println("Total rows before " + totalRows);


        // Add data

        WebElement addAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='add-account-btn']")));
        addAccountButton.click();
        WebElement accountNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='account-form-name-input']")));
        accountNameInput.sendKeys("Checking1");
        WebElement accountTypeSelect = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='account-form-type-select']")));
        accountTypeSelect.click();
        WebElement CheckingOption = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='account-form-type-option'][data-account-type='checking']")));
        CheckingOption.click();
        WebElement startingBalanceInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("account_balance_field")));
        startingBalanceInput.sendKeys("5000");
        WebElement termsCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("account-form-accept-terms-label")));
        termsCheckbox.click();  
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='save-account-form-btn']")));
        submitButton.click();
        Thread.sleep(2000);

        List<WebElement> updatedAccountRow = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[data-testid='account-row-name']")));
        
        System.out.println("--- DAFTAR ISI BARIS TABEL (MENGGUNAKAN LOOP) ---");
        int nomor = 1;
        for (WebElement row : updatedAccountRow) {

        // Ambil semua teks yang ada di dalam baris tersebut
        String isiBaris = row.getText(); 
        System.out.println("Baris ke-" + nomor + ": " + isiBaris);
        nomor++;

        }


        
        
        int updatedTotalRows = updatedAccountRow.size();
        Assert.assertEquals(totalRows + 1, updatedTotalRows, "Total rows tidak bertambah setelah menambahkan akun baru");
        System.out.println("Total rows after adding new account: " + updatedTotalRows);



        

        // List<WebElement> accountRowBadge = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[data-testid='account-row-type-badge']")));
        // // List<WebElement> accountRowBadge = driver.findElements(By.cssSelector("[data-testid='account-row-type-badge']"));
        // boolean adaChecking = false;
        // boolean adaSavings = false;
        // for (WebElement rowBadge : accountRowBadge) {
        //     String label = rowBadge.getText();
            

        //     System.out.println(label);

        //     if (label.equals("Checking1")) {
        //         adaChecking = true;
        //     }
        //     if (label.equals("Savings1")) {
        //         adaSavings = true;
        //     }

        // }

        
        // SoftAssert softAssert = new SoftAssert();
        // softAssert.assertTrue(adaChecking, "Akun Checking tidak ditemukan di halaman Accounts");
        // softAssert.assertTrue(adaSavings, "Akun Savings tidak ditemukan di halaman Accounts");
        // softAssert.assertAll();


        }
        finally {
            
            driver.quit();
        }

        



        // Assert.assertTrue(adaChecking && adaSavings && false, "Akun Checking atau Savings tidak ditemukan di halaman Accounts");

        // if (adaChecking && adaSavings){
        //     System.out.println("TEST PASSED");
        // }

        // else{
        //     System.out.println("TEST FAILED");
        // }
        


        // Thread.sleep(2000);

        // driver.quit();

    }

}

// ======

// driver.findElement(By.id("login-username")).sendKeys("standard_user");
// driver.findElement(By.id("login-password")).sendKeys("bank_sauce");
// driver.findElement(By.cssSelector("[data-testid='login-submit-btn']")).click();
