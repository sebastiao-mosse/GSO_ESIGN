package com.esign.model;

import java.util.Date;

import com.esign.model.AgreementAdobe.Responses.AdobeEventsResponse;

public class EventDocument {
    
    private String tipo;
    private String emailUtilizadorAtivo;
    private String nomeUtilizadorAtivo;
    private Date data;
    private String descricao;
    private String emailParticipante;
    private String perfilParticipante;
    private String comentario;

    public EventDocument(AdobeEventsResponse eventsResponse)
    {
        this.setComentario(eventsResponse.getComment());
        this.setData(eventsResponse.getDate());
        this.setTipo(eventsResponse.getType());
        this.setEmailParticipante(eventsResponse.getParticipantEmail());
        this.setNomeUtilizadorAtivo(eventsResponse.getActingUserName());
        this.setDescricao(eventsResponse.getDescription());
        this.setEmailParticipante(eventsResponse.getParticipantEmail());
        this.setPerfilParticipante(eventsResponse.getParticipantRole());
    }

    public EventDocument(){}

    


    /**
     * @return String return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return String return the emailUtilizadorAtivo
     */
    public String getEmailUtilizadorAtivo() {
        return emailUtilizadorAtivo;
    }

    /**
     * @param emailUtilizadorAtivo the emailUtilizadorAtivo to set
     */
    public void setEmailUtilizadorAtivo(String emailUtilizadorAtivo) {
        this.emailUtilizadorAtivo = emailUtilizadorAtivo;
    }

    /**
     * @return String return the nomeUtilizadorAtivo
     */
    public String getNomeUtilizadorAtivo() {
        return nomeUtilizadorAtivo;
    }

    /**
     * @param nomeUtilizadorAtivo the nomeUtilizadorAtivo to set
     */
    public void setNomeUtilizadorAtivo(String nomeUtilizadorAtivo) {
        this.nomeUtilizadorAtivo = nomeUtilizadorAtivo;
    }

    /**
     * @return Date return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return String return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return String return the emailParticipante
     */
    public String getEmailParticipante() {
        return emailParticipante;
    }

    /**
     * @param emailParticipante the emailParticipante to set
     */
    public void setEmailParticipante(String emailParticipante) {
        this.emailParticipante = emailParticipante;
    }

    /**
     * @return String return the perfilParticipante
     */
    public String getPerfilParticipante() {
        return perfilParticipante;
    }

    /**
     * @param perfilParticipante the perfilParticipante to set
     */
    public void setPerfilParticipante(String perfilParticipante) {
        this.perfilParticipante = perfilParticipante;
    }

    /**
     * @return String return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}
