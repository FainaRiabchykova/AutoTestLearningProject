package pagefactory.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pagefactory.*;

public class BaseTest {

    private static final String SIGN_IN_URL = "https://mail.google.com";

    @BeforeMethod
    public void testsSetUp() {
        DriverProviderManager.getDriver().get(SIGN_IN_URL);
    }

    @AfterMethod
    public void tearDown() {
        DriverProviderManager.closeDriver();
    }


    public WebDriver getDriver() {
        return DriverProviderManager.getDriver();
    }

    public SignInPage getSignInPage() {
        return new SignInPage();
    }

    public MyAccountPage getMyAccountPage() {
        return new MyAccountPage();
    }

    public GmailPage getGmailPage() {
        return new GmailPage();
    }

    public DraftPage getDraftPage() {
        return new DraftPage();
    }

}

