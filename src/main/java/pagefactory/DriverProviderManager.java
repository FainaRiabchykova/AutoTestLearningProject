package pagefactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class DriverProviderManager {


    static {
        WebDriverManager.chromedriver().setup();
    }

    protected static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static synchronized WebDriver getDriver() {
        if (Objects.isNull(driverPool.get())) {

            driverPool.set(new ChromeDriver());
            driverPool.get().manage().window().maximize();
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().close();
            driverPool.remove();
        }
    }
}
