package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.Keys.ENTER;

public class SignInPage extends BasePage {


    @FindBy(xpath = "//div[@class='Xb9hP']//input[@type='email']")
    private WebElement emailInputField;
    @FindBy(xpath = "//div[@id='identifierNext']")
    private WebElement nextButton;
    @FindBy(css = "[name='password']")
    private WebElement passwordInputField;

    public WebElement getEmailInputField() {
        return emailInputField;
    }

    public WebElement getPasswordInputField() {
        return passwordInputField;
    }

    public void emailSubmit(String email) {
        emailInputField.sendKeys(email, ENTER);
        Actions actions = new Actions(this.driver);
        actions.click(nextButton);
        actions.build().perform();
    }

    public void passwordSubmit(String password) {
        passwordInputField.sendKeys(password, ENTER);
    }
}
