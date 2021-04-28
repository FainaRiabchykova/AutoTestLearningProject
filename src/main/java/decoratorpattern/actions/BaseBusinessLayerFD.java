package decoratorpattern.actions;

import businesslayer.datamanager.EmailData;
import businesslayer.datamanager.EmailProvider;
import decoratorpattern.pages.DraftPageFD;
import decoratorpattern.pages.GmailPageFD;
import decoratorpattern.pages.SignInPageFD;

public class BaseBusinessLayerFD {

    SignInPageFD signInPageFD = new SignInPageFD();
    GmailPageFD gmailPageFD = new GmailPageFD();
    protected DraftPageFD draftPageFD = new DraftPageFD();

    protected EmailData emailData = EmailProvider.getEmailData();

    protected final long TIME_TO_WAIT = 30;
    protected final String MAIL_URL_KEYWORD = "mail";
    protected final String DRAFT_PAGE_URL_KEYWORD = "drafts";

}
