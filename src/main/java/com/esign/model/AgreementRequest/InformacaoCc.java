package com.esign.model.AgreementRequest;

public class InformacaoCc {
    private String email;

    

    public InformacaoCc(String email)
    {
        this.setEmail(email);

    }

    public InformacaoCc(){};

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}