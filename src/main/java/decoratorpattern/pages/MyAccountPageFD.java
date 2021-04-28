package decoratorpattern.pages;

public class MyAccountPageFD extends  BasePageFD{
    public void openGmail(String gmailURL){
        driver.get(gmailURL);
    }
}
