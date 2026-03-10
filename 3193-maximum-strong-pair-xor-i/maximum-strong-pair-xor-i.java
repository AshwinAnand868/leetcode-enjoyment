class Solution {
    public int maximumStrongPairXor(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;
        int l = 0;
        int r = 0;
        int maxXor = 0;

        while (r < n) {
            int x = nums[l];
            int y = nums[r];

            if (y - x > x) {
                l++;
            } else {
                for (int i = l; i < r; i++) {
                    maxXor = Math.max(maxXor, nums[i] ^ y);
                }
                r++;
            }
        }

        return maxXor;
        
//         int maxXor = Integer.MIN_VALUE;
        
//         for(int i = 0; i < nums.length; i++) {
//             for(int j = 0; j < nums.length; j++) {
//                 int difference = Math.abs(nums[i] - nums[j]);
                
//                 int min = Math.min(nums[i], nums[j]);
                
//                 if(difference <= min) {
//                     System.out.println("Strong pairs" + nums[i] + ", " + nums[j]);
//                     int xor = nums[i] ^ nums[j];
//                     maxXor = Math.max(maxXor, xor);
//                 }
//             }
//         }
        
//         return maxXor;
    }
}