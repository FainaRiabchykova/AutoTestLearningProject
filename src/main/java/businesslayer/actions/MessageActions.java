package businesslayer.actions;

public class MessageActions extends BaseBusinessLayer {

    public void createDraftLetter() {
        //Click on “compose” button
        gmailPage.waitVisibilityOfElement(TIME_TO_WAIT, gmailPage.getComposeButton());
        gmailPage.clickOnComposeButton();
        //Fill the next fields: to, cc, bcc, subject & message
        gmailPage.clickOnCCLink();
        gmailPage.clickOnBCCLink();
        gmailPage.fillTOField(emailData.getTo());
        gmailPage.fillCCField(emailData.getCc());
        gmailPage.fillBCCField(emailData.getBcc());
        gmailPage.fillSubjectField(emailData.getSubject());
        //Click on “save & close” button
        gmailPage.clickOnCloseAndSave();
    }

    public void openDraftLetter() {
        //Go to the “draft” folder & open previously saved message
        gmailPage.waitInVisibilityOfElement(TIME_TO_WAIT, gmailPage.getCloseAndSave());
        gmailPage.clickOnDraftCategory();
        draftPage.waitURLContains(TIME_TO_WAIT, DRAFT_PAGE_URL_KEYWORD);
        draftPage.clickOnDraftItem();
        draftPage.waitElementToBeClickable(TIME_TO_WAIT, draftPage.getDraftLetterCClinks());
        draftPage.clickOnDraftLetterCClinks();
    }

    public void sendDraftLetter() {
        //Press the “send” button
        draftPage.clickOnSendButton();
    }
}
