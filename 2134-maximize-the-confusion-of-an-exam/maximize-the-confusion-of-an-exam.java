class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {

        // Optimized 1 Time Sliding Window
        Map<Character, Integer> tfMap = new HashMap<>();
        tfMap.put('T', 0);
        tfMap.put('F', 0);

        int i = 0, j = 0;

        int n = answerKey.length();
        int maxCount = 0;

        while(j < n) {
            // increment the count for current character in the map
            tfMap.put(answerKey.charAt(j), tfMap.get(answerKey.charAt(j)) + 1);
            
            int countT = tfMap.get('T');
            int countF = tfMap.get('F');
            int min = Math.min(countT, countF); 

            if(min > k) {
                // decrement the count for character at i
                tfMap.put(answerKey.charAt(i), tfMap.get(answerKey.charAt(i)) - 1);
                i++;
            }

            maxCount = Math.max(maxCount, j - i + 1);

            ++j;

        }

        return maxCount;


        // Sliding Window O(n) - 2 Times Sliding Winow
        // return Math.max(calculate(answerKey.toCharArray(), k, 'F'),
                            // calculate(answerKey.toCharArray(), k, 'T'));

        // Brute Force - O(2^n) - TLE :-|
        // return helper(answerKey.toCharArray(), 0, k);
    }

    private int calculate(char[] arr, int k, char target) {
        int i = 0, j = 0, n = arr.length;
        int count = 0;
        int maxLen = 0;

        while(j < n) {
            if(arr[j] == target) {
                count++; // this will be replaced with other desired char, so increment count
            }

            // if # operations become greater than k
            while(count > k) {
                if(arr[i] == target) {
                    count--;
                }
                i++;
            }
            
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        return maxLen;
    }

    private int helper(char[] answerKey, int index, int flipsLeft) {
        if(index == answerKey.length || flipsLeft <= 0) {
            return getMaxConsecutives(answerKey);
        }

        // skip
        int skip = helper(answerKey, index + 1, flipsLeft);

        // take
        char original = answerKey[index];
        answerKey[index] = (answerKey[index] == 'T') ? 'F' : 'T';
        int take = helper(answerKey, index + 1, flipsLeft - 1);
        answerKey[index] = original;

        return Math.max(take, skip);
    }

    private int getMaxConsecutives(char[] arr) {
        int count = 1; // starting from 2nd character in the loop
        int max = 0;

        for(int i = 1; i < arr.length; ++i) {
            if(arr[i] == arr[i - 1]) {
                count++;
            } else {
                count = 1; // reset count
            }
            max = Math.max(max, count);
        }

        return Math.max(1, max);
    }
}