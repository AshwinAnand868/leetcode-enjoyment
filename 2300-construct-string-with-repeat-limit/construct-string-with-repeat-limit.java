class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];

        for (int i = 0; i < s.length(); ++i) {
            count[s.charAt(i) - 'a']++;
        }

        String result;
        StringBuilder sb = new StringBuilder();

        int i = 25;

        while (i >= 0) {
            if (count[i] == 0) {
                i--;
                // skip the iteration
                continue;
            }

            int freq = Math.min(count[i], repeatLimit);
            char ch = (char) (i + 'a');
            sb.append(String.valueOf(ch).repeat(freq));
            count[i] -= freq;

            if (count[i] > 0) {
                int j = i - 1;

                while (j >= 0 && count[j] == 0) {
                    j--;
                }

                if (j < 0) {
                    break; // no further character
                }

                char chIn = (char) (j + 'a');
                sb.append(chIn);
                count[j]--;
            }

        }

        result = sb.toString();

        return result;
    }
}