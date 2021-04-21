package pagefactory;

import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage{

    public void openGmail(String gmailURL){
        driver.get(gmailURL);
    }
}
