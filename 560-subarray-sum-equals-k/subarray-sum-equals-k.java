class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;

        HashMap<Integer, Integer> sumOccurencesMap = new HashMap<>();
        sumOccurencesMap.put(0, 1); // considering a sum of 0 with one occurence

        int sum = 0;

        for(int i = 0; i < nums.length; ++i) {
            sum += nums[i];

            int rem = sum - k; // number of times remaining occurred will be the number of times k occurred
            if(sumOccurencesMap.containsKey(rem)) {
                count += sumOccurencesMap.get(rem);
            }

            sumOccurencesMap.merge(sum, 1, Integer::sum);
        }

        return count;

        // for(int start = 0; start < nums.length; ++start) {
        //     int sum = 0;
        //     for(int end = start; end < nums.length; ++end) {
        //         sum += nums[end];

        //         if(sum == k) {
        //             count++;
        //         }
        //     }
        // }

        // return count;
    }
}