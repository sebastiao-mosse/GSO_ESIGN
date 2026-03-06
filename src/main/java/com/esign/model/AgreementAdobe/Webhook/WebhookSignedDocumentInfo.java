package com.esign.model.AgreementAdobe.Webhook;

import java.util.ArrayList;

import com.esign.model.AgreementAdobe.ParticipantSetsInfo;

public class WebhookSignedDocumentInfo {
    private ArrayList<SignedDocumentInfo> signedDocumentInfo;

    /**
     * @return the signedDocumentInfo
     */
    public ArrayList<SignedDocumentInfo> getSignedDocumentInfo() {
        return signedDocumentInfo;
    }

    /**
     * @param signedDocumentInfo the signedDocumentInfo to set
     */
    public void setSignedDocumentInfo(ArrayList<SignedDocumentInfo> signedDocumentInfo) {
        this.signedDocumentInfo = signedDocumentInfo;
    }
    

    
}
