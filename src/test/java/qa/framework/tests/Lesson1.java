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

public class Lesson1 {

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

        List<WebElement> accountRowBadge = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[data-testid='account-row-type-badge']")));
        
        // List<WebElement> accountRowBadge = driver.findElements(By.cssSelector("[data-testid='account-row-type-badge']"));
        boolean adaChecking = false;
        boolean adaSavings = false;
        for (WebElement rowBadge : accountRowBadge) {
            String label = rowBadge.getText();
            

            System.out.println(label);

            if (label.equals("Checking1")) {
                adaChecking = true;
            }
            if (label.equals("Savings1")) {
                adaSavings = true;
            }

        }

        
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(adaChecking, "Akun Checking tidak ditemukan di halaman Accounts");
        softAssert.assertTrue(adaSavings, "Akun Savings tidak ditemukan di halaman Accounts");
        softAssert.assertAll();


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
