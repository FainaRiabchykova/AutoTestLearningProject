package pagefactory.tests;

import businesslayer.actions.MessageActions;
import businesslayer.actions.SignInActions;
import businesslayer.asserts.MessageAsserts;
import businesslayer.datamanager.User;
import org.testng.annotations.Test;

public class TestExecutionViaBusinessLayer extends BaseTest {

    @Test(dataProvider = "riaTest", dataProviderClass = DataProviderClass.class)
    public void checkSaveDraftsInGmail(User user) throws InterruptedException {

        SignInActions signInActions = new SignInActions();
        MessageActions messageActions = new MessageActions();
        MessageAsserts messageAsserts = new MessageAsserts();

        signInActions.signIn(user);
        messageActions.createDraftLetter();
        messageActions.openDraftLetter();
        messageAsserts.assertDraftLetterFieldsAreCorrect();
        messageActions.sendDraftLetter();
    }
}
