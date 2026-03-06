package com.esign.model.AgreementAdobe.Responses;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdobeListEvents {
    private ArrayList<AdobeEventsResponse> events;

    public AdobeListEvents( @JsonProperty("events") ArrayList<AdobeEventsResponse> events)
    {
        this.setEvents(events);

    }

    /**
     * @return AdobeEventsResponse return the events
     */
    public ArrayList<AdobeEventsResponse> getEvents() {
        return events;
    }

    /**
     * @param events the events to set
     */
    @JsonProperty("events")
    public void setEvents(ArrayList<AdobeEventsResponse> events) {
        this.events = events;
    }

}
