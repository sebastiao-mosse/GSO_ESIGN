package com.esign.model.AgreementRequest;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class InformacaoParticipantes {
    private int ordem;
    private String perfil;

    private ArrayList<InformacaoCc> informacaoMembro;

    public InformacaoParticipantes(Integer ordem, String perfil)
    {
        this.setOrdem(ordem);
        this.setPerfil(perfil);
        this.setInformacaoMembro(new ArrayList<InformacaoCc>());
    }

    public InformacaoParticipantes()
    {
        this.setInformacaoMembro(new ArrayList<InformacaoCc>());
        this.getInformacaoMembro().add(new InformacaoCc());
    }

    /**
     * @return int return the ordem
     */
    public int getOrdem() {
        return ordem;
    }

    public ArrayList<InformacaoCc> getInformacaoMembro() {
        return informacaoMembro;
    }

    public void setInformacaoMembro(ArrayList<InformacaoCc> informacaoMembro) {
        this.informacaoMembro = informacaoMembro;
    }

    /**
     * @param ordem the ordem to set
     */
    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    /**
     * @return String return the perfil
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}