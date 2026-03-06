package com.esign.model.AgreementAdobe.Webhook;

import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AgreementWebhook {
    @NotBlank(message = "The city is required.")
    @NotNull(message = "The extras is required.")
    private String id;
    private String name;
    private String signatureType;
    private String status;
    private Boolean documentVisibilityEnabled;
    private Date createdDate;
    private String locale;
    @Email
    private String senderEmail;
    private WebhookParticipantSetInfo participantSetsInfo;
    private DocumentsInfoWebhook documentsInfo;
    private WebhookSignedDocumentInfo signedDocumentInfo;

    


    /**
     * @return String return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the signatureType
     */
    public String getSignatureType() {
        return signatureType;
    }

    /**
     * @param signatureType the signatureType to set
     */
    public void setSignatureType(String signatureType) {
        this.signatureType = signatureType;
    }

    /**
     * @return String return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return Boolean return the documentVisibilityEnabled
     */
    public Boolean isDocumentVisibilityEnabled() {
        return documentVisibilityEnabled;
    }

    /**
     * @param documentVisibilityEnabled the documentVisibilityEnabled to set
     */
    public void setDocumentVisibilityEnabled(Boolean documentVisibilityEnabled) {
        this.documentVisibilityEnabled = documentVisibilityEnabled;
    }

    /**
     * @return Date return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return String return the locale
     */
    public String getLocale() {
        return locale;
    }

    /**
     * @param locale the locale to set
     */
    public void setLocale(String locale) {
        this.locale = locale;
    }

    /**
     * @return String return the senderEmail
     */
    public String getSenderEmail() {
        return senderEmail;
    }

    /**
     * @param senderEmail the senderEmail to set
     */
    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    /**
     * @return WebhookParticipantSetInfo return the participantSetsInfo
     */
    public WebhookParticipantSetInfo getParticipantSetsInfo() {
        return participantSetsInfo;
    }

    /**
     * @param participantSetsInfo the participantSetsInfo to set
     */
    public void setParticipantSetsInfo(WebhookParticipantSetInfo participantSetsInfo) {
        this.participantSetsInfo = participantSetsInfo;
    }

    /**
     * @return DocumentsInfoWebhook return the documentsInfo
     */
    public DocumentsInfoWebhook getDocumentsInfo() {
        return documentsInfo;
    }

    /**
     * @param documentsInfo the documentsInfo to set
     */
    public void setDocumentsInfo(DocumentsInfoWebhook documentsInfo) {
        this.documentsInfo = documentsInfo;
    }

    /**
     * @return the signedDocumentInfo
     */
    public WebhookSignedDocumentInfo getSignedDocumentInfo() {
        return signedDocumentInfo;
    }

    /**
     * @param signedDocumentInfo the signedDocumentInfo to set
     */
    public void setSignedDocumentInfo(WebhookSignedDocumentInfo signedDocumentInfo) {
        this.signedDocumentInfo = signedDocumentInfo;
    }

    
}
