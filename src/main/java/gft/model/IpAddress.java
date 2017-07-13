package gft.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class IpAddress {

    private String origin;

    @JsonCreator
    public IpAddress(@JsonProperty("origin") String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }
}
