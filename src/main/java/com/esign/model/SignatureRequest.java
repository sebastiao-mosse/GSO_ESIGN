package com.esign.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.esign.model.AgreementRequest.InformacaoCampos;
import com.esign.model.AgreementRequest.InformacaoCc;
import com.esign.model.AgreementRequest.InformacaoParticipantes;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SignatureRequest {
    @JsonProperty("referencia")
    private String referencia;

    @JsonProperty("controlo")
    private Integer controlo;
    private String path;
    
    @JsonProperty("libraryDocumentId")
    private String libraryDocumentId;

    @JsonProperty("titulo")
    private String titulo;
    

    @JsonProperty("processo")
    private String processo;

    @JsonProperty("assinantes")
    private ArrayList<InformacaoParticipantes> assinantes;
    
    @JsonProperty("campos")
    private ArrayList<InformacaoCampos> campos;

    @JsonProperty("cc")
    private ArrayList<InformacaoCc> cc;

    public SignatureRequest(@JsonProperty("titulo") String titulo,
            @JsonProperty("referencia") String referencia,
            @JsonProperty("processo") String processo, @JsonProperty("path") String path,
            @JsonProperty("assinantes") ArrayList<InformacaoParticipantes> assinantes,
            @JsonProperty("campos") ArrayList<InformacaoCampos> campos,
            @JsonProperty("cc") ArrayList<InformacaoCc> cc) {
        this.setAssinantes(assinantes);
        this.setCampos(campos);
        this.setCc(cc);
        this.setPath(path);
        this.setProcesso(processo);
        this.setReferencia(referencia);
        this.setTitulo(titulo);
    }

    public SignatureRequest() {
        this.setAssinantes(new ArrayList<InformacaoParticipantes>());
        this.getAssinantes().add(new InformacaoParticipantes());     
        this.setCampos(new ArrayList<InformacaoCampos>());
        this.getCampos().add(new InformacaoCampos()); 
        this.setCc(new ArrayList<InformacaoCc>());
        this.getCc().add(new InformacaoCc());
    }

    /**
     * @return String return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    @JsonProperty("referencia")
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return Integer return the controlo
     */
    public Integer getControlo() {
        return controlo;
    }

    /**
     * @param controlo the controlo to set
     */
    @JsonProperty("controlo")
    public void setControlo(Integer controlo) {
        this.controlo = controlo;
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
    @JsonProperty("libraryDocumentId")
    public void setLibraryDocumentId(String libraryDocumentId) {
        this.libraryDocumentId = libraryDocumentId;
    }

    /**
     * @return String return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    @JsonProperty("titulo")
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return String return the processo
     */
    public String getProcesso() {
        return processo;
    }

    /**
     * @param processo the processo to set
     */
    @JsonProperty("processo")
    public void setProcesso(String processo) {
        this.processo = processo;
    }

    

    public String toString() {
        return this.getProcesso() + " - " + this.getReferencia() + " - " + this.getTitulo() + " - "
                + this.getPath();

    }

    /**
     * @return ArrayList<InformacaoParticipantes> return the assinantes
     */
    public ArrayList<InformacaoParticipantes> getAssinantes() {
        return assinantes;
    }

    /**
     * @param assinantes the assinantes to set
     */
    @JsonProperty("assinantes")
    public void setAssinantes(ArrayList<InformacaoParticipantes> assinantes) {
        this.assinantes = assinantes;
    }
  
    /**
     * @return ArrayList<InformacaoCampos> return the informacaoCampos
     */
    public ArrayList<InformacaoCampos> getCampos() {
        return campos;
    }

    /**
     * @param informacaoCampos the informacaoCampos to set
     */
    @JsonProperty("campos")
    public void setCampos(ArrayList<InformacaoCampos> campos) {
        this.campos = campos;
    }

    /**
     * @return ArrayList<InformacaoCc> return the cc
     */
    public ArrayList<InformacaoCc> getCc() {
        return cc;
    }

    /**
     * @param cc the cc to set
     */
    @JsonProperty("cc")
    public void setCc(ArrayList<InformacaoCc> cc) {
        this.cc = cc;
    }

    /**
     * @return String return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

}
