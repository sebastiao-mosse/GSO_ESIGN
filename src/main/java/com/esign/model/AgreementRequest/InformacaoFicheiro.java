package com.esign.model.AgreementRequest;

public class InformacaoFicheiro {
    private String tempDocumentId;
    private String libraryDocumentId;

    public InformacaoFicheiro(){}
    
    public InformacaoFicheiro(String libraryDocumentId)
    {
        this.setLibraryDocumentId(libraryDocumentId);
    }

    /**
     * @return the tempDocumentId
     */
    public String getTempDocumentId() {
        return tempDocumentId;
    }

    /**
     * @param tempDocumentId the tempDocumentId to set
     */
    public void setTempDocumentId(String tempDocumentId) {
        this.tempDocumentId = tempDocumentId;
    }

    /**
     * @return the libraryDocumentId
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


    
}