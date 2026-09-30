package qa.framework.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    // LOCATOR (UI ELEMENT)

    By dashboardDrawer = By.xpath("//span[normalize-space()='Dashboard']");

    public boolean isDashboardDrawerDisplayed() {
        return driver.findElement(dashboardDrawer).isDisplayed();
    }




}
