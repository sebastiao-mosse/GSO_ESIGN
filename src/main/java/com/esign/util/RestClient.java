package com.esign.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient {
    private String base_url = "https://api.eu1.adobesign.com/api/rest/v6";
    private RestTemplate rest;
    private HttpHeaders headers;
    private HttpStatus status;

    public RestClient(String token) {
        this.rest = new RestTemplate();
        this.headers = new HttpHeaders();
        headers.add("Content-type", "application/json");
        headers.add("Accept", "*/*");
        headers.add("Authorization", token);
    }

    public String get(String uri) {
        HttpEntity<String> requEntity = new HttpEntity<String>("", headers);
        ResponseEntity<String> responseEntity = rest.exchange(base_url + uri, HttpMethod.GET, requEntity, String.class);
        this.setStatus(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

    public String post(String uri, String json) {
        HttpEntity<String> requEntity = new HttpEntity<>(json, headers);
        ResponseEntity<String> responseEntity = rest.exchange(base_url + uri, HttpMethod.GET, requEntity, String.class);
        this.setStatus(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

    public void put(String uri, String json) {
        HttpEntity<String> requEntity = new HttpEntity<>(json, headers);
        ResponseEntity<String> responseEntity = rest.exchange(base_url + uri, HttpMethod.PUT, requEntity, String.class);
        this.setStatus(responseEntity.getStatusCode());
    }

    public void delete(String uri)
    {
        HttpEntity<String> requEntity = new HttpEntity<>("",headers);
        ResponseEntity<String> responseEntity = rest.exchange(base_url+uri, HttpMethod.DELETE, requEntity, String.class);
        this.setStatus(responseEntity.getStatusCode());

    }

    /**
     * @return String return the base_url
     */
    public String getBase_url() {
        return base_url;
    }

    /**
     * @param base_url the base_url to set
     */
    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }

    /**
     * @return RestTemplate return the rest
     */
    public RestTemplate getRest() {
        return rest;
    }

    /**
     * @param rest the rest to set
     */
    public void setRest(RestTemplate rest) {
        this.rest = rest;
    }

    /**
     * @return HttpHeaders return the headers
     */
    public HttpHeaders getHeaders() {
        return headers;
    }

    /**
     * @param headers the headers to set
     */
    public void setHeaders(HttpHeaders headers) {
        this.headers = headers;
    }

    /**
     * @return HttpStatus return the status
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

}
