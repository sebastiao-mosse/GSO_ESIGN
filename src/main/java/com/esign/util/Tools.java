package com.esign.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import org.hibernate.boot.model.convert.spi.ConverterDescriptor;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;
import com.esign.model.TokenInfoEntity;
import com.esign.model.AgreementAdobe.AdobeRefreshToken;
import com.esign.model.AgreementAdobe.ResponseRefreshToken;
import com.esign.repository.TokenInfoRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.lowagie.text.pdf.codec.Base64;

public class Tools {

    private static SimpleDateFormat simpleDateFormate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public static boolean downloaFile(String url, String folderPath, String username, String pass) {

        try {

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Accept", "*/*");
            headers.add("Content-Type", "application/json");
            headers.add("Accept-Charset", "UTF-8");
            String userCredentials = username.trim() + ":" + pass.trim();
            String basicAuth = "Basic " + new String(Base64Coder.encode(userCredentials.getBytes()));
            headers.add("Authorization", basicAuth);
            restTemplate.getMessageConverters().add(
                    new ByteArrayHttpMessageConverter());

            // headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));

            HttpEntity<String> entity = new HttpEntity<String>(headers);

            ResponseEntity<byte[]> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET, entity, byte[].class);

            if (response.getStatusCode() == HttpStatus.OK) {
                Files.write(Paths.get(folderPath + "unsigned/document.pdf"), response.getBody());
                return response.getStatusCode().is2xxSuccessful();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean downloaFile(String url, String folderPath) {
        return downloaFile(url, folderPath, null, null);
    }

    public static boolean downloadPdf(String url, String username, String password, String folderPath) {
        InputStream in = null;
        FileOutputStream out = null;
        String fileName = folderPath + "unsigned/document.pdf";

        try {
            in = getConnection(url, username, password).getInputStream();
            out = new FileOutputStream(fileName);
            int c;
            byte[] b = new byte[1024];
            while ((c = in.read(b)) != -1) {
                out.write(b, 0, c);

            }
            out.close();

        } catch (Exception e) {
            System.out.println("Download file " + e.getMessage());
            return false;
        }

        return true;

    }
    
    

    
    

    private static HttpURLConnection getConnection(String url, String username, String password) throws IOException {

        URL myUrl = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) myUrl.openConnection();
        try {
            conn.setDoOutput(true);
            conn.setReadTimeout(30000);
            conn.setConnectTimeout(30000);
            conn.setUseCaches(false);
            conn.setAllowUserInteraction(false);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setRequestMethod("GET");
            String userCredentials = username.trim() + ":" + password.trim();
            
            System.out.println("Username: "+username);
            System.out.println("Password: "+ password);
            
            String basicAuth = "Basic " + new String(Base64.encodeBytes(userCredentials.getBytes()));
            conn.setRequestProperty("Authorization", basicAuth);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Something gone whrong. fix it.");
        }

        return conn;
    }

    public static File convert(MultipartFile file) {
        File convFile = new File(file.getOriginalFilename());
        try {
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return convFile;
    }

    public static TokenInfoEntity refreshTokenAccess(TokenInfoRepository tokenInfoRepository) throws ParseException {
        Optional<TokenInfoEntity> configs = tokenInfoRepository.findById((long) 1);
        TokenInfoEntity configApi = new TokenInfoEntity();
        configApi = configs.get();
        int result = simpleDateFormate.parse(ConverterData(configApi.getExpireted_at().toString())).compareTo(simpleDateFormate.parse(getCurrentDate()));
        if(result <= 0) {
            AdobeRefreshToken refreshToken = new AdobeRefreshToken(configApi.getRefresh_token(),
                    configApi.getClient_id(), configApi.getClient_secret());
            ResponseRefreshToken responseRefreshToken = refreshToken.refreshOldToken();// Refresh the Current Token
            Calendar calendar = Calendar.getInstance();
            Date today = calendar.getTime();
            calendar.setTimeInMillis(responseRefreshToken.getExpires_in());
            Calendar timeout = Calendar.getInstance();
            timeout.setTimeInMillis(today.getTime() + responseRefreshToken.getExpires_in() * 1000);
            configApi.setExpireted_at(timeout.getTime());
            configApi.setUpdated_at(today);   
            configApi.setToken_string(
                    responseRefreshToken.getToken_type() + " " + responseRefreshToken.getAccess_token());
            tokenInfoRepository.save(configApi);
        }
        return configApi;
    }
    
    

    public static String ConverterData(String dataEntrada) throws ParseException {
        SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S", Locale.ENGLISH);
        SimpleDateFormat formatoSaida = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        Date date = formatoEntrada.parse(dataEntrada);
        String dataSaida = formatoSaida.format(date);
        return dataSaida;
    }
    
    public static String getCurrentDate() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dataFormatada = dtf.format(now);
        return dataFormatada;
    }
}
