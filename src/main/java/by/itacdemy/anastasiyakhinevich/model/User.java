package by.itacdemy.anastasiyakhinevich.model;

import lombok.Getter;
import lombok.Setter;
import by.itacdemy.anastasiyakhinevich.utils.ConfigEnum;
import by.itacdemy.anastasiyakhinevich.utils.ConfigReader;

@Getter
@Setter
public class User {
    private static final String EMAIL = ConfigReader.getValue(ConfigEnum.EMAIL);
    private static final String PASSWORD = ConfigReader.getValue(ConfigEnum.PASSWORD);
    private String email;
    private String password;

    public User() {
        this.email = EMAIL;
        this.password = PASSWORD;
    }
}
