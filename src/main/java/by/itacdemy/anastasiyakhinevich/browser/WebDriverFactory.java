package by.itacdemy.anastasiyakhinevich.browser;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    public static WebDriver installDriver(DriverManagerType type) {
        WebDriver driver;
        switch (type) {
            case CHROME:
                driver = new ChromeDriverManager().createDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriverManager().createDriver();
                break;
            case EDGE:
                driver = new EdgeDriverManager().createDriver();
                break;
            default:
                driver = new ChromeDriverManager().createDriver();
        }
        return driver;
    }
}
