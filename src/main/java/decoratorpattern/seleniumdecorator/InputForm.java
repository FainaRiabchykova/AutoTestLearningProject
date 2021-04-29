package decoratorpattern.seleniumdecorator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import businesslayer.datamanager.DriverProviderManager;

import static org.openqa.selenium.Keys.ENTER;

public class InputForm extends DecoratorClass {

    public InputForm(WebElement element) {
        super(element);
    }

    public void submitHard(String email, WebElement button) {
        WebDriver driver = DriverProviderManager.getDriver();
        element.sendKeys(email, ENTER);
        Actions actions = new Actions(driver);
        actions.click(button);
        actions.build().perform();

    }
    public void submitLight(String password) {
        element.sendKeys(password, ENTER);
    }
}
