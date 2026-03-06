package com.esign.services;

import java.io.IOException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.codec.binary.Base64;

public class gingabpmServices 
{

    
    public String UpdateAgreementStatus(String id, String status, String url, String username, String password) throws IOException
    {
        System.out.println("Ja entrei no metodo:");
        String response ="";
        try { 
            String token = this.AuthToken(url.replace("api/v1/update/agreement/status", "login"),username,password);
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", String.format("Bearer %s",token));
            headers.setContentType(MediaType.APPLICATION_JSON);
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<String> entity = new HttpEntity<String>(createJson(id, status),headers);
            response = restTemplate.postForObject(url, entity, String.class);
        } catch (Exception e) {
          System.out.println("Mensagem de erro obtido : " + e.getMessage());
        }
        return response;
    }
        public String createJson(String id, String status) 
        {
            String json = "{" +"'id':'" + id + "','status':'" + status + "'}";
            System.out.println("Resultado: "+ json.replaceAll("'", "\""));
            return json.replaceAll("'", "\"");
        }
        
        
        
        public String AuthToken(String authUrl, String username, String password) throws IOException 
        {
                    URL obj = new URL(authUrl); 
                    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                    AuthHeader(con, username, password, "POST");
                    con.setDoOutput(true);
                    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                    wr.writeBytes(AuthJSON(username, password));
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
        
        public void AuthHeader(HttpURLConnection con, String username, String password, String requestMethod) throws IOException 
        {
            String USER_AGENT = "Mozilla/5.0"; con.setRequestMethod(requestMethod);
            con.setRequestProperty("User-Agent", USER_AGENT);con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("Accept", "application/json");
            String userCredentials = username + ":" + password;
            con.setRequestProperty("Authorization", "Basic " + new String(new Base64().encode(userCredentials.getBytes())));
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            }
        
        public String AuthJSON(String login,String password)
        {
            String json =("{" + "'login':'" + login + "',  " + "'password':'" + password + "'}").replaceAll("'", "\"");
            return json.replaceAll("'", "\"");          
        }
    
}
