package pagefactory.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pagefactory.DraftPage;
import pagefactory.GmailPage;
import pagefactory.MyAccountPage;
import pagefactory.SignInPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {

    private WebDriver driver;
    private static final String SIGN_IN_URL = "https://accounts.google.com";

    @BeforeTest
    public void profileSetUp() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(SIGN_IN_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
    public WebDriver getDriver() {
        return driver;
    }
    public SignInPage getSignInPage() {
        return new SignInPage(getDriver());
    }
    public MyAccountPage getMyAccountPage() {
        return new MyAccountPage(getDriver());
    }
    public GmailPage getGmailPage() {
        return new GmailPage(getDriver());
    }
    public DraftPage getDraftPage() {
        return new DraftPage(getDriver());
    }

}

