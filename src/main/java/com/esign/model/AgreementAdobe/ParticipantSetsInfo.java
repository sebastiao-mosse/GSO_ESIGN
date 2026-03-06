package com.esign.model.AgreementAdobe;

import java.util.ArrayList;

public class ParticipantSetsInfo {
    private String id;
    private int order;
    private String role;
    private ArrayList<CcInfo> memberInfos;
    public int getOrder() {
        return order;
    }
    public ArrayList<CcInfo> getMemberInfos() {
        return memberInfos;
    }
    public void setMemberInfos(ArrayList<CcInfo> memberInfos) {
        this.memberInfos = memberInfos;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setOrder(int order) {
        this.order = order;
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
    public void setId(String id) {
        this.id = id;
    }

}
