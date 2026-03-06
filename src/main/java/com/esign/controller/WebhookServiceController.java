package com.esign.controller;

import com.esign.configuration.Configs;
import com.esign.model.AdobeSignClient;
import com.esign.model.DocumentEntity;
import com.esign.model.TokenInfoEntity;
import com.esign.model.AgreementAdobe.Webhook.AdobeWebhookResponse;
import com.esign.repository.*;
import com.esign.services.FilesStorageService;
import com.esign.services.gingabpmServices;
import com.esign.util.Tools;
import java.io.IOException;
import java.text.ParseException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.*;
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
public class WebhookServiceController {
    @Autowired
    private Configs configs;
    @Autowired
    FilesStorageService storageService;
    @Autowired
    TokenInfoRepository tokenInfoRepository;
    @Autowired
    DocumentRepository documentRepository;
    
    gingabpmServices gingabpm = new gingabpmServices();

    @GetMapping(path = "/receiver",  produces = { MediaType.APPLICATION_JSON_VALUE })
    public AdobeSignClient index( HttpServletResponse response) throws ParseException {
        TokenInfoEntity configApi = Tools.refreshTokenAccess(tokenInfoRepository);
        AdobeSignClient iAdobeSignClient = new AdobeSignClient(configApi.getAdobe_client_id().toString());
        if(configApi.getAdobe_client_id().equals(iAdobeSignClient.getXAdobeSignClientId()))
        {
            response.addHeader("X-AdobeSign-ClientId", configApi.getAdobe_client_id());
            response.setStatus(200);
        }
        return iAdobeSignClient;  
   }
       
    @RequestMapping(path = "receiver", method = RequestMethod.POST, consumes = {
            MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> receiveAgreementWebhook(HttpServletResponse responseClient, @Valid @RequestBody AdobeWebhookResponse agreementWebhook)throws ParseException, IOException
    {
        @SuppressWarnings("unused")
        ResponseEntity<String> response = null;
     
        TokenInfoEntity configApi = Tools.refreshTokenAccess(tokenInfoRepository);
        AdobeSignClient iAdobeSignClient = new AdobeSignClient(configApi.getAdobe_client_id().toString());
        HttpClient client = HttpClients.custom().build();
        HttpUriRequest request = RequestBuilder.get().setUri(configs.getUrl()).setHeader("X-AdobeSign-ClientId", configApi.getAdobe_client_id()).build();
        client.execute(request);      
        responseClient.addHeader("X-AdobeSign-ClientId", configApi.getAdobe_client_id());
        responseClient.setStatus(200);
        if (configApi.getAdobe_client_id().equals(iAdobeSignClient.getXAdobeSignClientId()))
        { 
            switch (agreementWebhook.getEvent())
            {   
                case "AGREEMENT_WORKFLOW_COMPLETED":// Agreement Signed Successfuly
                    System.out.println("AGREEMENT ID : " +  agreementWebhook.getAgreement().getId());        
                    gingabpm.UpdateAgreementStatus(agreementWebhook.getAgreement().getId(), "Assinado",  configs.getServer(), 
                            configs.getBpmusername(), configs.getBpmpassword());    
                    break;
                case "AGREEMENT_REJECTED":
                     gingabpm.UpdateAgreementStatus(agreementWebhook.getAgreement().getId(), "Rejeitado",  configs.getServer(),
                             configs.getBpmusername(), configs.getBpmpassword());
                    break;
                case "CANCELLED":
                    gingabpm.UpdateAgreementStatus(agreementWebhook.getAgreement().getId(),"Cancelado",  configs.getServer(),
                            configs.getBpmusername(), configs.getBpmpassword());
                   
                   break;
                default:
                    break;
            } 
            return new ResponseEntity<String>("{\"X-AdobeSign-ClientId\", \"UB7E5BXCXY\"}", HttpStatus.OK);
        } 
        else {
             // responseClient.sendError(404, "Conexão não validada");
              //return new ResponseEntity<String>("Erro do Servidor", HttpStatus.INTERNAL_SERVER_ERROR); 
            return new ResponseEntity<String>("{\"X-AdobeSign-ClientId\", \"UB7E5BXCXY\"}", HttpStatus.OK);
        }
        }
}