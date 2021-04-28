package decoratorpattern.pages;

import decoratorpattern.seleniumdecorator.ButtonJS;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraftPageFD extends  BasePageFD{


    @FindBy(xpath = "(//div[@role=\"link\"]//span[contains(@data-standalone-draft-id, '#msg-a')])[1]")
   // private WebElement draftItem;
    private ButtonJS draftItem;

    @FindBy(xpath = "//span[@email]/following-sibling::span[@class=\"aDp\"]")
    private WebElement draftLetterCClinks;

    @FindBy(xpath = "//input[@name='to']")
    private WebElement draftLetterTOinput;

    @FindBy(xpath = "//input[@name='cc']")
    private WebElement draftLetterCCinput;

    @FindBy(xpath = "//input[@name='bcc']")
    private WebElement draftLetterBCCinput;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement draftLetterSubject;

    @FindBy(xpath = "//div[@class=\"dC\"]//div[@role=\"button\" and text()]")
    private WebElement sendButton;



    public void clickOnDraftItem() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", draftItem);
    }

    public void clickOnDraftLetterCClinks() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", draftLetterCClinks);
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
