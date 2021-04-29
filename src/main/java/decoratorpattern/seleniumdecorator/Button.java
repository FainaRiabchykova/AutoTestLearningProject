package decoratorpattern.seleniumdecorator;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import businesslayer.datamanager.DriverProviderManager;

public class Button extends DecoratorClass{


    public Button(WebElement element) {
        super(element);
    }

    public void clickJS(){
       WebDriver driver = DriverProviderManager.getDriver();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
    }

    public void safeClick(){
        WebDriver driver = DriverProviderManager.getDriver();
        try {
            super.click();
        } catch (ElementClickInterceptedException e){
            new WebDriverWait(driver, TIME_TO_WAIT).until(ExpectedConditions.elementToBeClickable(element));
            super.click();
        }
    }

}
