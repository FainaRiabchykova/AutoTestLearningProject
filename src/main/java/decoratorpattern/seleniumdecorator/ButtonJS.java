package decoratorpattern.seleniumdecorator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pagefactory.DriverProviderManager;

public class ButtonJS extends DecoratorClass{


    public ButtonJS(WebElement element) {
        super(element);
    }
    public void clickJS(){
       WebDriver driver = DriverProviderManager.getDriver();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
       // element.click();
    }
}
