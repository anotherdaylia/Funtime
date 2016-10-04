package com.lia.DP;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
 * (each operation is counted as 1 step.)
 *
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 *
 * Created by liqu on 9/25/16.
 */
public class EditDistance_72 {
    final int MATCH = 0;
    final int INSERT = 1;
    final int DELETE = 2;

    public int minDistance(String word1, String word2) {
        int x = word1.length(); // text length
        int y = word2.length(); // pattern length
        int[] opt = new int[3]; // three operation types
        int[][] distance = new int[x + 1][y + 1]; // DP cache for distance

        // helper initialization
        for (int i = 0; i <= x; i++) distance[i][0] = i;
        for (int j = 0; j <= y; j++) distance[0][j] = j;

        for (int i = 1; i <= x; i++){
            for (int j = 1; j <= y; j++){
                // word1[i] and word2[i] same or need replacement
                opt[MATCH] = distance[i-1][j-1] + match(word1.charAt(i-1), word2.charAt(j-1));
                // insert to word1 and pay for the cost
                opt[INSERT] = distance[i-1][j] + 1;
                // delete from word1 and pay for the cost
                opt[DELETE] = distance[i][j-1] + 1;

                // update distance[i][j] with the minimal of the three ops
                distance[i][j] = Math.min(opt[MATCH], Math.min(opt[INSERT], opt[DELETE]));
            }
        }
        return distance[x][y];
    }

    /*
    A helper function determine if word1[i] and word2[i] need replacement
     */
    private int match(char s, char t) {
        if (s == t) return 0;
        else return 1;
    }
}
