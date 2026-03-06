package com.esign.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "configs.esign")
@Configuration
@ConfigurationPropertiesScan
public class Configs {
    private String uploads;
    private String server;
    private String ginga;
    private String userginga;
    private String passginga;
    private String url;
    private String password;
    private String apibaseurl;
    private String refreshtokenurl;
    
    private String bpmusername;
    private String bpmpassword;
        
        

    /**
     * @return the apibaseurl
     */
    public String getApibaseurl() {
        return apibaseurl;
    }

    /**
     * @return the bpmusername
     */
    public String getBpmusername() {
        return bpmusername;
    }

    /**
     * @param bpmusername the bpmusername to set
     */
    public void setBpmusername(String bpmusername) {
        this.bpmusername = bpmusername;
    }

    /**
     * @return the bpmpassword
     */
    public String getBpmpassword() {
        return bpmpassword;
    }

    /**
     * @param bpmpassword the bpmpassword to set
     */
    public void setBpmpassword(String bpmpassword) {
        this.bpmpassword = bpmpassword;
    }



    /**
     * @param apibaseurl the apibaseurl to set
     */
    public void setApibaseurl(String apibaseurl) {
        this.apibaseurl = apibaseurl;
    }

    /**
     * @return the refreshtokenurl
     */
    public String getRefreshtokenurl() {
        return refreshtokenurl;
    }

    /**
     * @param refreshtokenurl the refreshtokenurl to set
     */
    public void setRefreshtokenurl(String refreshtokenurl) {
        this.refreshtokenurl = refreshtokenurl;
    }

    /**
     * @return String return the uploads
     */
    public String getUploads() {
        return uploads;
    }

    /**
     * @param uploads the uploads to set
     */
    public void setUploads(String uploads) {
        this.uploads = uploads;
    }

    /**
     * @return String return the server
     */
    public String getServer() {
        return server;
    }

    /**
     * @param server the server to set
     */
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * @return String return the ginga
     */
    public String getGinga() {
        return ginga;
    }

    /**
     * @param ginga the ginga to set
     */
    public void setGinga(String ginga) {
        this.ginga = ginga;
    }

    /**
     * @return String return the userginga
     */
    public String getUserginga() {
        return userginga;
    }

    /**
     * @param userginga the userginga to set
     */
    public void setUserginga(String userginga) {
        this.userginga = userginga;
    }

    /**
     * @return String return the passginga
     */
    public String getPassginga() {
        return passginga;
    }

    /**
     * @param passginga the passginga to set
     */
    public void setPassginga(String passginga) {
        this.passginga = passginga;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    

}
