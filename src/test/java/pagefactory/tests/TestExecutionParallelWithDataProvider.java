package pagefactory.tests;

import businesslayer.datamanager.EmailData;
import businesslayer.datamanager.EmailProvider;
import businesslayer.datamanager.User;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TestExecutionParallelWithDataProvider extends BaseTest {

    //waits
    private final long TIME_TO_WAIT = 30;
    //urls & url keywords
    private static final String GMAIL_URL = "https://mail.google.com/mail/u/0/?tab=km#inbox";
    private final String MAIL_URL_KEYWORD = "mail";
    private final String DRAFT_PAGE_URL_KEYWORD = "drafts";



    @Test(dataProvider = "riaTest", dataProviderClass = DataProviderClass.class)

    public void checkSaveDraftsInGmail(User user) throws InterruptedException {
        EmailData emailData = EmailProvider.getEmailData();

        //checkLoginToAccount
        getSignInPage().emailSubmit(user.getEmail());
        getSignInPage().implicitWait(TIME_TO_WAIT);
        getSignInPage().passwordSubmit(user.getPassword());
        getSignInPage().implicitWait(TIME_TO_WAIT);
        getSignInPage().waitURLContains(TIME_TO_WAIT, MAIL_URL_KEYWORD);

        //Click on “compose” button
        getGmailPage().waitVisibilityOfElement(TIME_TO_WAIT, getGmailPage().getComposeButton());
        getGmailPage().clickOnComposeButton();

        //Fill the next fields: to, cc, bcc, subject & message
        getGmailPage().clickOnCCLink();
        getGmailPage().clickOnBCCLink();
        getGmailPage().fillTOField(emailData.getTo());
        getGmailPage().fillCCField(emailData.getCc());
        getGmailPage().fillBCCField(emailData.getBcc());
        getGmailPage().fillSubjectField(emailData.getSubject());

        //Click on “save & close” button
        getGmailPage().clickOnCloseAndSave();
        getGmailPage().waitInVisibilityOfElement(TIME_TO_WAIT, getGmailPage().getCloseAndSave());
        getGmailPage().clickOnDraftCategory();

        //Go to the “draft” folder & open previously saved message
        getDraftPage().waitURLContains(TIME_TO_WAIT, DRAFT_PAGE_URL_KEYWORD);
        getDraftPage().clickOnDraftItem();

        // Verify that all fields are saved correctly
          getDraftPage().waitElementToBeClickable(TIME_TO_WAIT, getDraftPage().getDraftLetterCClinks());
        getDraftPage().clickOnDraftLetterCClinks();
        assertEquals(getDraftPage().getDraftLetterTOValue(), emailData.getTo());
        assertEquals(getDraftPage().getDraftLetterCCValue(), emailData.getCc());
        assertEquals(getDraftPage().getDraftLetterBCCValue(), emailData.getBcc());
        assertEquals(getDraftPage().getDraftLetterSubject(), emailData.getSubject());

        //Press the “send” button
        getDraftPage().clickOnSendButton();
    }
}

