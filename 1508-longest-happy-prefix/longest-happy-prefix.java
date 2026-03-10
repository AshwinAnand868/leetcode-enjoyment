class AshwinRocks {
    
}

class Solution {

    // Part of the KMP algorighm also helps us compute the length of Longest Prefix Suffix
    public int[] computeLPS(String s) {
        int m = s.length();
        int[] lps = new int[m];

        int i = 1, len = 0;
        
        while(i < m) {
            if(s.charAt(i) == s.charAt(len)) {
                len++; // increment the curr len
                lps[i] = len;
                i++;
            } else {
                if(len == 0) {
                    lps[i] = 0; // optional: by default 0
                    i++;
                } else {
                    // update len to prev
                    len = lps[len - 1];
                }
            }
        }

        return lps;
    }

    public String longestPrefix(String s) {

        int[] lps = computeLPS(s);

        return s.substring(0, lps[lps.length - 1]);        

        // Using Substrings
        // int suffixPointer = s.length() - 1;
        // int prefixPointer = 1;
        // String result = "";
        // for(int i = 0; i < s.length(); ++i) {
        //     String currPrefix = s.substring(0, prefixPointer);
        //     String currSuffix = s.substring(suffixPointer);
        //     prefixPointer++;
        //     suffixPointer--;

        //     if(!currPrefix.equals(s) && currPrefix.equals(currSuffix)) {
        //         result = currPrefix;
        //     }
        // }

        // return result;
    }
}