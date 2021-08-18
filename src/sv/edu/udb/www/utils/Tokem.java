package sv.edu.udb.www.utils;

import java.util.Random;

public class Tokem {
    public String tokem() {
        String tokem ="";
        Random r = new Random();

        String alphabet = "4S91gH";
        for (int i = 0; i < 8; i++) {
            tokem += (alphabet.charAt(r.nextInt(alphabet.length())));
        }
        return tokem;
    }
}
