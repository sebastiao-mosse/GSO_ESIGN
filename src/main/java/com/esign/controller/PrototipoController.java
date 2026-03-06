package com.esign.controller;

import com.esign.util.Tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import com.esign.configuration.Configs;
import com.esign.model.DocumentEntity;
import com.esign.model.EventDocument;
import com.esign.model.SignatureRequest;
import com.esign.model.SignatureResponse;
import com.esign.model.TokenInfoEntity;
import com.esign.model.AgreementAdobe.*;
import com.esign.model.AgreementAdobe.Responses.AdobeListEvents;
import com.esign.model.AgreementRequest.*;
import com.esign.repository.DocumentRepository;
import com.esign.repository.TokenInfoRepository;
import com.esign.services.FilesStorageService;
import com.esign.util.AESEncryptionDecryption;
import com.esign.util.SendAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
@Component
@RequestMapping("/api/v1")
public class PrototipoController {

    @Autowired
    private Configs configs;
    @Autowired
    FilesStorageService storageService;
    @Autowired
    TokenInfoRepository tokenInfoRepository;
    @Autowired
    DocumentRepository documentRepository;

    /*
    @RequestMapping(path = "/send", method = RequestMethod.POST)
    public SignatureResponse colectSignature(@RequestBody SignatureRequest nRequest) throws IOException, ParseException 
    {
      
        /*
    System.out.println("Entrei no metodo com sucesso");
    System.out.println("Valor do Request: "+nRequest.getPath());
    System.out.println("Valor do Request: "+nRequest.getProcesso());
    System.out.println("Valor do Request: "+nRequest.getReferencia());
    System.out.println("Valor do Request: "+nRequest.getTitulo());
    System.out.println("Valor do Request: "+nRequest.getControlo());
    System.out.println("Valor do Request: "+nRequest.getAssinantes());
    System.out.println("Valor do Request: "+nRequest.getCc());
        String encryptedURL  = AESEncryptionDecryption.encrypt(nRequest.getPath(), "$05$dvQAXdOgI1cO0lDY6h9I3.iJGreEGL94qizgnGpR7BmfRZkKtSN/m");
        
        nRequest.setPath(encryptedURL);
        TokenInfoEntity configApi = Tools.refreshTokenAccess(tokenInfoRepository);
        boolean downloadCheck = false;
        File file = null;
        if (nRequest.getPath() != null) 
        {
            downloadCheck = Tools.downloadPdf(AESEncryptionDecryption.decrypt(nRequest.getPath(),
            configs.getPassword()),configs.getUserginga(), configs.getPassginga(),configs.getUploads());            
            file = new File(configs.getUploads() + "unsigned/document.pdf");
        } else {System.out.println("No path was founded");}
        AgreementRequest agreementRequest = new AgreementRequest(nRequest.getTitulo(), "ESIGN", "IN_PROCESS");
        agreementRequest.setInformacaoParticipantes(nRequest.getAssinantes());
        agreementRequest.setInformacaoCc(nRequest.getCc());

        if (downloadCheck) {
            SendAgreement sendAgreement = new SendAgreement(configApi.getToken_string(), agreementRequest,new FileSystemResource(file));
            sendAgreement.init();
            String response = sendAgreement.getTransactionId();
            if (sendAgreement.getStatus().is2xxSuccessful()) {
                DocumentEntity documentEntity = new DocumentEntity(nRequest.getReferencia(),
                        response, sendAgreement.getId(),nRequest.getProcesso(), nRequest.getTitulo());
                documentRepository.save(documentEntity);
            }
            SignatureResponse aSignatureResponse = new SignatureResponse(sendAgreement.getId(),
                    sendAgreement.getStatusCode(),sendAgreement.getStatus().getReasonPhrase());
            return aSignatureResponse;
        } else {
            return null;
        }
        */
   // }

 
}
