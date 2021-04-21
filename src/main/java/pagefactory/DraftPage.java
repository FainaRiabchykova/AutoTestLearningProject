package pagefactory;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DraftPage extends BasePage {

    @FindBy(xpath = "//tr[descendant::text()='Чернетка']")
    private List<WebElement> draftItems;

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


    public WebElement getDraftItemWithSubject(final String expectedSubject) {
        return draftItems.stream()
                .filter(item -> StringUtils.containsIgnoreCase(item.getText(), expectedSubject))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No drafts with text: " + expectedSubject));
    }

    public void clickOnDraftItem(final String draftSubject) {
        WebElement draftItem = getDraftItemWithSubject(draftSubject);
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
