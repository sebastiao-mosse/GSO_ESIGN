package com.esign.model.AgreementAdobe;

import com.esign.repository.TokenInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class AdobeRefreshToken {
    @Autowired
    TokenInfoRepository tokenInfoRepository;

    private String refresh_token;

    private String client_id;

    private String client_secret;

    private String grant_type = "refresh_token";

    public AdobeRefreshToken(String token, String id, String secret_id) {
        this.refresh_token = token.replace("Bearer ", "");
        this.client_id = id;
        this.client_secret = secret_id;
        this.grant_type = "refresh_token";

    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public ResponseRefreshToken refreshOldToken() {
        ResponseRefreshToken responseRefreshToken = new ResponseRefreshToken();
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "https://secure.eu1.adobesign.com/oauth/v2/refresh";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED.toString());
        headers.add("Accept", MediaType.APPLICATION_JSON.toString()); // Optional in case server sends back JSON data
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        System.out.printf("rt: %s --- ci: %s ---- cs: %s ---- gt: %s", this.refresh_token, this.client_id, this.client_secret, this.grant_type);
        requestBody.add("refresh_token", this.refresh_token);
        requestBody.add("client_id", this.client_id);
        requestBody.add("client_secret", this.client_secret);
        requestBody.add("grant_type", this.grant_type);
        HttpEntity formEntity = new HttpEntity<MultiValueMap<String, String>>(requestBody, headers);
        
        /*
         * bodyRequest.add("refresh_token", this.refresh_token);
         * bodyRequest.add("client_id", this.client_id);
         * bodyRequest.add("client_secret", this.client_secret);
         * bodyRequest.add("grant_type", "refresh_token");
         * HttpHeaders headersRequest = new HttpHeaders();
         * // headers.add("Accept", "application/json");
         * // headers.add("Content-Type",
         * // MediaType.APPLICATION_FORM_URLENCODED.toString());
         * headersRequest.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
         * headersRequest.add("Authorization", "Bearer " + this.getRefresh_token());
         * //HttpEntity<MultiValueMap<String, String>> data = new
         * HttpEntity<>(bodyRequest, headersRequest);
         */
        try {
            ResponseEntity<ResponseRefreshToken> response =  restTemplate.exchange("https://secure.eu1.adobesign.com/oauth/v2/refresh", HttpMethod.POST, formEntity, ResponseRefreshToken.class);
            /*ResponseEntity<ResponseRefreshToken> res = restTemplate.postForEntity(resourceUrl, data,
                    ResponseRefreshToken.class);*/
            /*
             * ResponseEntity<ResponseRefreshToken> res = restTemplate.exchange(
             * resourceUrl, HttpMethod.POST, entity, ResponseRefreshToken.class);
             */
            System.out.println("Response: " + response.getBody().getExpires_in());
            responseRefreshToken = response.getBody(); // get body Refresh Token
            

        } catch (Exception e) {
            System.out.println("Error response: " + e.getMessage());
        }
        return responseRefreshToken;

    }

}
