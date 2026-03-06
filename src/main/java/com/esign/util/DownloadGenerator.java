package com.esign.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.lowagie.text.pdf.codec.Base64;

public class DownloadGenerator {
    public static void main(String[] args) {

        DownloadGenerator.downloadPdf(
                "http://92.204.138.167:8383/webdav//okm_root/COOPERADOS/SINGULAR/AFONSOMALAVOJOAO_012080001AB002/Credito_01_03_2022_11_17_05/FolhaRosto_AFONSO%20MALAVO%20JOAO_010320221126.pdf",
                "okmAdmin", "admin", "D:\\Desktop\\esign\\adobe-main-project\\esign\\esign\\uploads\\unsigned");

    }

    private static void downloadPdf(String url, String username, String password, String fileName) {
        InputStream in = null;
        FileOutputStream out = null;

        try {
            in = getConnection(url, username, password).getInputStream();
            out = new FileOutputStream(fileName);
            int c;
            byte[] b = new byte[1024];
            while ((c = in.read(b)) != -1) {
                out.write(b, 0, c);

            }

        } catch (Exception e) {
            System.out.println(" " + e.getMessage());
        }

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
            String basicAuth = "Basic " + new String(Base64.encodeBytes(userCredentials.getBytes()));
            conn.setRequestProperty("Authorization", basicAuth);
        } catch (Exception e) {
            // TODO: handle exception
        }

        return conn;
    }
}
