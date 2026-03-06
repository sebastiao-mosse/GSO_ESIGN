package com.esign.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.esign.model.SignatureRequest;
import com.esign.model.AgreementAdobe.AdobeAgreement;
import com.esign.model.AgreementAdobe.AdobeUploadFile;
import com.esign.model.AgreementAdobe.FileInfos;
import com.esign.model.AgreementAdobe.Responses.AdobeAgreementCreationResponse;
import com.esign.model.AgreementAdobe.Responses.AdobeListEvents;
import com.esign.model.AgreementAdobe.Responses.AdobeTransientDocumentResponse;
import com.esign.model.AgreementRequest.AgreementRequest;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class SendAgreement {
    private AdobeAgreement requestSignature;
    private AdobeUploadFile document;
    private String base_url = "https://api.eu1.adobesign.com/api/rest/v6";
    private RestTemplate rest;
    private HttpHeaders headers;
    private HttpStatus status;
    private int statusCode;
    private String libraryDocumentId;
    
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String uploadsPath;

    //public SendAgreement(String token, AgreementRequest agreementRequest, FileSystemResource documentFile) {
      public SendAgreement(String token, AgreementRequest agreementRequest) {
        this.setRequestSignature(new AdobeAgreement(agreementRequest));
        //this.setDocument(new AdobeUploadFile(documentFile));
        this.setRest(new RestTemplate());
        this.headers = new HttpHeaders();
        headers.add("Accept", "*/*");
        headers.add("Authorization", token);

    }

    public SendAgreement(String token) {
        this.setRest(new RestTemplate());
        this.headers = new HttpHeaders();
        headers.add("Accept", "*/*");
        headers.add("Authorization", token);
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

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public RestTemplate getRest() {
        return rest;
    }

    public void setRest(RestTemplate rest) {
        this.rest = rest;
    }

    public String getBase_url() {
        return base_url;
    }

    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }

    public AdobeUploadFile getDocument() {
        return document;
    }

    public void setDocument(AdobeUploadFile document) {
        this.document = document;
    }

    public AdobeAgreement getRequestSignature() {
        return requestSignature;
    }

    public void setRequestSignature(AdobeAgreement requestSignature) {
        this.requestSignature = requestSignature;
    }

    public AdobeAgreementCreationResponse init(String libraryDocumentId) throws IOException 
    {
        // Send the document do Colect de Signatures
        try {
            FileInfos filesInfo = new FileInfos(libraryDocumentId);
            this.getRequestSignature().getFileInfos().add(filesInfo);

            HttpEntity<AdobeAgreement> rEntity = new HttpEntity<>(this.getRequestSignature(), this.headers);
            ResponseEntity<AdobeAgreementCreationResponse> responseEntity = 
                    this.getRest().postForEntity(this.getBase_url() + "/agreements", rEntity, AdobeAgreementCreationResponse.class);
            this.setStatus(responseEntity.getStatusCode());
            this.setCodeValue(responseEntity.getStatusCodeValue());
            this.setId(responseEntity.getBody().getLibraryDocumentId());
            return responseEntity.getBody();

        } catch (HttpClientErrorException e) {
            System.out.println("Error Sign: " + e.getResponseBodyAsString());

        }
        return null;
    }

    public void downloadDocument(String idDocument) {
        try {

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(
                    new ByteArrayHttpMessageConverter());

            // headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));

            HttpEntity<String> entity = new HttpEntity<String>(this.headers);

            ResponseEntity<byte[]> response = restTemplate.exchange(
                    this.getBase_url() + "/agreements/" + idDocument + "/combinedDocument",
                    HttpMethod.GET, entity, byte[].class);

            if (response.getStatusCode() == HttpStatus.OK) {
                System.out.println("am here " + this.uploadsPath);
                Files.write(Paths.get(this.uploadsPath + "signed/" + idDocument + ".pdf"), response.getBody());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AdobeListEvents getDocumentEvents(String document) {
        HttpEntity<String> entity = new HttpEntity<String>(this.headers);
        ResponseEntity<AdobeListEvents> response = this.getRest().exchange(
                this.getBase_url() + "/agreements/" + document + "/events", HttpMethod.GET, entity,
                AdobeListEvents.class);
        this.setStatus(response.getStatusCode());
        this.setCodeValue(response.getStatusCodeValue());
        return response.getBody();
    }

    public void setCodeValue(int statusCodeValue) {
        this.statusCode = statusCodeValue;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    /**
     * @return HttpHeaders return the headers
     */
    public HttpHeaders getHeaders() {
        return headers;
    }

    /**
     * @param headers the headers to set
     */
    public void setHeaders(HttpHeaders headers) {
        this.headers = headers;
    }

    /**
     * @param statusCode the statusCode to set
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * @param uploadsPath the uploadsPath to set
     */
    public void setUploadsPath(String uploadsPath) {
        this.uploadsPath = uploadsPath;
    }

}
