package by.itacdemy.anastasiyakhinevich.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Board {
    public boolean closed;
    public Object _value;
    private String id;
    private String name;
    private String url;
    private String shortUrl;
}
