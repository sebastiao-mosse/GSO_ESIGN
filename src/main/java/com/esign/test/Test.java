package com.esign.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Test {
    
     private static final String GET_INVITATION = "https://services.gingasoft.com/spp/api/v1/produtoCharges?produto=3";

        static RestTemplate restTemplate = new RestTemplate();
  

      
 
        
        
        public static void callListOrganizationAPI(String authUrl) throws IOException
        {

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.set("Authorization", String.format("Bearer %s", AuthToken(authUrl, "user_api", "uS#2023.api")));
            HttpEntity<String> request = new HttpEntity<String>(headers);
            ResponseEntity<String> result =  restTemplate.exchange(GET_INVITATION, HttpMethod.GET,request,String.class);
           
            String json = result.getBody().toString();
            com.google.gson.JsonObject data = new JsonParser().parse(json).getAsJsonObject();
            System.out.println("Resultado: "+data.get("parcelas").toString());   
            
            
        }
        
        

        /* ESTE MÉTODO ESTÁ A FUNCIONAR LINDAMENTE PARA AS MINHAS APIS*/
        public static void ClientTest1(String authUrl, String name, String tipoCooperado, String host, String username, String password) throws IOException
        {   
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.set("Authorization", String.format("Bearer %s", AuthToken(authUrl, "hossana.mosse", "@analista")));
            headers.set(HttpHeaders.ACCEPT,MediaType.APPLICATION_JSON_VALUE);
            HttpEntity<?> request = new HttpEntity<>(headers);
            String urlTemplate = UriComponentsBuilder
                                .fromHttpUrl(GET_INVITATION)
                                    .queryParam("name", "{name}")
                                        .queryParam("tipoCooperado", "{tipoCooperado}")
                                            .queryParam("host", "{host}")
                                            .queryParam("username", "{username}")
                                            .queryParam("password", "{password}")
                                           .encode()
                                           .toUriString();

            Map<String, String> params = new HashMap<>();
            params.put("name", name);
            params.put("tipoCooperado", tipoCooperado);
            params.put("host", "http://localhost:8080");
            params.put("username", "okmAdmin");
            params.put("password", "admin");
         
            HttpEntity<String> response = restTemplate.exchange(urlTemplate,HttpMethod.POST,request,String.class,params);
            String json = response.getBody();
           // return json;   
            
            System.out.println("Resultado: "+ json);
            
            
        }
        
        
        
        public static void ClientTest2(String authUrl, String name, String tipoCooperado, String host, String username, String password) throws IOException
        {   
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.set("Authorization", String.format("Bearer %s", AuthToken(authUrl, "hossana.mosse", "@analista")));
            headers.set(HttpHeaders.ACCEPT,MediaType.APPLICATION_JSON_VALUE);
            HttpEntity<?> request = new HttpEntity<>(headers);
            String urlTemplate = UriComponentsBuilder
                                .fromHttpUrl(GET_INVITATION)
                                    .queryParam("name", "{name}")
                                        .queryParam("tipoCooperado", "{tipoCooperado}")
                                            .queryParam("host", "{host}")
                                            .queryParam("username", "{username}")
                                            .queryParam("password", "{password}")
                                           .encode()
                                           .toUriString();

            Map<String, String> params = new HashMap<>();
            params.put("name", name);
            params.put("tipoCooperado", tipoCooperado);
            params.put("host", "http://localhost:8080");
            params.put("username", "okmAdmin");
            params.put("password", "admin");
         
            HttpEntity<String> response = restTemplate.exchange(urlTemplate,HttpMethod.POST,request,String.class,params);
            String json = response.getBody();
           // return json;   
            
            System.out.println("Resultado: "+ json);
            
            
        }
       
        
        
        public static void ClientWithJSON(String name, String tipoCooperado, String host, String username, String password) throws IOException
        {
            try { 
                
                HttpHeaders headers = new HttpHeaders();
                headers.set("Authorization", String.format("Bearer %s", AuthToken("http://localhost:8082/login", "hossana.mosse", "@analista")));
                headers.setContentType(MediaType.APPLICATION_JSON);
                RestTemplate restTemplate = new RestTemplate();
                String url =  "http://localhost:8082/api/v1/criarPasta";
                HttpEntity<String> entity = new HttpEntity<String>(createJson(name, tipoCooperado, host, username, password) ,headers);
                String answer = restTemplate.postForObject(url, entity, String.class);
                System.out.println(answer); 
            } catch (Exception e) {
              System.out.println("Erro capturado: " + e.getMessage());
            }
                          
        } 
        
        
        public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
            
            /*
            String titulo="Carta Bancaria"; String descricaoCarta="Desembolso de Crédito Adiantamento de Salário";
            String ibanCliente="46456456"; String contaBancaria="82674142";
            String referencia="24072023000343"; String formaPagamento="Transferência Bancária"; 
            String nomeBeneficiario="Sebastiao Vunda Mosse"; String dataCarta="14/05/2022"; String nomeBanco="Abnco BAI";
            String processo="PROC-2697"; String dataActual="24/07/2023"; String numeroConta="34789AGAJSHSJAH"; 
            String valorTotal="1.000,00(ºMill Kuanzas)"; 
            String codigoDocumento="JKLKJHGFDSDFGHJ#$/()="; 
            String path="CBJCHBCAABAAV1DvNHFMfQzh7m7Twlcew5-OxVTFo4Up";
            String contaCooperativa="";
            
            AssinaturaDigital(titulo, referencia, processo, path, descricaoCarta, formaPagamento, contaCooperativa,
                    ibanCliente, contaBancaria, nomeBeneficiario, dataCarta, nomeBanco, dataActual, numeroConta,
                    valorTotal, codigoDocumento);
                    
                    */
            
                File file = new File("C:\\PROJECTO ASSINATURA DIGITAL\\DESENVOLVIMENTO\\esign\\src\\main\\resources\\com\\esign\\util\\signed\\CBJCHBCAABAAI_LlMgX0yEHU3aOM1-tLPIQLwxlb6J6D.pdf");
         
                boolean result = file.delete();
                if (result) {
                    System.out.println("File is successfully deleted.");
                }
                else {
                    System.out.println("File deletion failed.");
                }
            }

        
        
        
        
        
        
        public static String AssinaturaDigital(String titulo, String referencia, String processo, String path, 
                String descricaoCarta,String formaPagamento, String contaCooperativa, String ibanCliente, 
                String contaBancaria, String nomeBeneficiario, String dataCarta,  String nomeBanco, String dataActual, 
                String numeroConta, String valorTotal, String codigoDocumento) throws IOException, ClassNotFoundException, SQLException {
        
            String url = "http://localhost:9090/api/v1/coletar-assinaturas";
            String response ="";
            String adobeTemplateId = "CBJCHBCAABAAV1DvNHFMfQzh7m7Twlcew5-OxVTFo4Up";
            try { 
                
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                headers.set("Authorization", String.format("Bearer %s", AuthToken("http://localhost:9090/login", "hossana.mosse", "@analista")));
                headers.set(HttpHeaders.ACCEPT,MediaType.APPLICATION_JSON_VALUE);
           
                RestTemplate restTemplate = new RestTemplate();        
               
                 HttpEntity<String> entity = new HttpEntity<String>(CreateJson(titulo, referencia, processo, adobeTemplateId,
                "sebastiao.mosse@grupoprodusol.com","analistamosse@gmail.com",descricaoCarta, formaPagamento, contaCooperativa,
                ibanCliente,contaBancaria, nomeBeneficiario,dataCarta, nomeBanco,dataActual, numeroConta, valorTotal, codigoDocumento) ,headers);   
                
                response = restTemplate.postForObject(url, entity, String.class);   
            }catch (Exception e) {
                System.out.println("Mensagem de erro: "+ e.getMessage());
            }
            return response;
        }


        public static String CreateJson(String titulo, String referencia, String processo, String libraryDocumentId, String email1, String email2,
                 String descricaoCarta, String formaPagamento,String contaCooperativa,String ibanCliente,
                 String contaBancaria,String nomeBeneficiario,String dataCarta, String nomeBanco, String dataActual,
                 String numeroConta, String valorTotal,String codigoDocumento) {
            
            
            String json = "{" +
                        "'titulo':'" + titulo + "','referencia':'" + referencia+  "','processo':'"+ processo+ "','libraryDocumentId':'"+ libraryDocumentId 
                        + "','assinantes':[{'ordem': 1,'perfil': 'SIGNER',"
                      + "'informacaoMembro': [{'email':'" + email1+ "'}]},{'ordem': 2,'perfil': 'SIGNER','informacaoMembro': [{'email':'" +email2+ "'}]}],"                     
                      + "'campos':["
                                    + "{'defaultValue':'"+ descricaoCarta +"','fieldName': 'descricaoCarta'},"
                                    + "{'defaultValue':'"+ formaPagamento +"','fieldName': 'formaPagamento'},"
                                    + "{'defaultValue':'"+ contaCooperativa +"','fieldName': 'contaCooperativa'},"
                                    + "{'defaultValue':'"+ ibanCliente +"','fieldName': 'numeroIban'},"
                                    + "{'defaultValue':'"+ contaBancaria +"','fieldName': 'numeroConta'},"
                                    + "{'defaultValue':'"+ nomeBeneficiario +"','fieldName': 'nomeBeneficiario'},"
                                    + "{'defaultValue':'"+ dataCarta +"','fieldName': 'dataCartaBancaria'},"
                                    + "{'defaultValue':'"+ nomeBanco +"','fieldName': 'nomeBanco'},"
                                    + "{'defaultValue':'"+ dataActual +"','fieldName': 'dataActual'},"
                                    + "{'defaultValue':'"+ numeroConta +"','fieldName': 'numeroConta'},"
                                    //+ "{'defaultValue':'"+ valorTotal +"("+valorPorExtenso(Double.parseDouble(valorTotal.replace(".", "").replace(",", "."))) +")"   +"','fieldName': 'valorTotal'},"
                                    + "{'defaultValue':'"+ codigoDocumento +"','fieldName': 'codigoDocumento'}"
                            + "]}";
            
            System.out.println("Valor do Json formatado: "+json.replaceAll("'", "\""));
            return json.replaceAll("'", "\"");
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        public static String createJson(String name, String tipoCooperado, String host, String username, String password) 
        {
            String json = "{" +
                    "'name':'" + name + "','tipoCooperado':'" + tipoCooperado+  "','host':'"+ host+ "','username':'"+ username + "','password':'" + password + "'}";
            System.out.println("Resultado: "+ json);
            System.out.println("Resultado: "+ json.replaceAll("'", "\""));
            return json.replaceAll("'", "\"");
        }
        
        
        
        public static void ClientWithJSONFormat() throws IOException
        {
            try {
                
                HttpHeaders headers = new HttpHeaders();
                headers.set("Authorization", String.format("Bearer %s", AuthToken("http://localhost:9090/login", "hossana.mosse", "@analista")));
                headers.setContentType(MediaType.APPLICATION_JSON);
                RestTemplate restTemplate = new RestTemplate();
                String url =  "http://localhost:9090/documentos/coletar-assinaturas";
                HttpEntity<String> entity = new HttpEntity<String>(GetJson() ,headers);
                String answer = restTemplate.postForObject(url, entity, String.class);
                System.out.println(answer); 
            } catch (Exception e) {
              System.out.println("Erro capturado: " + e.getMessage());
            }
                          
        }        
        
        
        public static String GetJson() 
        {
            String json ="{\r\n" + 
                    "            \"titulo\": \"TESTE EM JAVA\",\r\n" + 
                    "            \"referencia\" : \"PROC-000555\",\r\n" + 
                    "            \"processo\": \"PROC-000555\",\r\n" + 
                    "            \"path\": \"nocytQlaWmnmDKHX7wqi11qLMLM7+X3rZsW71Q8cLepZg4u4zNKTcwYoWMrSk9OJgHZCJZiepqDfD9aYsZNNRA==\",\r\n" + 
                    "            \"assinantes\": [\r\n" + 
                    "                {\r\n" + 
                    "                    \"ordem\": 1,\r\n" + 
                    "                    \"perfil\": \"SIGNER\",\r\n" + 
                    "                    \"informacaoMembro\": [\r\n" + 
                    "                        {\r\n" + 
                    "                            \"email\": \"sebastiao_vunda@hotmail.com\"\r\n" + 
                    "                        }\r\n" + 
                    "                    ]\r\n" + 
                    "                },\r\n" + 
                    "                {\r\n" + 
                    "                    \"ordem\": 2,\r\n" + 
                    "                    \"perfil\": \"SIGNER\",\r\n" + 
                    "                    \"informacaoMembro\": [\r\n" + 
                    "                        {\r\n" + 
                    "                            \"email\": \"analistamosse@gmail.com\"\r\n" + 
                    "                        }\r\n" + 
                    "                    ]\r\n" + 
                    "                }\r\n" + 
                    "            ],\r\n" + 
                    "            \"cc\": [\r\n" + 
                    "                {\r\n" + 
                    "                    \"email\": \"analistamosse@gmail.com\"\r\n" + 
                    "                }\r\n" + 
                    "            ]\r\n" + 
                    "        }\r\n" + 
                    "        ";
            
            return json;
        }
        
    
        
        
        public static String AuthToken(String authUrl, String username, String password) throws IOException 
        {
                    URL obj = new URL(authUrl); 
                    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                    Auth(con, username, password);
                    con.setDoOutput(true);
                    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                    wr.writeBytes(CreateJson(username, password));
                    wr.flush();wr.close();
                    int responseCode = con.getResponseCode();
                    StringBuffer response = new StringBuffer();
                    if (responseCode != 200) {
                        return con.getResponseMessage();
                    } else {
                        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                        String output;
                    
                        while ((output = in.readLine()) != null) {
                            response.append(output);
                        }
                        in.close();
                        
                    }
                    return response.toString();
                    
        }
        
        public static void Auth(HttpURLConnection con, String username, String password) throws IOException 
        {
            String USER_AGENT = "Mozilla/5.0"; con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("Accept", "application/json");
            String userCredentials = username + ":" + password;
            con.setRequestProperty("Authorization", "Basic " + new String(new Base64().encode(userCredentials.getBytes())));
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            }
        
        public static String CreateJson(String login,String password)
        {
            String json =("{" + "'login':'" + login + "',  " + "'password':'" + password + "'}").replaceAll("'", "\"");
            return json.replaceAll("'", "\"");
            
        }
        
        
        public static void validate(String token) {
            
            DecodedJWT jwt = JWT.decode(token);
            System.out.println("Tempo de expiracao do token"+ jwt.getExpiresAt());
            System.out.println("Token bem activo"+ Calendar.getInstance().getTime());
      
            // Check expiration
            if (jwt.getExpiresAt().before(Calendar.getInstance().getTime())) {
           System.out.println("Token Expirado! solicite um novo token");
            }
            else {
                
                System.out.println("Token bem activo");
            }
        }
        


}
