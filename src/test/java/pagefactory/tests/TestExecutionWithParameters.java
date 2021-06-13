package pagefactory.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TestExecutionWithParameters  extends BaseTest {
    //credentials
    private final String EMAIL = "qariatest@gmail.com";
    private final String PASSWORD = "Aaaa!111";
    //waits
    private final long TIME_TO_WAIT = 30;
    //urls & url keywords
    private final String DRAFT_PAGE_URL_KEYWORD = "drafts";


    @Parameters({"toEmailUser1", "ccEmailUser1", "bccEmailUser1", "subjectUser1"})
    @Test
    public void checkSaveDraftsInGmail(String toEmailUser1, String ccEmailUser1, String bccEmailUser1, String subjectUser1) throws InterruptedException {

        //checkLoginToAccount
        getSignInPage().emailSubmit(EMAIL);
        getSignInPage().passwordSubmit(PASSWORD);

        //Click on “compose” button
        getGmailPage().waitVisibilityOfElement(TIME_TO_WAIT, getGmailPage().getComposeButton());
        getGmailPage().clickOnComposeButton();

        //Fill the next fields: to, cc, bcc, subject & message
        getGmailPage().clickOnCCLink();
        getGmailPage().clickOnBCCLink();
        getGmailPage().fillTOField(toEmailUser1);
        getGmailPage().fillCCField(ccEmailUser1);
        getGmailPage().fillBCCField(bccEmailUser1);
        getGmailPage().fillSubjectField(subjectUser1);

        //Click on “save & close” button
        getGmailPage().clickOnCloseAndSave();
        getGmailPage().clickOnDraftCategory();

        //Go to the “draft” folder & open previously saved message
        getDraftPage().waitURLContains(TIME_TO_WAIT, DRAFT_PAGE_URL_KEYWORD);
        getDraftPage().clickOnDraftItem();

        // Verify that all fields are saved correctly
        getDraftPage().clickOnDraftLetterCClinks();
        assertEquals(getDraftPage().getDraftLetterTOValue(), toEmailUser1);
        assertEquals(getDraftPage().getDraftLetterCCValue(), ccEmailUser1);
        assertEquals(getDraftPage().getDraftLetterBCCValue(), bccEmailUser1);
        assertEquals(getDraftPage().getDraftLetterSubject(), subjectUser1);

        //Press the “send” button
        getDraftPage().clickOnSendButton();
    }
}
