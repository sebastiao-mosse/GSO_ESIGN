package com.esign.model;


public class SignatureResponse {
    
    private String libraryDocumentId;
    private Integer status;
    private String message;
    
    public SignatureResponse(){}

    public SignatureResponse(String libraryDocumentId, Integer status, String msg)
    {
        this.setStatus(status);
        this.setMessage(msg);
        this.setLibraryDocumentId(libraryDocumentId);
    }

    /**
     * @return String return the libraryDocumentId
     */
    public String getLibraryDocumentId() {
        return libraryDocumentId;
    }

    /**
     * @param libraryDocumentId the libraryDocumentId to set
     */
    public void setLibraryDocumentId(String libraryDocumentId) {
        this.libraryDocumentId = libraryDocumentId;
    }

    /**
     * @return Long return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return String return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
