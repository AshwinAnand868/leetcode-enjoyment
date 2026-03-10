class Solution {
    public int secondsToRemoveOccurrences(String s) {
        // char[] chars = s.toCharArray();
        int seconds = 0;
        int zeros = 0;

        for(int i = 0; i < s.length(); ++i) {
            zeros += s.charAt(i) == '0' ? 1 : 0;

            if(zeros > 0 && s.charAt(i) == '1') {
                seconds = Math.max(seconds + 1, zeros);
            }
        }

        return seconds;


        // for (int i = 0; i < chars.length; ++i) {
        //     boolean didSwap = false;
        //     for (int j = 0; j < chars.length - 1; ++j) {
        //         if (s.charAt(j) == '0' && s.charAt(j + 1) == '1') {
        //             chars[j + 1] = '0';
        //             chars[j] = '1';
        //             didSwap = true;
        //         }
        //     }

        //     s = new String(chars);

        //     if (!didSwap) {
        //         break;
        //     }
        //     seconds++;
        // }

        // return seconds;
    }
}