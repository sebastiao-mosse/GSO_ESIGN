package com.esign.model.AgreementAdobe;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseRefreshToken {

    private String access_token;

    private String token_type;

    private int expires_in;
    
    @JsonCreator
    public ResponseRefreshToken(@JsonProperty("access_token") String access,
            @JsonProperty("token_type") String type, @JsonProperty("expires_in") int expires) {
        this.access_token = access;
        this.token_type = type;
        this.expires_in = expires;
    }

    public ResponseRefreshToken() {
    }

    public int getExpires_in() {
        return expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

}
