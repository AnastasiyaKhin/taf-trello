package by.itacdemy.anastasiyakhinevich.driver;

import by.itacdemy.anastasiyakhinevich.browser.WebDriverFactory;
import by.itacdemy.anastasiyakhinevich.utils.ConfigEnum;
import by.itacdemy.anastasiyakhinevich.utils.ConfigReader;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class Driver {
    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

    private Driver() {
    }

    public static WebDriver getInstance() {
        if (Objects.isNull(getThreadLocalDriver())) {
            WebDriver driver = WebDriverFactory.installDriver(getValueOfBrowser());
            threadLocalDriver.set(driver);
        }
        WebDriver driver = getThreadLocalDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver getThreadLocalDriver() {
        return threadLocalDriver.get();
    }

    private static DriverManagerType getValueOfBrowser() {
        String browserSystem = System.getProperty("browser");
        return Objects.isNull(browserSystem) ?
                DriverManagerType.valueOf(ConfigReader.getValue(ConfigEnum.BROWSER).toUpperCase()) :
                DriverManagerType.valueOf(browserSystem.toUpperCase());
    }

    public static void closeDriver() {
        getInstance().quit();
        threadLocalDriver.remove();
    }
}
