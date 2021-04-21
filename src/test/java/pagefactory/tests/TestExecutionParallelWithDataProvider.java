package pagefactory.tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TestExecutionParallelWithDataProvider extends BaseTest {
    //credentials
    private final String EMAIL = "dfgyuuyguyg@gmail.com";
    private final String PASSWORD = "sdrsdfjghjh";
    //waits
    private final long TIME_TO_WAIT = 30;
    //urls & url keywords
    private static final String GMAIL_URL = "https://mail.google.com/mail/u/0/?tab=km#inbox";
    private final String MAIL_URL_KEYWORD = "mail";
    private final String DRAFT_PAGE_URL_KEYWORD = "drafts";



    @Test(dataProvider = "riaTest", dataProviderClass = DataProviderClass.class)

    public void checkSaveDraftsInGmail(String toEmailUser, String ccEmailUser, String bccEmailUser, String subjectUser) throws InterruptedException {

        EmailMessage message = EmailGenerator.getSampleEmail();
        //checkLoginToAccount
        getSignInPage().emailSubmit(EMAIL);
        getSignInPage().implicitWait(TIME_TO_WAIT);
        getSignInPage().passwordSubmit(PASSWORD);
        getSignInPage().implicitWait(TIME_TO_WAIT);
        getSignInPage().waitURLContains(TIME_TO_WAIT, MAIL_URL_KEYWORD);

        //Click on “compose” button
        getGmailPage().waitVisibilityOfElement(TIME_TO_WAIT, getGmailPage().getComposeButton());
        getGmailPage().clickOnComposeButton();

        //Fill the next fields: to, cc, bcc, subject & message
        getGmailPage().clickOnCCLink();
        getGmailPage().clickOnBCCLink();
        getGmailPage().fillTOField(message.getTo());
        getGmailPage().fillCCField(message.getCc());
        getGmailPage().fillBCCField(message.getBcc());
        getGmailPage().fillSubjectField(message.getSubject());

        //Click on “save & close” button
        getGmailPage().clickOnCloseAndSave();
        Thread.sleep(7000);
        getGmailPage().clickOnDraftCategory();

        //Go to the “draft” folder & open previously saved message
        getDraftPage().waitURLContains(TIME_TO_WAIT, DRAFT_PAGE_URL_KEYWORD);
        getDraftPage().clickOnDraftItem(subjectUser);

        // Verify that all fields are saved correctly
        getDraftPage().clickOnDraftLetterCClinks();
        assertEquals(getDraftPage().getDraftLetterTOValue(), toEmailUser);
        assertEquals(getDraftPage().getDraftLetterCCValue(), ccEmailUser);
        assertEquals(getDraftPage().getDraftLetterBCCValue(), bccEmailUser);
        assertEquals(getDraftPage().getDraftLetterSubject(), subjectUser);

        //Press the “send” button
        getDraftPage().clickOnSendButton();
    }
}
