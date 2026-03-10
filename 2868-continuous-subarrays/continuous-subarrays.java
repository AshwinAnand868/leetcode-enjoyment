class Solution {
    public long continuousSubarrays(int[] nums) {
        
        long count = 0;

        int i = 0;
        int j = 0;
        int n = nums.length;

        // [value, frequency] sorted map
        TreeMap<Integer, Integer> map = new TreeMap<>();

        while (j < n) {

            map.merge(nums[j], 1, Integer::sum);

            while ((map.lastEntry().getKey() - map.firstEntry().getKey()) > 2) {
                map.merge(nums[i], -1, Integer::sum);

                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                // shrink the window
                i++;
            }

            count += j - i + 1;
            j++;
        }

        return count;

        
//         long count = 0;
        
//         for(int start = 0; start < nums.length; start++) {
//             int max = nums[start];
//             int min = nums[start];
            
//             int end = start;
            
//             // go through every possible case of the current subarray
//             while(end < nums.length) {
                
//                 // if the difference between max and min of the sub array meets the given condition, then that array is continuous
//                 max = Math.max(nums[end], max);
//                 min = Math.min(nums[end], min);
                
//                 // nums is a positive integers array
//                 if(max - min <= 2) {
//                     count++;
//                     // expand the window
//                     end++;
//                 } else {
//                     break;
//                 }
//             }
//         }
        
//         return count;
    }
}