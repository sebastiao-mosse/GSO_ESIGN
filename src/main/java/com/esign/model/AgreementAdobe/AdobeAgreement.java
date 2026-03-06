package com.esign.model.AgreementAdobe;

import java.util.ArrayList;

import com.esign.model.AgreementRequest.AgreementRequest;
import com.esign.model.AgreementRequest.InformacaoCampos;
import com.esign.model.AgreementRequest.InformacaoCc;
import com.esign.model.AgreementRequest.InformacaoFicheiro;
import com.esign.model.AgreementRequest.InformacaoParticipantes;

public class AdobeAgreement {
    private ArrayList<FileInfos> fileInfos;
    private String name;
    private ArrayList<ParticipantSetsInfo> participantSetsInfo;
    private ArrayList<MergeFieldInfo> mergeFieldInfo;
    private ArrayList<CcInfo> ccInfo;
    private String signatureType;
    private String state;

    public AdobeAgreement(AgreementRequest agreementRequest) {
        this.setName(agreementRequest.getTitulo());
        this.setState(agreementRequest.getEstado());
        this.setSignatureType(agreementRequest.getTipoAssinatura());

        //Add Files Informations
        this.setFileInfos(new ArrayList<FileInfos>());
        for (InformacaoFicheiro informacaoFicheiro : agreementRequest.getInformacaoFicheiro()) {
            FileInfos fileInfos = new FileInfos(informacaoFicheiro.getLibraryDocumentId());
            this.getFileInfos().add(fileInfos);//Save Files informations
        }

        //Add Participant Informations
        this.setParticipantSetsInfo(new ArrayList<ParticipantSetsInfo>());
        for (InformacaoParticipantes informacaoParticipantes : agreementRequest.getInformacaoParticipantes()) {
            ParticipantSetsInfo participantSetsInfo = new ParticipantSetsInfo();
            participantSetsInfo.setOrder(informacaoParticipantes.getOrdem());
            participantSetsInfo.setRole(informacaoParticipantes.getPerfil());

            //Add Member Informartions (email)
            participantSetsInfo.setMemberInfos(new ArrayList<CcInfo>());
            for (InformacaoCc membro : informacaoParticipantes.getInformacaoMembro()) {
                CcInfo memberInfos = new CcInfo();
                memberInfos.setEmail(membro.getEmail());
                
                participantSetsInfo.getMemberInfos().add(memberInfos);//Save in List of members
            }
            this.getParticipantSetsInfo().add(participantSetsInfo);//Save Participants Infos
        }
        
        //ADICIONANDO O mergefieldsInfo na requisicao
        this.setMergeFieldInfo(new ArrayList<MergeFieldInfo>());
        for (InformacaoCampos informacaoCampos : agreementRequest.getInformacaoCampos()) {
            MergeFieldInfo mergeFieldInfo = new MergeFieldInfo();
            mergeFieldInfo.setFieldName(informacaoCampos.getFieldName());
            mergeFieldInfo.setDefaultValue(informacaoCampos.getDefaultValue());
            this.getMergeFieldInfo().add(mergeFieldInfo); //Save Fields and values info Infos
        }
    }
     

    public String getState() {
        return state;
    }

    public ArrayList<FileInfos> getFileInfos() {
        return fileInfos;
    }

    public void setFileInfos(ArrayList<FileInfos> fileInfos) {
        this.fileInfos = fileInfos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ParticipantSetsInfo> getParticipantSetsInfo() {
        return participantSetsInfo;
    }

    public void setParticipantSetsInfo(ArrayList<ParticipantSetsInfo> participantSetsInfo) {
        this.participantSetsInfo = participantSetsInfo;
    }

    public ArrayList<MergeFieldInfo> getMergeFieldInfo() {
        return mergeFieldInfo;
    }
    public void setMergeFieldInfo(ArrayList<MergeFieldInfo> mergeFieldInfo) {
        this.mergeFieldInfo = mergeFieldInfo;
    }


    public ArrayList<CcInfo> getCcInfo() {
        return ccInfo;
    }

    public void setCcInfo(ArrayList<CcInfo> ccInfo) {
        this.ccInfo = ccInfo;
    }

    public String getSignatureType() {
        return signatureType;
    }

    public void setSignatureType(String signatureType) {
        this.signatureType = signatureType;
    }

    public void setState(String state) {
        this.state = state;
    }

}
