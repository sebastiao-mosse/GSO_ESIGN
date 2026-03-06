package com.esign.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.esign.util.AESEncryptionDecryption;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="configs")

public class TokenInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String token_string;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "client_id")
    private String clientId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String client_secret;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String refresh_token;
    
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String adobe_client_id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String password;
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    private boolean deleted = Boolean.FALSE;

    @Temporal(TemporalType.TIMESTAMP)
    private Date expireted_at;

    /**
     * @return Integer return the id
     */
    public Long getId() {
        return id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getRefresh_token() {
        return AESEncryptionDecryption.decrypt(refresh_token, this.password);
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = AESEncryptionDecryption.encrypt(refresh_token, this.password);
    }

    public String getClient_id() {
        return AESEncryptionDecryption.decrypt(clientId, this.password);
    }

    public void setClient_id(String client_id) {
        this.clientId = AESEncryptionDecryption.encrypt(client_id, this.password);
    }

    public String getClient_secret() {
        return AESEncryptionDecryption.decrypt(client_secret, this.password);
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = AESEncryptionDecryption.encrypt(client_secret, this.password);
    }

    /**
     * @return the adobe_client_id
     */
    public String getAdobe_client_id() {
        return AESEncryptionDecryption.decrypt(adobe_client_id, this.password);
    }

    /**
     * @param adobe_client_id the adobe_client_id to set
     */
    public void setAdobe_client_id(String adobe_client_id) {
        
        this.adobe_client_id = AESEncryptionDecryption.encrypt(adobe_client_id, this.password);
    }
    
    
    
    
    
    

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the token_string
     */
    public String getToken_string() {
        //return token_string;
        return AESEncryptionDecryption.decrypt(token_string, this.password);
    }

    /**
     * @param token_string the token_string to set
     */
    public void setToken_string(String token_string) {
       // this.token_string = token_string;
        this.token_string = AESEncryptionDecryption.encrypt(token_string, this.password);
    }
    

    /**
     * @return Date return the created_at
     */
    public Date getCreated_at() {
        return created_at;
    }

    /**
     * @param created_at the created_at to set
     */
    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    /**
     * @return Date return the updated_at
     */
    public Date getUpdated_at() {
        return updated_at;
    }

    /**
     * @param updated_at the updated_at to set
     */
    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    /**
     * @return Date return the deleted_at
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * @param deleted_at the deleted_at to set
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }


    /**
     * @return Date return the expireted_at
     */
    public Date getExpireted_at() {
        return expireted_at;
    }

    /**
     * @param expireted_at the expireted_at to set
     */
    public void setExpireted_at(Date expireted_at) {
        this.expireted_at = expireted_at;
    }

}
