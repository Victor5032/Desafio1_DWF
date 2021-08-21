package sv.edu.udb.www.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha1 {
    public String sha1Hash(String sha) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        
        byte[] result = md.digest(sha.getBytes());
        
        StringBuffer hashString = new StringBuffer();
        
        for (int i = 0; i < result.length; i++) {
            hashString.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        return hashString.toString();
    }
}
