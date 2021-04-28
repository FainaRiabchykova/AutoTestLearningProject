package decoratorpattern.pages;

import decoratorpattern.seleniumdecorator.CustomFieldDecorator;
import decoratorpattern.seleniumdecorator.DecoratorClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagefactory.DriverProviderManager;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class BasePageFD  {
    WebDriver driver;

    public BasePageFD() {
        this.driver = DriverProviderManager.getDriver();
        PageFactory.initElements(new CustomFieldDecorator(driver), this);

    }



    public void implicitWait(long timeToWait) {
        driver.manage().timeouts().implicitlyWait(timeToWait, TimeUnit.SECONDS);
    }

    public void waitVisibilityOfElement(long timeToWaite, final WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWaite);
        wait.until(visibilityOf(element));
    }

    public void waitInVisibilityOfElement(long timeToWaite, final WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWaite);
        wait.until(invisibilityOf(element));
    }

    public void waitElementToBeClickable(long timeToWaite, final WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWaite);
        wait.until(elementToBeClickable(element));

    }

    public void waitURLContains(long timeToWaite, String url) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWaite);
        wait.until(urlContains(url));
    }

}
