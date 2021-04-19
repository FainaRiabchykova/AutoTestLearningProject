package pagefactory;

import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage{

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    public void openGmail(String gmailURL){
        driver.get(gmailURL);
    }
}
