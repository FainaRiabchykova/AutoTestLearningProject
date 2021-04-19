package pagefactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraftPage extends BasePage {

    @FindBy(xpath = "(//*[text()='Чернетка'])[1]")
    private WebElement draftItem;

    @FindBy(xpath = "//span[@email]/following-sibling::span[contains(text(), 'ще 2')]")
    private WebElement draftLetterCClinks;

    @FindBy(xpath = "//input[@name='to']")
    WebElement draftLetterTOinput;
    @FindBy(xpath = "//input[@name='cc']")
    WebElement draftLetterCCinput;
    @FindBy(xpath = "//input[@name='bcc']")
    WebElement draftLetterBCCinput;
    @FindBy(xpath = "//input[@name='subjectbox']")
    WebElement draftLetterSubject;

    @FindBy(xpath = "//div[text()='Надіслати']")
    WebElement sendButton;


    public DraftPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getDraftItem() {
        return draftItem;
    }

    public void clickOnDraftItem() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", draftItem);
    }

    public void clickOnDraftLetterCClinks() {
        draftLetterCClinks.click();
    }

    public String getDraftLetterTOValue() {
        return draftLetterTOinput.getAttribute("value");
    }

    public String getDraftLetterCCValue() {
        return draftLetterCCinput.getAttribute("value");
    }

    public String getDraftLetterBCCValue() {
        return draftLetterBCCinput.getAttribute("value");
    }

    public String getDraftLetterSubject() {
        return draftLetterSubject.getAttribute("value");
    }

    public void clickOnSendButton() {
        sendButton.click();
    }
    public WebElement getDraftLetterCClinks() {
        return draftLetterCClinks;
    }
}
