package decoratorpattern.pages;

import decoratorpattern.seleniumdecorator.Button;
import decoratorpattern.seleniumdecorator.InputText;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailPageFD extends BasePageFD {

    @FindBy(xpath = "//div[@class=\"T-I T-I-KE L3\"]")
    private Button composeButton;

    @FindBy(xpath = "//textarea[@name=\"to\"]")
    private InputText toInputField;

    @FindBy(xpath = "(//span [@role=\"link\" and @data-tooltip])[2]")
    private WebElement ccLink;

    @FindBy(xpath = "(//span [@role=\"link\" and @data-tooltip])[4]")
    private WebElement bccLink;

    @FindBy(xpath = "//textarea[@name=\"cc\"]")
    private InputText ccInputField;

    @FindBy(xpath = "//textarea[@name=\"bcc\"]")
    private InputText bccInputField;

    @FindBy(xpath = "//*[@name=\"subjectbox\"]")
    private InputText subjectField;

    @FindBy(xpath = "//img[@class=\"Ha\"]")
    private WebElement closeAndSave;

    @FindBy(xpath = "//a[contains(@href, 'draft')]")
    private Button draftCategory;

    public WebElement getComposeButton() {
        return composeButton;
    }

    @Step("Click on compose Button")
    public void clickOnComposeButton() { composeButton.clickJS(); }

    public void clickOnCCLink() {
        ccLink.click();
    }

    public void clickOnBCCLink() {
        bccLink.click();
    }

    public void fillTOField(String data) { toInputField.fillFieldWithData(data); }

    public void fillCCField(String data) {
        ccInputField.fillFieldWithData(data);
    }

    public void fillBCCField(String data) {
        bccInputField.fillFieldWithData(data);
    }

    public void fillSubjectField(String data) {
        subjectField.fillFieldWithData(data);
    }

    public void clickOnCloseAndSave() {
        closeAndSave.click();
    }

    public void clickOnDraftCategory() {
        draftCategory.safeClick();
    }

    public WebElement getCloseAndSave() { return closeAndSave; }
}
