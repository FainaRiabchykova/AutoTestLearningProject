package decoratorpattern.seleniumdecorator;

import org.openqa.selenium.WebElement;

public class InputText extends DecoratorClass {

    public InputText(WebElement element) {
        super(element);
    }

    public String getValueAttribute() {
        return element.getAttribute("value");
    }

    public void fillFieldWithData(String data) {
        element.clear();
        super.sendKeys(data);
    }
}
