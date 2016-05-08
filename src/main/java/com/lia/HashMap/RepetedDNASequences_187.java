package com.lia.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * For example,
 *
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 *
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 *
 * Created by liqu on 4/27/16.
 */
public class RepetedDNASequences_187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> seqlist = new ArrayList<>();
        if(s.length() <= 10) return seqlist;

        HashMap<String, Integer> map = new HashMap<>();
        map.put(s.substring(0, 10), 1);

        int lo = 1, hi = 11;
        while(hi <= s.length()) {
            if(map.containsKey(s.substring(lo, hi))) {
                //System.out.println("lo= " + lo + ", hi= " + hi );
                map.put(s.substring(lo, hi), map.get(s.substring(lo, hi)) + 1);
            } else {
                //System.out.println("s.substring(lo, hi)= " + s.substring(lo, hi) );
                map.put(s.substring(lo, hi), 1);
            }
            lo++;
            hi++;
        }

        for(String seq : map.keySet()){
            if (map.get(seq) > 1){
                seqlist.add(seq);
            }
        }

        return seqlist;
    }
}
