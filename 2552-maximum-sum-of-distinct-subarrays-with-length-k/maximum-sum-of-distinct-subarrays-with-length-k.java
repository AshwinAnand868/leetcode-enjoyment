class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int i = 0, j = 0;
        int n = nums.length;

        Set<Integer> set = new HashSet<>();
        long sum = 0, maxSum = 0;

        while (j < n) {
            while (set.contains(nums[j])) {
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }

            set.add(nums[j]);
            sum += nums[j];

            if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }

            j++;
        }

        return maxSum;
    }
}

// class Solution {
//     public long maximumSubarraySum(int[] nums, int k) {
//         int i = 0, j = 0;
//         int n = nums.length;

//         Set<Integer> set = new HashSet<>();
//         long maxSum = Integer.MIN_VALUE;

//         while(j < n) {
//             set.add(nums[j]);

//             if(j - i + 1 == k) {
//                 if(set.size() == k) {
//                     long sum = 0;
//                     for(int elem : set) {
//                         sum += elem;
//                     }
//                     maxSum = Math.max(maxSum, sum);
//                 }
                
//                 set.remove(nums[i]);
//                 i++;
//             }

//             ++j;
//         }

//         return maxSum == Integer.MIN_VALUE ? 0 : maxSum;
//     }
// }