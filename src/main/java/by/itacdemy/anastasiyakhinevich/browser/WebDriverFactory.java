package by.itacdemy.anastasiyakhinevich.browser;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    public static WebDriver installDriver(DriverManagerType type) {
        WebDriver driver;
        switch (type) {
            case CHROME:
                driver = new ChromeDriverManager().createDriver();
                driver.manage().window().maximize();
                break;
            case FIREFOX:
                driver = new FirefoxDriverManager().createDriver();
                driver.manage().window().maximize();

                break;
            case EDGE:
                driver = new EdgeDriverManager().createDriver();
                driver.manage().window().maximize();

                break;
            default:
                driver = new ChromeDriverManager().createDriver();
                driver.manage().window().maximize();
        }
        return driver;
    }
}
