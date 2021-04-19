package pagefactory.tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TestExecution extends BaseTest {
    //credentials
    private final String EMAIL = "qariatest@gmail.com";
    private final String PASSWORD = "Aaaa!111";
    //waits
    private final long TIME_TO_WAIT = 30;
    //urls & url keywords
    private static final String GMAIL_URL = "https://mail.google.com/mail/u/0/?tab=km#inbox";
    private final String MY_ACCOUNT_URL_KEYWORD = "myaccount";
    private final String DRAFT_PAGE_URL_KEYWORD = "drafts";
    //emails data
    private final String SUBJECT_TEXT = "This test data for the task 5";
    private final String TO_EMAIL = "qualitydandelion+to@gmail.com";
    private final String CC_EMAIL = "qualitydandelion+cc@gmail.com";
    private final String BCC_EMAIL = "qualitydandelion+bcc@gmail.com";

    @Test
    public void checkSaveDraftsInGmail() throws InterruptedException {

        //checkLoginToAccount
        getSignInPage().emailSubmit(EMAIL);
        getSignInPage().implicitWait(TIME_TO_WAIT);
        getSignInPage().passwordSubmit(PASSWORD);
        getSignInPage().implicitWait(TIME_TO_WAIT);
        getSignInPage().waitURLContains(TIME_TO_WAIT, MY_ACCOUNT_URL_KEYWORD);
        assertTrue(getDriver().getCurrentUrl().contains(MY_ACCOUNT_URL_KEYWORD));

        //Click on “compose” button
        getMyAccountPage().openGmail(GMAIL_URL);
        getGmailPage().waitVisibilityOfElement(TIME_TO_WAIT, getGmailPage().getComposeButton());
        getGmailPage().clickOnComposeButton();

        //Fill the next fields: to, cc, bcc, subject & message
        getGmailPage().clickOnCCLink();
        getGmailPage().clickOnBCCLink();
        getGmailPage().fillTOField(TO_EMAIL);
        getGmailPage().fillCCField(CC_EMAIL);
        getGmailPage().fillBCCField(BCC_EMAIL);
        getGmailPage().fillSubjectField(SUBJECT_TEXT);

        //Click on “save & close” button
        getGmailPage().clickOnCloseAndSave();
        getGmailPage().clickOnDraftCategory();

        //Go to the “draft” folder & open previously saved message
        getDraftPage().waitURLContains(TIME_TO_WAIT, DRAFT_PAGE_URL_KEYWORD);
        getDraftPage().clickOnDraftItem();

        // Verify that all fields are saved correctly
        getDraftPage().clickOnDraftLetterCClinks();
        assertEquals(getDraftPage().getDraftLetterTOValue(), TO_EMAIL);
        assertEquals(getDraftPage().getDraftLetterCCValue(), CC_EMAIL);
        assertEquals(getDraftPage().getDraftLetterBCCValue(), BCC_EMAIL);
        assertEquals(getDraftPage().getDraftLetterSubject(), SUBJECT_TEXT);

        //Press the “send” button
        getDraftPage().clickOnSendButton();
    }
}
