package qa.framework.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Lesson1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qaplayground.com/bank/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("Judul halaman: " + driver.getTitle());
        System.out.println("URL saat ini: " + driver.getCurrentUrl());
        WebElement usernameField = driver.findElement(By.id("login-username"));
        WebElement passwordField = driver.findElement(By.id("login-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("[data-testid='login-submit-btn']"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("bank_sauce");
        loginButton.click();

        WebElement sideBarAccount = driver.findElement(By.cssSelector("[data-testid='sidebar-link-accounts']"));
        sideBarAccount.click();
        System.out.println("Halaman saat ini: " + sideBarAccount.getText());

        List<WebElement> accountRowBadge = driver.findElements(By.cssSelector("[data-testid='account-row-type-badge']"));
        boolean adaChecking = false;
        boolean adaSavings = false;
        for (WebElement rowBadge : accountRowBadge) {
            String label = rowBadge.getText();

            System.out.println(label);

            if (label.equals("Checking")) {
                adaChecking = true;
            }
            if (label.equals("Savings")) {
                adaSavings = true;
            }

        }

        if (adaChecking && adaSavings){
            System.out.println("TEST PASSED");
        }

        else{
            System.out.println("TEST FAILED");
        }
        // System.out.println("Dapet element apa ? " + accountRowBadge);


        Thread.sleep(2000);

        driver.quit();

    }

}

// ======

// driver.findElement(By.id("login-username")).sendKeys("standard_user");
// driver.findElement(By.id("login-password")).sendKeys("bank_sauce");
// driver.findElement(By.cssSelector("[data-testid='login-submit-btn']")).click();
