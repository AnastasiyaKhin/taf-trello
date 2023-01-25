package by.itacdemy.anastasiyakhinevich.model;

import by.itacdemy.anastasiyakhinevich.utils.ConfigEnum;
import by.itacdemy.anastasiyakhinevich.utils.ConfigReader;
import lombok.Getter;
import lombok.Setter;

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
