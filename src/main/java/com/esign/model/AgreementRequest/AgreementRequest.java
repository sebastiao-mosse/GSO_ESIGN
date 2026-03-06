package com.esign.model.AgreementRequest;

import java.util.ArrayList;

public class AgreementRequest {

    private ArrayList<InformacaoFicheiro> informacaoFicheiro;
    private String titulo;
    private String libraryDocumentId;
    private ArrayList<InformacaoParticipantes> informacaoParticipantes;
    private ArrayList<InformacaoCampos> informacaoCampos;
    private ArrayList<InformacaoCc> informacaoCc;
    private String tipoAssinatura;
    private String estado;

    public AgreementRequest(String titulo, String tipoAss, String estad, String libraryDocumentId) {
        this.setEstado(estad);
        this.setTipoAssinatura(tipoAss);
        this.setTitulo(titulo);
        this.setLibraryDocumentId(libraryDocumentId);
        this.setInformacaoParticipantes(new ArrayList<InformacaoParticipantes>());
        this.setInformacaoCampos(new ArrayList<InformacaoCampos>());
        this.setInformacaoCc(new ArrayList<InformacaoCc>());
        this.setInformacaoFicheiro(new ArrayList<InformacaoFicheiro>());
    }

    
    
    /**
     * @return the libraryDocumentId
     */
    public String getLibraryDocumentId() {
        return libraryDocumentId;
    }



    /**
     * @param libraryDocumentId the libraryDocumentId to set
     */
    public void setLibraryDocumentId(String libraryDocumentId) {
        this.libraryDocumentId = libraryDocumentId;
    }



    /**
     * @return String return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    public ArrayList<InformacaoCc> getInformacaoCc() {
        return informacaoCc;
    }

    public void setInformacaoCc(ArrayList<InformacaoCc> informacaoCc) {
        this.informacaoCc = informacaoCc;
    }

    public ArrayList<InformacaoParticipantes> getInformacaoParticipantes() {
        return informacaoParticipantes;
    }

    public void setInformacaoParticipantes(ArrayList<InformacaoParticipantes> informacaoParticipantes) {
        this.informacaoParticipantes = informacaoParticipantes;
    }

    public ArrayList<InformacaoCampos> getInformacaoCampos() {
        return informacaoCampos;
    }

    public void setInformacaoCampos(ArrayList<InformacaoCampos> informacaoCampos) {
        this.informacaoCampos = informacaoCampos;
    }

    public ArrayList<InformacaoFicheiro> getInformacaoFicheiro() {
        return informacaoFicheiro;
    }

    public void setInformacaoFicheiro(ArrayList<InformacaoFicheiro> informacaoFicheiro) {
        this.informacaoFicheiro = informacaoFicheiro;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoAssinatura() {
        return tipoAssinatura;
    }

    public void setTipoAssinatura(String tipoAssinatura) {
        this.tipoAssinatura = tipoAssinatura;
    }

}
