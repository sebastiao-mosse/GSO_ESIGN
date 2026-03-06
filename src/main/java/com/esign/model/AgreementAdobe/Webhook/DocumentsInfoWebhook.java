package com.esign.model.AgreementAdobe.Webhook;

import java.util.ArrayList;

public class DocumentsInfoWebhook {
    private ArrayList<DocumentsWebhook> documents;



    /**
     * @return ArrayList<DocumentsWebhook> return the documents
     */
    public ArrayList<DocumentsWebhook> getDocuments() {
        return documents;
    }

    /**
     * @param documents the documents to set
     */
    public void setDocuments(ArrayList<DocumentsWebhook> documents) {
        this.documents = documents;
    }

}
