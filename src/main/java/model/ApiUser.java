package model;

import lombok.Getter;
import lombok.Setter;
import util.ConfigEnum;
import util.ConfigReader;

@Getter
@Setter
public class ApiUser {
    private final String API_KEY = ConfigReader.getValue(ConfigEnum.API_KEY);
    private final String API_TOKEN = ConfigReader.getValue(ConfigEnum.API_TOKEN);
    private String apiKey;
    private String apiToken;

    public ApiUser() {
        this.apiKey = API_KEY;
        this.apiToken = API_TOKEN;
    }
}
