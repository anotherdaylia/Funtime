package com.lia.HashMap;

import java.util.HashMap;

/**
 * Created by liqu on 4/12/16.
 */
public class BullsAndCows_299 {
    /*
     referenced code 1
     Note:
     1. The Java language provides special support for the string concatenation operator ( + ),
     and for conversion of other objects to strings. StringTag concatenation is implemented
     through the StringBuilder(or StringBuffer) class and its append method.
     2. Subtract '0' from a char get an int
     The casting is always done automatically if arithmetics are involved
    */

    public String getHint(String secret, String guess) {
        int size = secret.length();
        int[] secretarr = new int[10];
        int[] guessarr = new int[10];
        int bull = 0, cow = 0;

        for(int i = 0; i < size; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                secretarr[secret.charAt(i) - '0']++;
                guessarr[guess.charAt(i) - '0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            cow += Math.min(secretarr[i], guessarr[i]);
        }

        return "" + bull + "A" + cow + "B";
    }

    public String getHintHT(String secret, String guess) {
        int size = secret.length();
        int bull = 0, cow = 0;
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> gmap = new HashMap<>();

        for (int i = 0; i < size; i++) {
            char schar = secret.charAt(i);
            char gchar = guess.charAt(i);
            if (schar == gchar){
                bull++;
            } else{
                if(smap.containsKey(schar)){
                    smap.put(schar, smap.get(schar) + 1);
                } else {
                    smap.put(schar, 1);
                }

                if(gmap.containsKey(gchar)){
                    gmap.put(gchar, gmap.get(gchar) + 1);
                } else {
                    gmap.put(gchar, 1);
                }
            }
        }

        for(char c : gmap.keySet()) {
            if(smap.containsKey(c)) {
                cow += Math.min(smap.get(c), gmap.get(c));
            }
        }

        return (bull + "A" + cow + "B");
    }
}
