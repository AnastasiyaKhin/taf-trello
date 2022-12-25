package ui;

import driver.Driver;
import org.testng.annotations.*;
import util.ConfigEnum;
import util.ConfigReader;

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
