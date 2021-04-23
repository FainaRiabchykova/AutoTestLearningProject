package pagefactory.tests;

import businesslayer.actions.MessageActions;
import businesslayer.actions.SignInActions;
import businesslayer.asserts.MessageAsserts;
import businesslayer.datamanager.User;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestExecutionViaBusinessLayer extends BaseTest {

    SignInActions signInActions = new SignInActions();
    MessageActions messageActions = new MessageActions();
    MessageAsserts messageAsserts = new MessageAsserts();

    @Test(dataProvider = "riaTest", dataProviderClass = DataProviderClass.class)

    public void checkSaveDraftsInGmail(User user) throws InterruptedException {

        signInActions.signIn(user);
        messageActions.createDraftLetter();
        messageActions.openDraftLetter();
        messageAsserts.assertDraftLetterFieldsAreCorrect();
        messageActions.sendDraftLetter();

    }
}
