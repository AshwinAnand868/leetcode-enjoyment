class Solution {
    public String longestCommonPrefix(String[] strs) {

        // Vertical Scanning (O m * n) // in the 
        if(strs == null || strs.length == 0) return ""; // no prefix

        for(int i = 0; i < strs[0].length(); ++i) {
            char c = strs[0].charAt(i);

            for(int j = 1; j < strs.length; ++j) {
                if( i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];

        // Using sorting
        // StringBuilder ans = new StringBuilder();
        // Arrays.sort(strs);

        // String first = strs[0];
        // String last = strs[strs.length - 1];

        // int minLength = Math.min(first.length(), last.length());

        // for(int i = 0; i < minLength; ++i) {
        //     if (first.charAt(i) != last.charAt(i)) {
        //         return ans.toString();
        //     }
        //     ans.append(first.charAt(i));
        // }

        // return ans.toString();

    }
}