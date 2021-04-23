package pagefactory;

public class MyAccountPage extends BasePage{

    public void openGmail(String gmailURL){
        driver.get(gmailURL);
    }
}
