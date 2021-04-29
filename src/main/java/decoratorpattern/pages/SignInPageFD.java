package decoratorpattern.pages;

import decoratorpattern.seleniumdecorator.InputForm;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPageFD extends BasePageFD {

    @FindBy(xpath = "//div[@class='Xb9hP']//input[@type='email']")
    private InputForm emailInputField;
    @FindBy(xpath = "//div[@id='identifierNext']")
    private WebElement nextButton;
    @FindBy(css = "[name='password']")
    private InputForm passwordInputField;

    public WebElement getEmailInputField() {
        return emailInputField;
    }

    public WebElement getPasswordInputField() {
        return passwordInputField;
    }

    @Step("Login with email: {0}")
    public void emailSubmit(String email) {
        emailInputField.submitHard(email, nextButton);
    }

    @Step("Login with password: {0}")
    public void passwordSubmit(String password) {
        passwordInputField.submitLight(password);
    }
}
