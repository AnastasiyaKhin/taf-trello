package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)

public class Board {
    private String id;
    private String name;
    public boolean closed;
    private String url;
    private String shortUrl;
    public Object _value;
}
