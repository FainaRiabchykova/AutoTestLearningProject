package decoratorpattern.actions;

import businesslayer.datamanager.User;
import io.qameta.allure.Step;

public class SignInActionsFD extends BaseBusinessLayerFD {

    @Step("User logs in: {0}")
    public void signIn(User user) {
        //checkLoginToAccount
        signInPageFD.waitVisibilityOfElement(TIME_TO_WAIT, signInPageFD.getEmailInputField());
        signInPageFD.emailSubmit(user.getEmail());
        signInPageFD.passwordSubmit(user.getPassword());
        signInPageFD.waitURLContains(TIME_TO_WAIT, MAIL_URL_KEYWORD);
        logger.info("User {} has been signed In", user.getEmail() );
    }
}
