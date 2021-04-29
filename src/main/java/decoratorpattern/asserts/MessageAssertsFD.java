package decoratorpattern.asserts;

import decoratorpattern.actions.BaseBusinessLayerFD;
import io.qameta.allure.Step;

import static org.testng.AssertJUnit.assertEquals;


public class MessageAssertsFD extends BaseBusinessLayerFD {

    @Step("User verifies field")
    public void assertDraftLetterFieldsAreCorrect(){

        assertEquals(draftPageFD.getDraftLetterTOValue(), emailData.getTo());
        assertEquals(draftPageFD.getDraftLetterCCValue(), emailData.getCc());
        assertEquals(draftPageFD.getDraftLetterBCCValue(), emailData.getBcc());
        assertEquals(draftPageFD.getDraftLetterSubject(), emailData.getSubject());
        logger.info("Fields have been verified");
    }
}
