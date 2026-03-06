package com.esign.model.AgreementAdobe.Webhook;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class AdobeWebhookResponse {
    private String event;
    private Date eventDate;
    @Email
    @NotNull
    private String actingUserEmail;
    @Valid
    @NotNull
    private AgreementWebhook agreement;

    /**
     * @return String return the event
     */
    public String getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(String event) {
        this.event = event;
    }

    /**
     * @return Date return the eventDate
     */
    public Date getEventDate() {
        return eventDate;
    }

    /**
     * @param eventDate the eventDate to set
     */
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
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
    public void setActingUserEmail(String actingUserEmail) {
        this.actingUserEmail = actingUserEmail;
    }

    /**
     * @return AgreementWebhook return the agreement
     */
    public AgreementWebhook getAgreement() {
        return agreement;
    }

    /**
     * @param agreement the agreement to set
     */
    public void setAgreement(AgreementWebhook agreement) {
        this.agreement = agreement;
    }


}
