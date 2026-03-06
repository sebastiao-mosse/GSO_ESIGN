package com.esign.model;

public class AdobeSignClient {
    private String xAdobeSignClientId;

    public AdobeSignClient(String clientid) {
        this.setXAdobeSignClientId(clientid);
    }
    

    /**
     * @return String return the xAdobeSignClientId
     */
    public String getXAdobeSignClientId() {
        return xAdobeSignClientId;
    }

    /**
     * @param xAdobeSignClientId the xAdobeSignClientId to set
     */
    public void setXAdobeSignClientId(String clientid) {
        this.xAdobeSignClientId = clientid;
    }

}
