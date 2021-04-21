package pagefactory.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pagefactory.*;

public class BaseTest {
    //DriverProvider driver;

    // WebDriver driver;
    private static final String SIGN_IN_URL = "https://accounts.google.com";

//    @BeforeTest
//    public void profileSetUp() {
//        WebDriverManager.chromedriver().setup();
//        this.driver = DriverProvider.getDriver();
//        this.driver = DriverProvider.getDriver();
//        chromedriver().setup();
//    }

    @BeforeMethod
    public void testsSetUp() {

//        this.driver = DriverProvider.getDriver();
//        driver.manage().window().maximize();
        DriverProviderManager.getDriver().get(SIGN_IN_URL);
    }


    @AfterMethod
    public void tearDown() {
        DriverProviderManager.closeDriver();
        // driver.close();
    }

    //    public WebDriver getDriver() {
//        return driver;
//    }
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

