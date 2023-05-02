package by.itacdemy.anastasiyakhinevich.browser;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    public static WebDriver installDriver(DriverManagerType type) {
        DriverManager driverManager;
        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            case EDGE:
                driverManager = new EdgeDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
        }
        return driverManager.createDriver();
    }
}
