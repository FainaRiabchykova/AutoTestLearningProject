package decoratorpattern.actions;

public class MessageActionsFD extends BaseBusinessLayerFD {

    public void createDraftLetter() {
        //Click on “compose” button
        gmailPageFD.waitVisibilityOfElement(TIME_TO_WAIT, gmailPageFD.getComposeButton());
        gmailPageFD.clickOnComposeButton();
        //Fill the next fields: to, cc, bcc, subject & message
        gmailPageFD.clickOnCCLink();
        gmailPageFD.clickOnBCCLink();
        gmailPageFD.fillTOField(emailData.getTo());
        gmailPageFD.fillCCField(emailData.getCc());
        gmailPageFD.fillBCCField(emailData.getBcc());
        gmailPageFD.fillSubjectField(emailData.getSubject());
        //Click on “save & close” button
        gmailPageFD.clickOnCloseAndSave();
    }

    public void openDraftLetter() {
        //Go to the “draft” folder & open previously saved message
        gmailPageFD.waitInVisibilityOfElement(TIME_TO_WAIT, gmailPageFD.getCloseAndSave());
        gmailPageFD.clickOnDraftCategory();
        draftPageFD.waitURLContains(TIME_TO_WAIT, DRAFT_PAGE_URL_KEYWORD);
        draftPageFD.clickOnDraftItem();
        draftPageFD.waitElementToBeClickable(TIME_TO_WAIT, draftPageFD.getDraftLetterCClinks());
        draftPageFD.clickOnDraftLetterCClinks();
    }

    public void sendDraftLetter() {
        //Press the “send” button
        draftPageFD.clickOnSendButton();
    }
}
