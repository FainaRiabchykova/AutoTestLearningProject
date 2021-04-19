package pagefactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailPage extends BasePage {


    @FindBy(xpath = "//div[text()=\"Написати\"]")
    private WebElement composeButton;
    @FindBy(xpath = "//textarea[@name=\"to\"]")
    private WebElement toInputField;
    @FindBy(xpath = "//span[contains(@data-tooltip, 'Додати одержувачів копії')]")
    private WebElement ccLink;
    @FindBy(xpath = "//span[contains(@data-tooltip, 'Додати одержувачів прихованої копії')]")
    private WebElement bccLink;
    @FindBy(xpath = "//textarea[@name=\"cc\"]")
    private WebElement ccInputField;
    @FindBy(xpath = "//textarea[@name=\"bcc\"]")
    private WebElement bccInputField;
    @FindBy(xpath = "//*[@name=\"subjectbox\"]")
    private WebElement subjectField;
    @FindBy(xpath = "//*[@data-tooltip=\"Зберегти та закрити\"]")
    private WebElement closeAndSave;
    @FindBy(xpath = "//a[contains(@href, 'draft')]")
    private WebElement draftCategory;


    public GmailPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getComposeButton() {
        return composeButton;
    }

    public void clickOnComposeButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", composeButton);
    }

    public void clickOnCCLink() {
        ccLink.click();
    }

    public void clickOnBCCLink() {
        bccLink.click();
    }

    public void fillTOField(String data) {
        toInputField.sendKeys(data);
    }

    public void fillCCField(String data) {
        ccInputField.sendKeys(data);
    }

    public void fillBCCField(String data) {
        bccInputField.sendKeys(data);
    }

    public void fillSubjectField(String data) {
        subjectField.sendKeys(data);
    }

    public void clickOnCloseAndSave() {
        closeAndSave.click();
    }

    public void clickOnDraftCategory() {
        draftCategory.click();
    }

}
