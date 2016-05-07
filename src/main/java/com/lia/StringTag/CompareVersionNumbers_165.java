package com.lia.StringTag;

/**
 * Compare two version numbers version1 and version2.
 If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

 Here is an example of version numbers ordering:

 0.1 < 1.1 < 1.2 < 13.37
 * Created by liqu on 5/5/16.
 */
public class CompareVersionNumbers_165 {
    public int compareVersion(String version1, String version2) {
        String[] vlevels1 = version1.split("\\.");
        String[] vlevels2 = version2.split("\\.");

        int length = (vlevels1.length > vlevels2.length) ? vlevels1.length : vlevels2.length;

        for (int i = 0; i < length; i++) {
            int v1 = (vlevels1.length >= i + 1) ? Integer.valueOf(vlevels1[i]): 0;
            int v2 = (vlevels2.length >= i + 1) ? Integer.valueOf(vlevels2[i]): 0;

            if (v1 < v2) return -1;
            else if (v1 > v2) return 1;
        }

        return 0;
    }
}
