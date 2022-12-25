package model;

import lombok.Getter;
import lombok.Setter;
import util.ConfigEnum;
import util.ConfigReader;

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
