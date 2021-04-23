package businesslayer.actions;

import businesslayer.datamanager.EmailData;
import businesslayer.datamanager.EmailProvider;
import pagefactory.DraftPage;
import pagefactory.GmailPage;
import pagefactory.SignInPage;

public class BaseBusinessLayer {

    protected SignInPage signInPage = new SignInPage();
    GmailPage gmailPage = new GmailPage();
    protected DraftPage draftPage = new DraftPage();

    protected EmailData emailData = EmailProvider.getEmailData();

    protected final long TIME_TO_WAIT = 30;
    protected final String MAIL_URL_KEYWORD = "mail";
    protected final String DRAFT_PAGE_URL_KEYWORD = "drafts";
}
