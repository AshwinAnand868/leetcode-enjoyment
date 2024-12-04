class Solution {
    public int divisorSubstrings(int num, int k) {
        String numString = Integer.toString(num);
        int begin = 0;
        int kBeauty = 0;
        int windowSize = k;

        for (int end = windowSize; end <= numString.length(); end++) {
            String temp = numString.substring(begin, end);
            int target = Integer.parseInt(temp);

            if (target != 0 && num % target == 0) {
                kBeauty++;
            }

            begin++;
        }

        return kBeauty;

    }
}