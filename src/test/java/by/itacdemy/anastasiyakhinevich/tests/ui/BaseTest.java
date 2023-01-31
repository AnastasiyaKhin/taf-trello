package by.itacdemy.anastasiyakhinevich.tests.ui;

import by.itacdemy.anastasiyakhinevich.driver.Driver;
import by.itacdemy.anastasiyakhinevich.utils.ConfigEnum;
import by.itacdemy.anastasiyakhinevich.utils.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void openPage() {
        Driver.getInstance().navigate().to(ConfigReader.getValue(ConfigEnum.BASE_URL));
    }

    @AfterMethod
    public void closeWebDriver() {
        Driver.closeDriver();
    }
}
