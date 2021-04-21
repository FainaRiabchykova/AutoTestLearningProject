package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BasePage {
    WebDriver driver;

    public BasePage() {
        this.driver = DriverProviderManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void implicitWait(long timeToWait) {
        driver.manage().timeouts().implicitlyWait(timeToWait, TimeUnit.SECONDS);
    }

    public void waitVisibilityOfElement(long timeToWaite, final WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWaite);
        wait.until(visibilityOf(element));
    }

    public void waitURLContains(long timeToWaite, String url) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWaite);
        wait.until(urlContains(url));
    }

}
