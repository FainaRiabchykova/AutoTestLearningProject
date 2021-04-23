package businesslayer.asserts;

import businesslayer.actions.BaseBusinessLayer;
import static org.testng.AssertJUnit.assertEquals;


public class MessageAsserts extends BaseBusinessLayer {
    public void assertDraftLetterFieldsAreCorrect(){

        assertEquals(draftPage.getDraftLetterTOValue(), emailData.getTo());
        assertEquals(draftPage.getDraftLetterCCValue(), emailData.getCc());
        assertEquals(draftPage.getDraftLetterBCCValue(), emailData.getBcc());
        assertEquals(draftPage.getDraftLetterSubject(), emailData.getSubject());
    }
}
