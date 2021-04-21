package pagefactory.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TestExecutionParallelWithDataProvider extends BaseTest {
    //credentials
    private final String EMAIL = "qariatest@gmail.com";
    private final String PASSWORD = "Aaaa!111";
    //waits
    private final long TIME_TO_WAIT = 30;
    //urls & url keywords
    private static final String GMAIL_URL = "https://mail.google.com/mail/u/0/?tab=km#inbox";
    private final String MY_ACCOUNT_URL_KEYWORD = "myaccount";
    private final String DRAFT_PAGE_URL_KEYWORD = "drafts";



    @Test(dataProvider = "riaTest", dataProviderClass = DataProviderClass.class)

    public void checkSaveDraftsInGmail(String toEmailUser, String ccEmailUser, String bccEmailUser, String subjectUser) throws InterruptedException {

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
        getGmailPage().fillTOField(toEmailUser);
        getGmailPage().fillCCField(ccEmailUser);
        getGmailPage().fillBCCField(bccEmailUser);
        getGmailPage().fillSubjectField(subjectUser);

        //Click on “save & close” button
        getGmailPage().clickOnCloseAndSave();
        Thread.sleep(7000);
        getGmailPage().clickOnDraftCategory();

        //Go to the “draft” folder & open previously saved message
        getDraftPage().waitURLContains(TIME_TO_WAIT, DRAFT_PAGE_URL_KEYWORD);
        getDraftPage().clickOnDraftItem();

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
