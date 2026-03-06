package com.esign.model.AgreementAdobe.Webhook;

import java.util.ArrayList;

import com.esign.model.AgreementAdobe.ParticipantSetsInfo;

public class WebhookParticipantSetInfo {
    private ArrayList<ParticipantSetsInfo> participantSets;
    


    /**
     * @return ArrayList<ParticipantSetsInfo> return the participantSets
     */
    public ArrayList<ParticipantSetsInfo> getParticipantSets() {
        return participantSets;
    }

    /**
     * @param participantSets the participantSets to set
     */
    public void setParticipantSets(ArrayList<ParticipantSetsInfo> participantSets) {
        this.participantSets = participantSets;
    }

}
