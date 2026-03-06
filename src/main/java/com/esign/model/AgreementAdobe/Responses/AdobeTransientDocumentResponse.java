package com.esign.model.AgreementAdobe.Responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AdobeTransientDocumentResponse {
    public String transientDocumentId;
    @JsonCreator
    public AdobeTransientDocumentResponse(@JsonProperty("transientDocumentId") String transientDocumentId) {
        this.setTransientDocumentId(transientDocumentId);
    }

    public String getTransientDocumentId() {
        return transientDocumentId;
    }

    public void setTransientDocumentId(String transientDocumentId) {
        this.transientDocumentId = transientDocumentId;
    }

}
