class Solution {
    public int missingNumber(int[] nums) {
       int n = nums.length;

       Arrays.sort(nums);

       for(int i = 0; i < n; ++i) {
            if(nums[i] != i) {
                return i;
            }
       }
    
       return n;
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
        // int xor1 = 0;
        // int xor2 = 0;

        // for(int i = 0; i < nums.length; ++i) {
        //     xor1 ^= nums[i];
        // }

        // for(int i = 0; i <= nums.length; ++i) {
        //     xor2 ^= i;
        // }

        // return xor1 ^ xor2;

        // Arrays.sort(nums); // array
        // int n = nums.length;

        // for(int i = 0; i < n; ++i) {
        //     if(i != nums[i]) {
        //         return i;
        //     }
        // }

        // return n;
    }
}