package businesslayer.actions;

import businesslayer.datamanager.User;

public class SignInActions extends BaseBusinessLayer {

    public void signIn(User user) {
        //checkLoginToAccount
        signInPage.waitVisibilityOfElement(TIME_TO_WAIT, signInPage.getEmailInputField());
        signInPage.emailSubmit(user.getEmail());
        signInPage.implicitWait(TIME_TO_WAIT);
        signInPage.passwordSubmit(user.getPassword());
        signInPage.implicitWait(TIME_TO_WAIT);
        signInPage.waitURLContains(TIME_TO_WAIT, MAIL_URL_KEYWORD);
    }
}
