class Solution {
    public int missingNumber(int[] nums) {
       int n = nums.length;
       int xor1 = 0, xor2 = 0;

       for(int i = 0; i < n; ++i) {
            xor1 = xor1 ^ nums[i];
            xor2 = xor2 ^ i;
       }

       xor2 = xor2 ^ n; // xor of the last digit from 0 to n inclusive

       return xor1 ^ xor2;
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
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