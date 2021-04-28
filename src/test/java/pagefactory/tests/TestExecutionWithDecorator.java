package pagefactory.tests;

import businesslayer.datamanager.User;
import decoratorpattern.actions.MessageActionsFD;
import decoratorpattern.actions.SignInActionsFD;
import decoratorpattern.asserts.MessageAssertsFD;
import org.testng.annotations.Test;

public class TestExecutionWithDecorator extends BaseTest{
    @Test(dataProvider = "riaTest", dataProviderClass = DataProviderClass.class)
    public void checkSaveDraftsInGmail(User user) throws InterruptedException {

        SignInActionsFD signInActions = new SignInActionsFD();
        MessageActionsFD messageActions = new MessageActionsFD();
        MessageAssertsFD messageAsserts = new MessageAssertsFD();

        signInActions.signIn(user);
        messageActions.createDraftLetter();
        messageActions.openDraftLetter();
        messageAsserts.assertDraftLetterFieldsAreCorrect();
        messageActions.sendDraftLetter();
    }
}
