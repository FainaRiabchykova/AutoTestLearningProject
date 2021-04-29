package decoratorpattern.pages;

import decoratorpattern.seleniumdecorator.Button;
import decoratorpattern.seleniumdecorator.InputText;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraftPageFD extends BasePageFD {

    @FindBy(xpath = "(//div[@role=\"link\"]//span[contains(@data-standalone-draft-id, '#msg-a')])[1]")
    private Button draftItem;

    @FindBy(xpath = "//span[@email]/following-sibling::span[@class=\"aDp\"]")
    private Button draftLetterCClinks;

    @FindBy(xpath = "//input[@name='to']")
    private InputText draftLetterTOinput;

    @FindBy(xpath = "//input[@name='cc']")
    private InputText draftLetterCCinput;

    @FindBy(xpath = "//input[@name='bcc']")
    private InputText draftLetterBCCinput;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private InputText draftLetterSubject;

    @FindBy(xpath = "//div[@class=\"dC\"]//div[@role=\"button\" and text()]")
    private Button sendButton;


    public void clickOnDraftItem() {
        draftItem.clickJS();
    }

    public void clickOnDraftLetterCClinks() {
        draftLetterCClinks.clickJS();
    }

    public String getDraftLetterTOValue() {
       return draftLetterTOinput.getValueAttribute();
    }

    public String getDraftLetterCCValue() {
        return draftLetterCCinput.getValueAttribute();
    }

    public String getDraftLetterBCCValue() {
        return draftLetterBCCinput.getValueAttribute();
    }

    public String getDraftLetterSubject() {
        return draftLetterSubject.getValueAttribute();
    }

    public void clickOnSendButton() {
        sendButton.safeClick();
    }

    public WebElement getDraftLetterCClinks() {
        return draftLetterCClinks;
    }

}
