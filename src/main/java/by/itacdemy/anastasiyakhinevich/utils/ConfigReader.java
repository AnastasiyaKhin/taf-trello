package by.itacdemy.anastasiyakhinevich.utils;

import java.util.ResourceBundle;

public class ConfigReader {
    private static ResourceBundle rb = ResourceBundle.getBundle("config");
    public static String getValue(ConfigEnum configEnum){
        String result = rb.getString(configEnum.getParam());
        return result;
    }
}
