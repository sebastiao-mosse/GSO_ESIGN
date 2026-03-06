package com.esign.util;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
public class AESEncryptionDecryption 
{
    private static SecretKeySpec secretKey;
    private static byte[] key;
    private static final String ALGORITHM = "AES";

    public static void prepareSecreteKey(String myKey) {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String strToEncrypt, String secret) {
        try {
            prepareSecreteKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static String decrypt(String strToDecrypt, String secret) {
        try {
            prepareSecreteKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
    
    
    
    public static void main(String[]args) throws ParseException 
    {  
      System.out.println("ENCRIPTAR: "+encrypt("3AAABLblqZhCthSNxjC2OeCKMDGPvCrnOL_6WUeNYvmFlXI1pRL-IXIfOj3h29kMM16JH3MpBHVU*","$2a$05$dvQAXdOgI1cO0lDY6h9I3.iJGreEGL94qizgnGpR7BmfRZkKtSN/m"));  
      
     //System.out.println("DECRIPTAR : "+decrypt("qZRtWC7+nNdAh7Dm86tUE/VN6jAoSsqWyHUvsEQUC/MbNB2YKQ33mg6N/sv/pq4RyQLu0eEjtL7jxA1ic8epwTHWKKlLhcGAIazesruAgREcP9srUrai6XIzYvL+nX4A+Gax+4X6iek4K9rBjtRA/Q==","$2a$05$dvQAXdOgI1cO0lDY6h9I3.iJGreEGL94qizgnGpR7BmfRZkKtSN/m")); 
   
    // System.out.println("DECRIPTAR : "+decrypt("E52tyZIqIrOCQ9uPLhdvpi9XTlhvnBVFHEHDAaCKuqF4aZwRCQrBQnziPilgWRu9Bm1h6Umz/v9+9JDc8YwwD/O+u9ujjWJI6aZKuZQnh+Djp4jo/6Rbe9WrHHyiuJ68","$2a$05$dvQAXdOgI1cO0lDY6h9I3.iJGreEGL94qizgnGpR7BmfRZkKtSN/m")); 
     
     // System.out.println(decrypt("$2a$05$dvQAXdOgI1cO0lDY6h9I3.iJGreEGL94qizgnGpR7BmfRZkKtSN/m", "$2a$05$dvQAXdOgI1cO0lDY6h9I3.iJGreEGL94qizgnGpR7BmfRZkKtSN/m"));
   
    
     // System.out.println("DECRIPTAR : "+decrypt("qZRtWC7+nNdAh7Dm86tUE7WmfT9WO13ujvtJNARRFwGC0eF16+RqhQCFSokF/jOv7UvOXfJGTFugX+U79xcGtOKutGiZvqUgf1Tfw/slggBxpf2WIrvRmyCN5ooxgbhXUiGWM/Jten5HqO9R0HUcAg==","$2a$05$dvQAXdOgI1cO0lDY6h9I3.iJGreEGL94qizgnGpR7BmfRZkKtSN/m")); 
      
    

      
      
      

    } 
    

}
