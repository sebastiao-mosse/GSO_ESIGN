package com.esign.model.AgreementAdobe.Responses;

import java.util.Date;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdobeEventsResponse {
    @JsonProperty("id")
    private String id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("actingUserEmail")
    private String actingUserEmail;

    @JsonProperty("actingUserName")
    private String actingUserName;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("description")
    private String description;

    @JsonProperty("participantEmail")
    private String participantEmail;

    @JsonProperty("participantId")
    private String participantId;

    @JsonProperty("participantRole")
    private String participantRole;

    @JsonProperty("versionId")
    private String versionId;

    @JsonProperty("comment")
    private String comment;

    @JsonCreator
    public AdobeEventsResponse(@JsonProperty("id") String id, @JsonProperty("type") String type,
            @JsonProperty("actingUserName") String actingUserName,
            @JsonProperty("actingUserEmail") String actingUserEmail, @JsonProperty("date") Date date,
            @JsonProperty("description") String description, @JsonProperty("participantEmail") String participantEmail,
            @JsonProperty("participantId") String participantId,
            @JsonProperty("participantRole") String participantRole,
            @JsonProperty("versionId") String versionId, @JsonProperty("comment") String comment) {
        this.setActingUserEmail(actingUserEmail);
        this.setActingUserName(actingUserName);
        this.setComment(comment);
        this.setDate(date);
        this.setDescription(description);
        this.setId(id);
        this.setParticipantEmail(participantEmail);
        this.setParticipantId(participantId);
        this.setParticipantRole(participantRole);
        this.setType(type);
        this.setVersionId(versionId);

    }

    /**
     * @return String return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return String return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return String return the actingUserEmail
     */
    public String getActingUserEmail() {
        return actingUserEmail;
    }

    /**
     * @param actingUserEmail the actingUserEmail to set
     */
    @JsonProperty("actingUserEmail")
    public void setActingUserEmail(String actingUserEmail) {
        this.actingUserEmail = actingUserEmail;
    }

    /**
     * @return String return the actingUserName
     */
    public String getActingUserName() {
        return actingUserName;
    }

    /**
     * @param actingUserName the actingUserName to set
     */
    @JsonProperty("actingUserName")
    public void setActingUserName(String actingUserName) {
        this.actingUserName = actingUserName;
    }

    /**
     * @return Date return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    @JsonProperty("date")
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return String return the participantEmail
     */
    public String getParticipantEmail() {
        return participantEmail;
    }

    /**
     * @param participantEmail the participantEmail to set
     */
    @JsonProperty("participantEmail")
    public void setParticipantEmail(String participantEmail) {
        this.participantEmail = participantEmail;
    }

    /**
     * @return String return the participantId
     */
    public String getParticipantId() {
        return participantId;
    }

    /**
     * @param participantId the participantId to set
     */
    @JsonProperty("participantId")
    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    /**
     * @return String return the participantRole
     */
    public String getParticipantRole() {
        return participantRole;
    }

    /**
     * @param participantRole the participantRole to set
     */
    @JsonProperty("participantRole")
    public void setParticipantRole(String participantRole) {
        this.participantRole = participantRole;
    }

    /**
     * @return String return the versionId
     */
    public String getVersionId() {
        return versionId;
    }

    /**
     * @param versionId the versionId to set
     */
    @JsonProperty("versionId")
    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    /**
     * @return String return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    @JsonProperty("comment")
    public void setComment(String comment) {
        this.comment = comment;
    }

}
