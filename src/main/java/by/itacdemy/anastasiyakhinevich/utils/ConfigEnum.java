package by.itacdemy.anastasiyakhinevich.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ConfigEnum {
    EMAIL("email"),
    PASSWORD("password"),
    BASE_URL("baseUrl"),
    API_URL("apiUrl"),
    API_KEY("apiKey"),
    API_TOKEN("apiToken"),
    BROWSER("browser");

    private String param;
}

