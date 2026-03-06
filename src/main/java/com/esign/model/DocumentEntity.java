package com.esign.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "documents")
public class DocumentEntity {

    @Id
    private String document_reference;

    @Column(columnDefinition = "TEXT", name = "temp_transactionId") 
    private String temp_transactionId;
    
    @Column(name = "transactionId")
    private String transactionId;

    private String process_code;

    private String title;

    public DocumentEntity() {
    }

    public DocumentEntity(String docRef, String temTransacID, String transactId, String processCode, String title) {
        this.setDocument_reference(docRef);
        this.setTemp_transactionId(temTransacID);
        this.setTransactionId(transactId);
        this.setProcess_code(processCode);
        this.setTitle(title);
        this.created_at = new Date();
        this.updated_at = new Date();
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

 //   @Temporal(TemporalType.TIMESTAMP)
 //   private Date deleted_at;

    /**
     * @return String return the document_reference
     */
    public String getDocument_reference() {
        return document_reference;
    }

    /**
     * @param document_reference the document_reference to set
     */
    public void setDocument_reference(String document_reference) {
        this.document_reference = document_reference;
    }

    /**
     * @return String return the temp_transactionId
     */
    public String getTemp_transactionId() {
        return this.temp_transactionId;
    }

    /**
     * @param temp_transactionId the temp_transactionId to set
     */
    public void setTemp_transactionId(String temp_transactionId) {
        this.temp_transactionId = temp_transactionId;
    }

    /**
     * @return String return the transactionId
     */
    public String getTransactionId() {
        return this.transactionId;
    }

    /**
     * @param transactionId the transactionId to set
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * @return String return the process_code
     */
    public String getProcess_code() {
        return this.process_code;
    }

    /**
     * @param process_code the process_code to set
     */
    public void setProcess_code(String process_code) {
        this.process_code = process_code;
    }

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

}
