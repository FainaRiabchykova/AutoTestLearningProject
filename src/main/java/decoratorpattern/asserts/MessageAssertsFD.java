package decoratorpattern.asserts;

import decoratorpattern.actions.BaseBusinessLayerFD;

import static org.testng.AssertJUnit.assertEquals;


public class MessageAssertsFD extends BaseBusinessLayerFD {

    public void assertDraftLetterFieldsAreCorrect(){

        assertEquals(draftPageFD.getDraftLetterTOValue(), emailData.getTo());
        assertEquals(draftPageFD.getDraftLetterCCValue(), emailData.getCc());
        assertEquals(draftPageFD.getDraftLetterBCCValue(), emailData.getBcc());
        assertEquals(draftPageFD.getDraftLetterSubject(), emailData.getSubject());

    }
}
