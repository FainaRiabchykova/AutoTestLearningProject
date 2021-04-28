package decoratorpattern.actions;

import businesslayer.datamanager.User;

public class SignInActionsFD extends BaseBusinessLayerFD {

    public void signIn(User user) {
        //checkLoginToAccount
        signInPageFD.waitVisibilityOfElement(TIME_TO_WAIT, signInPageFD.getEmailInputField());
        signInPageFD.emailSubmit(user.getEmail());
        signInPageFD.implicitWait(TIME_TO_WAIT);
        signInPageFD.passwordSubmit(user.getPassword());
        signInPageFD.implicitWait(TIME_TO_WAIT);
        signInPageFD.waitURLContains(TIME_TO_WAIT, MAIL_URL_KEYWORD);
    }
}
