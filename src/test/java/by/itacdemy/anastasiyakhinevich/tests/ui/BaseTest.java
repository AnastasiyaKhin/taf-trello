package by.itacdemy.anastasiyakhinevich.tests.ui;

import by.itacdemy.anastasiyakhinevich.driver.Driver;
import org.testng.annotations.*;
import by.itacdemy.anastasiyakhinevich.utils.ConfigEnum;
import by.itacdemy.anastasiyakhinevich.utils.ConfigReader;

public class BaseTest {

    @BeforeMethod
    public void openPage(){
        Driver.getInstance().navigate().to(ConfigReader.getValue(ConfigEnum.BASE_URL));
    }
    @AfterMethod
    public void closeWebDriver(){
        Driver.closeDriver();
    }
}
