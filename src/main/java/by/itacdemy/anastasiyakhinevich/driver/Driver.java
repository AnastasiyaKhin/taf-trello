package by.itacdemy.anastasiyakhinevich.driver;

import by.itacdemy.anastasiyakhinevich.browser.WebDriverFactory;
import by.itacdemy.anastasiyakhinevich.utils.ConfigEnum;
import by.itacdemy.anastasiyakhinevich.utils.ConfigReader;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class Driver {
    private static final DriverManagerType browser =
            DriverManagerType.valueOf(ConfigReader.getValue(ConfigEnum.BROWSER).toUpperCase());
    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getInstance() {
        if (Objects.isNull(driver)) {
            driver = WebDriverFactory.installDriver(browser);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
