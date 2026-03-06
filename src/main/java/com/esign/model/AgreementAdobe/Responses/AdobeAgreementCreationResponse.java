package com.esign.model.AgreementAdobe.Responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AdobeAgreementCreationResponse {
    private String id;

    @JsonCreator
    public AdobeAgreementCreationResponse(@JsonProperty("id") String id) {
        this.setLibraryDocumentId(id);
    }

    public String getLibraryDocumentId() {
        return id;
    }

    public void setLibraryDocumentId(String id) {
        this.id = id;
    }

}
