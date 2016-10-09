package com.lia.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 *
 * Created by liqu on 10/4/16.
 */
public class RestoreIPAddress_93 {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        if (n > 12 || n < 4) return res;
        restore(s, new StringBuilder(), 0, 0);
        return res;
    }

    private void restore(String s, StringBuilder sb, int dotCount, int index) {
        if (dotCount == 4 && index == s.length()) {
            res.add(sb.toString());
        }

        for (int i = 1; i < 4; i++) {
            int end = index + i;
            if (end > s.length()) break; // no sufficient char left
            String subIP = s.substring(index, end);

            // validate leading 0 and numeric value < 255
            if (subIP.startsWith("0") && subIP.length() > 1) continue;
            if (Integer.parseInt(subIP) > 255) continue;

            sb.append(subIP);
            if (dotCount < 3) sb.append('.');
            restore(s, sb, dotCount + 1, index + i);
            if (dotCount < 3) sb.deleteCharAt(sb.length() - 1);
            sb.delete(sb.length() - subIP.length(), sb.length());
        }
    }
}
