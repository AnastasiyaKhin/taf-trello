package by.itacdemy.anastasiyakhinevich.driver;

import by.itacdemy.anastasiyakhinevich.browser.WebDriverFactory;
import by.itacdemy.anastasiyakhinevich.utils.ConfigEnum;
import by.itacdemy.anastasiyakhinevich.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            driver = WebDriverFactory.installDriver(DriverManagerType.valueOf(ConfigReader.getValue(ConfigEnum.BROWSER).toUpperCase()));
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
