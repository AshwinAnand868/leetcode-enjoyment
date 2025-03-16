class Solution {
    public int largestVariance(String s) {
        int result = 0;
        int[] count = new int[26];

        for(char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        for(char first = 'a'; first <= 'z'; ++first) {
            for(char second = 'a'; second <= 'z'; ++second) {
                if(count[first - 'a'] == 0 || count[second - 'a'] == 0) {
                    continue;
                }

                boolean hadSecond = false;
                int firstCount = 0;
                int secondCount = 0;


                for(char ch : s.toCharArray()) {
                    if(ch == first) firstCount++;
                    if(ch == second) secondCount++;

                    if (secondCount > 0) {
                        result = Math.max(result, firstCount - secondCount);
                    } else if (hadSecond) {
                        result = Math.max(result, firstCount - 1);
                    } 

                    if (secondCount > firstCount) {
                        secondCount = 0;
                        firstCount = 0;
                        hadSecond = true;
                    }
                }
            }
        }

        return result;
    }
}