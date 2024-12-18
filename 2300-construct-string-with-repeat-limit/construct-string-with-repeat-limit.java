class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
                int[] count = new int[26];

        for (int i = 0; i < s.length(); ++i) {
            count[s.charAt(i) - 'a']++;
        }

        String result;
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < 26; ++i) {
            if (count[i] > 0) {
                char ch = (char) ('a' + i);
                pq.offer(ch);
            }
        }

        while (!pq.isEmpty()) {
            char maxCh = pq.poll();
            int freq = Math.min(repeatLimit, count[maxCh - 'a']);
            sb.append(String.valueOf(maxCh).repeat(freq));
            count[maxCh - 'a'] -= freq;

            if (count[maxCh - 'a'] > 0 && !pq.isEmpty()) {
                char nextMaxCh = pq.poll();
                sb.append(nextMaxCh);
                count[nextMaxCh - 'a']--;

                if (count[nextMaxCh - 'a'] > 0) {
                    pq.offer(nextMaxCh);
                }
                pq.offer(maxCh);
            }
        }

        result = sb.toString();

        return result;
//         int[] count = new int[26];

//         for (int i = 0; i < s.length(); ++i) {
//             count[s.charAt(i) - 'a']++;
//         }

//         String result;
//         StringBuilder sb = new StringBuilder();

//         int i = 25;

//         while (i >= 0) {
//             if (count[i] == 0) {
//                 i--;
//                 // skip the iteration
//                 continue;
//             }

//             int freq = Math.min(count[i], repeatLimit);
//             char ch = (char) (i + 'a');
//             sb.append(String.valueOf(ch).repeat(freq));
//             count[i] -= freq;

//             if (count[i] > 0) {
//                 int j = i - 1;

//                 while (j >= 0 && count[j] == 0) {
//                     j--;
//                 }

//                 if (j < 0) {
//                     break; // no further character
//                 }

//                 char chIn = (char) (j + 'a');
//                 sb.append(chIn);
//                 count[j]--;
//             }

//         }

//         result = sb.toString();

//         return result;
    }
}