class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;

        if(n == 0) {
            return new ArrayList<>();
        }

        int startRange = nums[0];
        int endRange = nums[0];
        int prev = nums[0];

        for(int i = 1; i < n; ++i) {
            int curr = nums[i];

            if(curr - prev == 1) {
                endRange++;
            } else {
                if (startRange == endRange) {
                    result.add(String.valueOf(startRange));
                } else {
                    result.add(startRange + "->" + endRange);
                }
                startRange = curr;
                endRange = curr;
            }
            prev = curr;
        }

        if (startRange == endRange) {
            result.add(String.valueOf(startRange));
        } else {
            result.add(startRange + "->" + endRange);
        }

        return result;
    }
}