package sv.edu.udb.www.utils;

import java.util.Random;

public class Token {
    public String token() {
        String token ="";
        Random r = new Random();

        String alphabet = "abcdefghijklmnopqrstuvwxyz"
        				+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        				+ "1234567890";
        
        for (int i = 0; i < 8; i++) {
            token += (alphabet.charAt(r.nextInt(alphabet.length())));
        }
        
        return token;
    }
}
