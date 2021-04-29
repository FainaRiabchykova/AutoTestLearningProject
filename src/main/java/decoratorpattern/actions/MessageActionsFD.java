package decoratorpattern.actions;

import io.qameta.allure.Step;

public class MessageActionsFD extends BaseBusinessLayerFD {

    @Step("User creates and saves Draft Letter")
    public void createDraftLetter() {
        //Click on “compose” button
        logger.info("Starting creating DraftLetter");
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
        logger.info("DraftLetter has been created");
    }

    @Step("User opens Draft Letter")
    public void openDraftLetter() {
        //Go to the “draft” folder & open previously saved message
        logger.info("Starting opening DraftLetter");
        gmailPageFD.waitInVisibilityOfElement(TIME_TO_WAIT, gmailPageFD.getCloseAndSave());
        gmailPageFD.clickOnDraftCategory();
        draftPageFD.waitURLContains(TIME_TO_WAIT, DRAFT_PAGE_URL_KEYWORD);
        draftPageFD.clickOnDraftItem();
        draftPageFD.waitElementToBeClickable(TIME_TO_WAIT, draftPageFD.getDraftLetterCClinks());
        draftPageFD.clickOnDraftLetterCClinks();
        logger.info("DraftLetter has been opened");
    }
    @Step("User sends Draft Letter")
    public void sendDraftLetter() {
        //Press the “send” button
        draftPageFD.clickOnSendButton();
        logger.info("DraftLetter has been sent");
    }
}
